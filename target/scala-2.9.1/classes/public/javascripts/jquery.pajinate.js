;
(function($) { /*******************************************************************************************/
	// jquery.pajinate.js - version 0.4
	// A jQuery plugin for paginating through any number of DOM elements
	// 
	// Copyright (c) 2010, Wes Nolte (http://wesnolte.com)
	// Licensed under the MIT License (MIT-LICENSE.txt)
	// http://www.opensource.org/licenses/mit-license.php
	// Created: 2010-04-16 | Updated: 2010-04-26
	//
	/*******************************************************************************************/

	$.fn.pajinate = function(options) {
		// Set some state information
		var current_page = 'current_page';
		var items_per_page = 'items_per_page';

		var meta;

		// Setup default option values
		var defaults = {
			item_container_id: '.content',
			items_per_page: 10,
			nav_panel_id: '.page_navigation',
			nav_info_id: '.info_text',
			num_page_links_to_display: 20,
			start_page: 0,
			wrap_around: false,
			nav_label_first: 'First',
			nav_label_prev: 'Prev',
			nav_label_next: 'Next',
			nav_label_last: 'Last',
			nav_order: ["first", "prev", "num", "next", "last"],
			nav_label_info: 'Showing {0}-{1} of {2} results',
			show_first_last: true,
			abort_on_small_lists: true,
			jquery_ui: false,
			jquery_ui_active: "ui-state-highlight",
			jquery_ui_default: "ui-state-default",
			jquery_ui_disabled: "ui-state-disabled"
		};

		var options = $.extend(defaults, options);
		var $item_container;
		var $page_container;
		var $items;
		var $nav_panels;
		var total_page_no_links;
		var jquery_ui_default_class = options.jquery_ui ? options.jquery_ui_default : '';
		var jquery_ui_active_class = options.jquery_ui ? options.jquery_ui_active : '';
		var jquery_ui_disabled_class = options.jquery_ui ? options.jquery_ui_disabled : '';

		return this.each(function() {
			$page_container = $(this);
			$item_container = $(this).find(options.item_container_id);
			$items = $page_container.find(options.item_container_id).children();

			if (options.abort_on_small_lists && options.items_per_page >= $items.size()) return $page_container;

			meta = $page_container;

			// Initialize meta data
			meta.data(current_page, 0);
			meta.data(items_per_page, options.items_per_page);

			// Get the total number of items
			var total_items = $item_container.children().size();

			// Calculate the number of pages needed
			var number_of_pages = Math.ceil(total_items / options.items_per_page);

			// Construct the nav bar
			var first = !options.show_first_last ? '' : '<li class="first_link"><a href="#">' + options.nav_label_first + '</a></li>';
			var last = !options.show_first_last ? '' : '<li class="last_link"><a href="#">' + options.nav_label_last + '</a></li>';

			var navigation_html = '<ul class="unstyled">';

			for (var i = 0; i < options.nav_order.length; i++) {
				switch (options.nav_order[i]) {
				case "first":
					navigation_html += first;
					break;
				case "last":
					navigation_html += last;
					break;
				case "next":
					navigation_html += '<li class="next_link"><a href="#">' + options.nav_label_next + '</a></li>';
					break;
				case "prev":
					navigation_html += '<li class="previous_link"><a href="#">' + options.nav_label_prev + '</a></li>';
					break;
				case "num":
					var current_link = 0;
					while (number_of_pages > current_link) {
						navigation_html += '<li class="page_link" longdesc="' + current_link + '"><a href="#">' + (current_link + 1) + '</a></li>';
						current_link++;
					}
					break;
				default:
					break;
				}

			}
			navigation_html += "</ul>"
			// And add it to the appropriate area of the DOM	
			$nav_panels = $page_container.find(options.nav_panel_id);
			$nav_panels.html(navigation_html).each(function() {
				$(this).find('ul li.page_link:first').addClass('first');
				$(this).find('ul li.page_link:last').addClass('last');

			});

			// Hide the more/less indicators
			// $nav_panels.children('li span.ellipse').hide();

			// Set the active page link styling
			$nav_panels.find('li .previous_link').next().next().addClass('active_page ' + jquery_ui_active_class);

			/* Setup Page Display */
			// And hide all pages
			$items.hide();
			// Show the first page			
			$items.slice(0, meta.data(items_per_page)).show();

			/* Setup Nav Menu Display */
			// Page number slices
			total_page_no_links = $page_container.children(options.nav_panel_id + ':first').find("ul li.page_link").size();
			// options.num_page_links_to_display = Math.min(options.num_page_links_to_display, total_page_no_links);

			$nav_panels.find('ul li.page_link').hide(); // Hide all the page links
			// And only show the number we should be seeing
			$nav_panels.each(function() {
				$(this).find('ul li.page_link').slice(0, options.num_page_links_to_display).show();
			});

			/* Bind the actions to their respective links */

			// Event handler for 'First' link
			$page_container.find('ul li.first_link').click(function(e) {
				e.preventDefault();
				gotopage(0);
			});

			// Event handler for 'Last' link
			$page_container.find('ul li.last_link').click(function(e) {
				e.preventDefault();
				var lastPage = $nav_panels.find('ul li.last').attr("longdesc")
				// var lastPage = total_page_no_links - 1;
				gotopage(lastPage);
			});

			// Event handler for 'Prev' link
			$page_container.find('li.previous_link').click(function(e) {
				e.preventDefault();
				new_page = parseInt(meta.data(current_page)) - 1;
				if(new_page != -1) {
					gotopage(new_page);
				}
			});

			// Event handler for 'Next' link
			$page_container.find('li.next_link').click(function(e) {
				e.preventDefault();
				new_page = parseInt(meta.data(current_page)) + 1;
				if(new_page != number_of_pages) {
					gotopage(new_page);
				}
			});

			// Event handler for each 'Page' link
			$page_container.find('.page_link').click(function(e) {
				e.preventDefault();
				gotopage($(this).attr('longdesc'));
			});
			
			if(parseInt($nav_panels.find('ul li.last').attr("longdesc")) < 2) {
				$nav_panels.hide();
			}
			// Goto the required page
			gotopage(0);
		});

		function gotopage(page_num) {

			var ipp = parseInt(meta.data(items_per_page));

			// Find the start of the next slice
			start_from = page_num * ipp;

			// Find the end of the next slice
			end_on = start_from + ipp;
			// Hide the current page	
			var items = $items.hide().slice(start_from, end_on);

			items.show();

			// Reassign the active class
			$page_container.find(options.nav_panel_id).find('ul li.page_link[longdesc=' + page_num + ']').addClass('disabled').siblings('.disabled').removeClass('disabled');

			// Set the current page meta data							
			meta.data(current_page, page_num);
			
			// update num pages to display
			var delta = options.num_page_links_to_display;
			var nbPages = $page_container.find(options.nav_panel_id).find('ul li.page_link').length;
			var curPageNum = parseInt(page_num);
			var nbBefore = Math.min(curPageNum, delta);
			var nbAfter = (delta - nbBefore) + delta + 1;
			var startPage = Math.max(0, curPageNum - nbBefore);
			var endPage = Math.min(nbPages, curPageNum + nbAfter);
			$nav_panels.each(function() {
				$(this).find('ul li.page_link').hide() // Hide all the page links
				.slice(startPage, endPage).show();
			});
			
			// Add a class to the next or prev links if there are no more pages next or previous to the active page
			if ($nav_panels.find('ul li.first').hasClass('disabled')) {
				$nav_panels.find('ul li.previous_link').addClass('disabled')
				$nav_panels.find('ul li.first_link').addClass('disabled')
			}
			if ($nav_panels.find('ul li.last').hasClass('disabled')) {
				$nav_panels.find('ul li.next_link').addClass('disabled')
				$nav_panels.find('ul li.last_link').addClass('disabled')
			}
		}
	};

})(jQuery);
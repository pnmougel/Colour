(function() {
  $('.typeAhead').typeahead({
    source: function(query, process) {
      return $.get("/search/json", {
        query: query
      }, function(data) {
        return process(data.options);
      });
    }
  });
  $("#displayAdvancedSearch").click(function() {
    return $("#advancedSearch").slideToggle();
  });
  window.toggleLongText = function(key) {
    var moreText;
    $("#longTextDots_" + key).toggle();
    $("#longText_" + key).toggle();
    moreText = $("#longTextShow_" + key).text() === " Less" ? " More" : " Less";
    return $("#longTextShow_" + key).text(moreText);
  };
  window.message = {
    addMessage: function(message, panel, timed, type, strong) {
      if (panel == null) {
        panel = "#messageAreaTop";
      }
      if (timed == null) {
        timed = true;
      }
      $(panel).append("<div class=\"alert " + type + "\">\n    <button class=\"close\" data-dismiss=\"alert\">×</button>\n    <strong>" + strong + "</strong> " + message + "\n</div>");
      return $("div.alert").delay(5000).hide("clip");
    },
    addInfo: function(message, panel, timed) {
      if (panel == null) {
        panel = "#messageAreaTop";
      }
      if (timed == null) {
        timed = true;
      }
      return this.addMessage(message, panel, timed, "alert-info", "Info:");
    },
    addSuccess: function(message, panel, timed) {
      if (panel == null) {
        panel = "#messageAreaTop";
      }
      if (timed == null) {
        timed = true;
      }
      return this.addMessage(message, panel, timed, "alert-success", "Success:");
    },
    addWarning: function(message, panel, timed) {
      if (panel == null) {
        panel = "#messageAreaTop";
      }
      if (timed == null) {
        timed = true;
      }
      return this.addMessage(message, panel, timed, "", "Warning:");
    },
    addError: function(message, panel, timed) {
      if (panel == null) {
        panel = "#messageAreaTop";
      }
      if (timed == null) {
        timed = true;
      }
      return this.addMessage(message, panel, timed, "alert-error", "Error:");
    }
  };
  jQuery(document).ready(function() {
    jQuery("time.timeago").timeago();
    return prettyPrint();
  });
  $("#btn_show_new_conf").click(function() {
    return $("#form_new_conf").toggle("fast");
  });
  $('div').tooltip();
  $('#test').tooltip({
    'trigger': 'focus',
    'title': 'Password tooltip'
  });
  $("#test").tooltip({
    animation: false,
    placement: top
  });
}).call(this);
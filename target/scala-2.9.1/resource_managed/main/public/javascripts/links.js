(function() {
  $("#btn_show_new_url").click(function() {
    return $(".add_url_form").slideToggle("fast");
  });
  $("#submit_add_url").click(function() {
    return $.ajax({
      url: '/link',
      type: 'POST',
      data: {
        url: $("#input_form_add_url").val(),
        conference_id: $("#id").val(),
        label: $("#formAddUrlLabel").val()
      },
      success: function(data) {
        $('#confLinks').append(data);
        return $(".add_url_form").slideToggle("fast");
      },
      error: function(data) {
        return message.addError(data.responseText);
      },
      complete: function(data, x, e) {}
    });
  });
  window.deleteUrl = function(id) {
    $.ajax({
      type: 'DELETE',
      url: '/link/' + id,
      success: function(data) {
        return $('#confLinks').append(data);
      }
    });
    return $('#link_' + id).hide("slow");
  };
}).call(this);

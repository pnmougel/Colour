(function() {
  /*
  Scripts for the comment actions
  */  $("#comment_field").blur(function() {
    return setTimeout((function() {
      $("#comment_field").attr("rows", 1);
      return $("#submit_add_comment").hide();
    }), 500);
  });
  $("#submit_add_comment").click(function() {
    $.ajax({
      url: '/comment',
      type: 'POST',
      data: {
        conference_id: $("#conference_id").val(),
        content: $("#comment_field").val()
      },
      success: function(data) {
        $('#confComments').prepend(data);
        $("#comment_field").val("");
        $("#comment_field").attr("rows", 1);
        $("#nb_comments").text(parseInt($("#nb_comments").text()) + 1);
        $("#submit_add_comment").hide();
        jQuery("time.timeago").timeago();
        if ($("#nb_comments").text() !== "0") {
          return $("#noComments").hide();
        }
      },
      error: function(data) {
        return message.addError(data.responseText);
      },
      complete: function(data, x, e) {
        $('#confComments').prepend(data);
        $("#comment_field").val("");
        $("#comment_field").attr("rows", 1);
        $("#submit_add_comment").hide();
        jQuery("time.timeago").timeago();
        if ($("#nb_comments").text() !== "0") {
          return $("#noComments").hide();
        }
      }
    });
    return false;
  });
  $("#comment_field").click(function() {
    if ($("#comment_field").attr("rows") !== "5") {
      $("#submit_add_comment").show();
    }
    return $("#comment_field").attr("rows", 5);
  });
  window.deleteComment = function(id) {
    return $.ajax({
      type: 'DELETE',
      url: '/comment/' + id,
      success: function(data) {
        $("#nb_comments").text(parseInt($("#nb_comments").text()) - 1);
        $('#comment_' + id).hide("slow");
        if ($("#nb_comments").text() === "0") {
          return $("#noComments").show();
        }
      }
    });
  };
}).call(this);
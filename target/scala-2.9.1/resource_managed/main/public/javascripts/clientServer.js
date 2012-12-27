(function() {
  var initBindings, updateMessage, updateProgressBar;
  $("#run").click(function() {
    var actionName;
    actionName = $("#run").attr("action");
    $.ajax({
      url: "/admin/action/run/" + actionName,
      type: 'GET',
      success: function(data) {},
      error: function(data) {},
      complete: function() {}
    });
    setInterval(function() {
      return updateProgressBar(actionName);
    }, 1000);
    return setInterval(function() {
      return updateMessage(actionName);
    }, 1000);
  });
  updateProgressBar = function(actionName) {
    return $.ajax({
      url: "/admin/action/percentage/" + actionName,
      type: 'GET',
      success: function() {},
      error: function(data) {},
      complete: function(data) {
        return $("#actionProgress").attr("style", "width:" + data.responseText + "%;");
      }
    });
  };
  updateMessage = function(actionName) {
    return $.ajax({
      url: "/admin/action/message/" + actionName,
      type: 'GET',
      success: function(data) {
        var content;
        if (data === "clear") {
          return $("#message_area").empty();
        } else {
          content = $(data);
          $("#message_area").prepend(content.filter(".logMessage"));
          $("#mainContent").append(content.not(".logMessage"));
          return initBindings();
        }
      },
      error: function(data) {},
      complete: function() {}
    });
  };
  initBindings = function() {
    $("button.sameAsPublication").unbind('click');
    $("button.createNewPublication").unbind('click');
    $("button.sameAsPublication").click(function() {
      var mergeId, publicationId;
      publicationId = $(this).attr("for");
      mergeId = $(this).attr("mergeId");
      console.log("Clicked !!");
      return $.ajax({
        url: "/admin/sameAsPublication",
        type: 'POST',
        data: {
          publicationId: publicationId,
          mergeId: mergeId
        },
        success: function(data) {
          return $("#merge_" + mergeId).remove();
        },
        error: function(data) {},
        complete: function() {
          return $("#merge_" + mergeId).remove();
        }
      });
    });
    return $("button.createNewPublication").click(function() {
      var mergeId;
      mergeId = $(this).attr("mergeId");
      return $.ajax({
        url: "/admin/createPublication",
        type: 'POST',
        data: {
          mergeId: mergeId
        },
        success: function(data) {
          return $("#merge_" + mergeId).remove();
        },
        error: function(data) {},
        complete: function() {
          return $("#merge_" + mergeId).remove();
        }
      });
    });
  };
  initBindings();
}).call(this);
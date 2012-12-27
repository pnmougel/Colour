(function() {
  var handleVote;
  $("#show_vote_form").click(function() {
    if ($("#hasVoted").val() === "true") {
      return $("#vote_remove").slideToggle("slow");
    } else {
      return $("#vote_form").slideToggle("slow");
    }
  });
  handleVote = function(voteId, color, score) {
    $(voteId).mouseenter(function() {
      return $(voteId).css("background-color", color).css('cursor', 'pointer');
    });
    $(voteId).mouseleave(function() {
      return $(voteId).css("background-color", '#F5F5F5');
    });
    return $(voteId).click(function() {
      $.ajax({
        url: '/vote',
        type: 'POST',
        data: {
          conference_id: $("#conference_id").val(),
          score: score
        },
        success: function(data) {
          $("#hasVoted").val('true');
          return $("#user_scores").html(data);
        },
        error: function(data) {
          return message.addError(data.responseText);
        }
      });
      return $("#vote_form").slideToggle("slow");
    });
  };
  handleVote("#vote_rankA", '#E6FFE6', 5);
  handleVote("#vote_rankB", '#FFF4E6', 4);
  handleVote("#vote_rankC", '#E6F7FF', 3);
  handleVote("#vote_rankD", '#FFE6E6', 1);
  $("#remove_vote").click(function() {
    return $.ajax({
      url: '/vote',
      type: 'DELETE',
      data: {
        conference_id: $("#conference_id").val()
      },
      success: function(data) {
        $("#hasVoted").val('false');
        $("#user_scores").html(data);
        return $("#vote_remove").slideToggle("slow");
      }
    });
  });
}).call(this);
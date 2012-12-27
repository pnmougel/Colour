

$("#toggleShowNewIdea").click( -> 
    $("#newIdea").slideToggle()
)

$("#page_container").show()

$('#page_container').pajinate({
    nav_label_first: '&laquo',
    nav_label_last: '&raquo',
    items_per_page : 5,
    abort_on_small_lists: true,
    num_page_links_to_display: 3,
})

$("button.voteUp").click( (e) ->
    ideaId = $(this).attr("for")
    curElement = $(this)
    console.log(ideaId)
    $.ajax(
        url: '/ideabox/vote/' + ideaId
        type: 'POST'
        success: (data) ->
            newNbVotes = parseInt($("#nbVotes_" + ideaId).text()) + 1
            $("#nbVotes_" + ideaId).text(newNbVotes)
            curElement.addClass("disabled")
            curElement.children().removeClass("icon-thumbs-up").addClass("icon-heart")
        error: (data) -> 
            message.addError(data.responseText)
        complete: (data, x, e) -> 
    )
)


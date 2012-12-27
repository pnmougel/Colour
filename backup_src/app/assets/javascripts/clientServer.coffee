
$("#run").click( ->
    actionName = $("#run").attr("action")

    $.ajax(
        url: "/admin/action/run/" + actionName
        type: 'GET'
        success: (data) ->
        error: (data) ->
        complete: () ->
    )

    setInterval( -> 
            updateProgressBar(actionName)
        1000)
    setInterval( -> 
            updateMessage(actionName)
        1000)
)

updateProgressBar = (actionName) -> 
	$.ajax(
        url: "/admin/action/percentage/" + actionName
        type: 'GET'
        success: () ->
        error: (data) ->
        complete: (data) ->
            $("#actionProgress").attr("style", "width:" + data.responseText+ "%;")
    )

updateMessage = (actionName) -> 
    $.ajax(
        url: "/admin/action/message/" + actionName
        type: 'GET'
        success: (data) ->
            $("#message_area").prepend(data)
        error: (data) ->
        complete: () ->
    )
    

        


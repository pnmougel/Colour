(function() {
  $("#btn_show_login").click(function() {
    return $("#form_login").slideToggle("fast");
  });
  $("#logout").click(function() {
    return $.ajax({
      url: '/user/logout',
      type: 'GET',
      success: function(data) {
        message.addSuccess(data);
        $("#btn_show_logout").hide();
        $("#btn_show_login").show();
        return location.reload();
      },
      error: function(data) {
        return message.addError(data.responseText);
      },
      complete: function() {}
    });
  });
  $("#form_login_sign_in").click(function() {
    return $.ajax({
      url: '/user/login',
      type: 'POST',
      data: {
        email: $("#email").val(),
        password: $("#password").val()
      },
      success: function(data) {
        return location.reload();
      },
      error: function(data) {
        return message.addError(data.responseText);
      },
      complete: function() {}
    });
  });
  $("#form_login_add_user").click(function() {
    return $.ajax({
      url: '/user/add',
      type: 'POST',
      data: {
        email: $("#email").val(),
        password: $("#password").val()
      },
      success: function(data) {
        $("#form_login").slideToggle("fast");
        return message.addSuccess(data);
      },
      error: function(data) {
        return message.addError(data.responseText);
      },
      complete: function() {}
    });
  });
}).call(this);

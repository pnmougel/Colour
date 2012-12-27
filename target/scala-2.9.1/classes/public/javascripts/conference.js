(function() {
  /*
  Scripts for the conference page
  */  window.selectText = function(element) {
    var doc, range, selection, text;
    doc = document;
    text = doc.getElementById(element);
    if (doc.body.createTextRange) {
      range = doc.body.createTextRange();
      range.moveToElementText(text);
      return range.select();
    } else if (window.getSelection) {
      selection = window.getSelection();
      range = doc.createRange();
      range.selectNodeContents(text);
      selection.removeAllRanges();
      return selection.addRange(range);
    }
  };
  $("#getTheBadge").click(function() {
    return $('#myModal').modal('show');
  });
  $("#selectUrl").click(function() {
    return selectText("widgetUrl");
  });
}).call(this);
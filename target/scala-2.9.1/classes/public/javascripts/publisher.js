(function() {
  $("#publisher_field").eComboBox({
    inputFieldName: "Add new publisher",
    onRemoveChoice: function(choice) {
      return $.ajax({
        url: '/publisher/' + choice,
        type: 'DELETE'
      });
    },
    onAddChoice: function(choice) {
      return $.ajax({
        url: '/publisher',
        type: 'POST',
        data: {
          name: choice
        }
      });
    }
  });
}).call(this);

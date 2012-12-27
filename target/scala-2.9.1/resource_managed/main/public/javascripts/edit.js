(function() {
  var checkChanges, checkSubfieldsUpdated, defaultCheckChanges, nameChanged, recordChanges, switchUpdated;
  var __indexOf = Array.prototype.indexOf || function(item) {
    for (var i = 0, l = this.length; i < l; i++) {
      if (this[i] === item) return i;
    }
    return -1;
  };
  switchUpdated = function(field, fieldLabel) {
    if ($(field).val() !== $(field).attr("prev")) {
      return $(fieldLabel).show();
    } else {
      return $(fieldLabel).hide();
    }
  };
  defaultCheckChanges = function(field) {
    return $(field).val() !== $(field).attr("prev");
  };
  switchUpdated = function(field, test) {
    if (test == null) {
      test = defaultCheckChanges;
    }
    if (test(field)) {
      return $(field + "_label_updated").show();
    } else {
      return $(field + "_label_updated").hide();
    }
  };
  recordChanges = function(field, test) {
    if (test == null) {
      test = defaultCheckChanges;
    }
    $(field).keyup(function() {
      return switchUpdated(field, test);
    });
    return $(field).change(function() {
      return switchUpdated(field, test);
    });
  };
  recordChanges("#description");
  recordChanges("#publisher");
  recordChanges("#startedOn");
  recordChanges("#type");
  recordChanges("#region");
  nameChanged = function() {
    if ($("#name").val() !== $("#name").attr("prev") || $("#shortName").val() !== $("#shortName").attr("prev")) {
      return $("#label_name_updated").show();
    } else {
      return $("#label_name_updated").hide();
    }
  };
  $("#name").keyup(nameChanged);
  $("#name").change(nameChanged);
  $("#shortName").keyup(nameChanged);
  $("#shortName").change(nameChanged);
  checkChanges = function() {
    var prevValue, value;
    prevValue = $("#id").attr("prev");
    return value = $("#id").val();
  };
  checkSubfieldsUpdated = function() {
    var curIds, prevIds;
    prevIds = $("#subFields").attr("prev").split(",").sort().join(",");
    curIds = $("#subFields").val();
    if (prevIds === curIds) {
      return $("#subFields_label_updated").hide();
    } else {
      return $("#subFields_label_updated").show();
    }
  };
  $("#resetYear").click(function() {
    return $("#startedOn").val(0);
  });
  window.removeSubfield = function(id) {
    var idx, subFieldIds;
    subFieldIds = $("#subFields").val().split(",");
    idx = subFieldIds.indexOf("" + id);
    if (idx !== -1) {
      subFieldIds.splice(idx, 1);
    }
    $("#subFields").val(subFieldIds.join(","));
    return checkSubfieldsUpdated();
  };
  $("#subfield_field").change(function() {
    var id, label, subFieldIds;
    label = $("#subfield_field :selected").text();
    id = $("#subfield_field").val();
    subFieldIds = $("#subFields").val().split(",");
    if (__indexOf.call(subFieldIds, id) < 0 && id !== "-1") {
      subFieldIds.push(id);
      subFieldIds.sort();
      if ($("#subFields").val() === "") {
        $("#subFields").val(id);
      } else {
        $("#subFields").val(subFieldIds.join(","));
      }
      $("#subFieldList").append("<div class='subfield' id='subfield_" + id + "'>" + label + "<button type='button' class='close' data-dismiss='alert'  onclick='removeSubfield(" + id + ");'>×</button></div>");
      $("#subfield_field").val("-1");
      return checkSubfieldsUpdated();
    }
  });
  $("#showHistory").click(function() {
    var action;
    action = $("#showHistory").text() === "View all" ? "all" : "limited";
    $("#showHistory").text(action === "all" ? "Reduce" : "View all");
    return $.ajax({
      url: '/history/' + action + '/' + $("#id").val(),
      type: 'GET',
      success: function(data) {
        return $('#history').html(data);
      },
      error: function(data) {
        return message.addError(data.responseText);
      },
      complete: function(data, x, e) {}
    });
  });
}).call(this);

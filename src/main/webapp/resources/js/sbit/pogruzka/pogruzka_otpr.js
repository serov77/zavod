$(function () {
    $('#datetimepicker1').datetimepicker(
        {pickTime: false, language: 'ru'}
    );
});

$("#datetimepicker1").on("dp.hide", function (e) {
    var x = $('#datetimepicker1').data("DateTimePicker").getDate();
    alert(x);
    //var y = x.replace(".", "-");
    //alert(y);
    var d = new Date();
    d.setTime(Date.parse(x));
    //var w = Date.parse($('#datetimepicker1').data("DateTimePicker").getDate());
var y = d.getDate()+"-"+ d.getMonth()+"-"+ d.getFullYear();
alert(y);
    $.ajax({
        url: "pogruzka/setDate/" + y,
        success: function (html) {
            $('#sertif_data').html(html);
        }
    });
});
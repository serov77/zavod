$(function () {
    $('#datetimepicker1').datetimepicker(
        {pickTime: false, language: 'ru'}
    );
});

$("#datetimepicker1").on("dp.change",function (e) {
    var x = $(this).data("DateTimePicker").getDate();
    var y = x.getFullYear();
    alert(x);
    $.ajax({
        url: "pogruzka/setDate/"+y,
        success: function (html) {
            $('#sertif_data').html(html);
        }
    });
});
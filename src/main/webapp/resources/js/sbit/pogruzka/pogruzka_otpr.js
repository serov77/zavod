/*$(document).ready(function () {
    $('.content').off('click');
});*/

$(function () {
    var date;
    date = new Date();
    $('#datetimepicker1').datetimepicker(
        {pickTime: false, language: 'ru'}
    );
});

$("#datetimepicker1").on("dp.hide", function (e) {
    var x = $('#datetimepicker1').data("DateTimePicker").getDate();
    var d = new Date();
    d.setTime(Date.parse(x));
    var y = d.getDate() + "-" + d.getMonth() + "-" + d.getFullYear();
    var z = $("input#gruz").val();
    $.ajax({
        url: "/zavod/pogruzka/setDate/" + z + "/" + d.getDate() + "/" + d.getMonth() + "/" + d.getFullYear(),
        success: function (html) {
            $('#sertif_data').html(html);
        }
    });
});
function otpravka() {
    var id = $('input#pogrId').val();
    var gruz = $('input#gruz').val();
    var sertId = $('select#sertId option:selected').val();

    $.ajax({
        url: '/zavod/pogruzka/otpr/save/' + gruz + '/' + id + '/' + sertId,
        success: function (html) {
            $('.modal-backdrop').hide(700);
            $('#myModal_2').modal().fadeIn(1000);
            showSbit('/zavod/pogruzka/all/0');
        }
    });
}

function editVagon(url) {
    $.ajax({
        url: url,
        beforeSend: function () {
            $('#mesto_body').html('<img src="/zavod/resources/img/ajax-loader.gif" />');
        },
        complete: function () {
            $('#mesto_body').show(100);
        },
        success: function (html) {
            $('#mesto').html(html);
        }
    });

}

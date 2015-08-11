$(function () {
    $('#datetimepicker1').datetimepicker(
        {pickTime: false, language: 'ru'}
    );
});

$("#datetimepicker1").on("dp.hide", function (e) {
    var x = $('#datetimepicker1').data("DateTimePicker").getDate();
    //alert(x);
    //var y = x.replace(".", "-");
    //alert(y);
    var d = new Date();
    d.setTime(Date.parse(x));
    //var w = Date.parse($('#datetimepicker1').data("DateTimePicker").getDate());
    var y = d.getDate() + "-" + d.getMonth() + "-" + d.getFullYear();
    var z = $("input#gruz").val();
//alert(z);
    $.ajax({
        url: "pogruzka/setDate/" + z + "/" + d.getDate() + "/" + d.getMonth()+ "/" + d.getFullYear(),
        success: function (html) {
            $('#sertif_data').html(html);
        }
    });
});
function otpravka() {
var id = $('input#pogrId').val();
var netto = $('input#netto').val();
var idVagon = $('input#idVag').val();
var gruz = {
    id: $('select#gruz option:selected').val(),
    name: $('select#gruz option:selected').text(),
};
var tara = {
    id: $('select#tara option:selected').val(),
    name: $('select#tara option:selected').text(),
};
var dopolneniya = $('#dopolneniya').val();
var pogruzka = {
    brutto: brutto,
    netto : netto,
    idVagon: idVagon,
    gruz: gruz,
    tara: tara,
    dopolneniya: dopolneniya
};

$.ajax({
    url: '/zavod/pogruzka/save',
    contentType: 'application/json; charset=utf-8',
    type: 'POST',
    data: JSON.stringify(pogruzka),
    success: function (html) {
        $('.modal-backdrop').hide(700);
        $('#myModal_2').modal().fadeIn(1000);
        showSbit('pogruzka/all');
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
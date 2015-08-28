$(document).ready(function () {


    var x = $('#id').val();
    $('#edit_form').bootstrapValidator({
        message: 'Это значение не подходит',
        fields: {
            "gruz.id": {
                validators: {
                    greaterThan: {
                        value: 1,
                        message: 'Поле не может быть пустым!'
                    }
                }
            },
            brutto: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым'
                    },
                    numeric: {
                        message: 'В поле можно вводить только цифры!'
                    },
                    greaterThan: {
                        value: 0.0001,
                        message: 'Введенное число должно быть больше 0!'
                    },
                    remote: {
                        url: 'valid_pogruzka_netto',
                        data: function (validator) {
                            return {
                                taraVag: validator.getFieldElements('vagon.tara').val(),
                                brutto: validator.getFieldElements('brutto').val(),
                                gruzopodyomnost: validator.getFieldElements('vagon.gruzopodyomnost').val()
                            };
                        },
                        message: 'Масса груза не может быть меньше 0 или В данном вагоне перегруз!',
                        type: 'GET'
                    }
                }
            }
        }
    });
});
function edit() {
    var brutto = $('input#brutto').val();
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
    var dataPribitiyaVagona = $('input#dtqqq').val()
    var pogruzka = {
        brutto: brutto,
        netto: netto,
        idVagon: idVagon,
        gruz: gruz,
        tara: tara,
        dopolneniya: dopolneniya,
        dataPribitiyaVagona: dataPribitiyaVagona
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

function edit_2() {
    var brutto = $("input#brutto").val();
    var gruz = $('input#gruz').val();
    var tara = {
        id: $('select#tara option:selected').val(),
        name: $('select#tara option:selected').text()
    };
    var dopolneniya = $('#dopolneniya').val();
    pogruzkaJSON.tara = tara;
    pogruzkaJSON.brutto = brutto;
    pogruzkaJSON.dopolneniya = dopolneniya;

    $.ajax({
        url: '/zavod/pogruzka/saveEdit/' + gruz,
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
        data: JSON.stringify(pogruzkaJSON),
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

$(function () {
    $('#datetimepicker1').datetimepicker(
        {pickTime: false, language: 'ru'}
    );
});

$("#datetimepicker2").on("dp.hide", function (e) {
    var x = $('#datetimepicker1').data("DateTimePicker").getDate();
    var d = new Date();
    d.setTime(Date.parse(x));
    var y = d.getDate() + "-" + d.getMonth() + "-" + d.getFullYear();
    var z = $("input#gruz").val();
    $.ajax({
        url: "pogruzka/setDate/" + z + "/" + d.getDate() + "/" + d.getMonth() + "/" + d.getFullYear(),
        success: function (html) {
            $('#sertif_data').html(html);
        }
    });
});


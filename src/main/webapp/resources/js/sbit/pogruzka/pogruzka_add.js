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
                        url: '/zavod/valid_pogruzka_netto',
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
            },
            dataPribitiyaVagona: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым'
                    }
                }
            }
        }
    });
});
function edit_pogr_add() {
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
    var dataPribitiyaVagona = $('input#dataPribitiyaVagona').val();
    //var idPorozniy = $('input#idPorozniy').val();
    var vagonPorozniy = pogruzkaJSON2.vagonPorozniy;
    var pogruzil = pogruzkaJSON2.pogruzil;
    var pogruzka = {
        brutto: brutto,
        netto: netto,
        idVagon: idVagon,
        gruz: gruz,
        tara: tara,
        dopolneniya: dopolneniya,
        dataPribitiyaVagona: dataPribitiyaVagona,
        vagonPorozniy: vagonPorozniy,
        pogruzil:pogruzil
    };

    //pogruzkaJSON2.brutto=$('input#brutto').val();
    $.ajax({
        url: '/zavod/pogruzka/save',
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
        data: JSON.stringify(pogruzka),
        success: function (html) {
            $('.modal-backdrop').hide(700);
            $('#myModal_2').modal().fadeIn(1000);
            showSbit('/zavod/vagon/poroznieAll');
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

/*$(function () {
    $('#datetimepicker1').datetimepicker(
        {pickTime: false, language: 'ru'}
    );
});


$("#datetimepicker2").on("dp.hide", function (e) {
    var x = $('#datetimepicker1').data("DateTimePicker").getDate();
    //alert("qweqw")
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
});*/

function StrToDate(Dat) {
    var year = Number(Dat.split(".")[2]);
    var month = Number(Dat.split(".")[1]);
    var day = Number(Dat.split(".")[0]);
    var dat = new Date(year, month, day);
    return dat
}

$('.selectpicker').selectpicker({
});


$(document).ready(function () {
    $('.content').off('click');
    //$('#datetimepicker3').data("update", new Date($('input#data_pribitiya_hide').val()));
    var x = $('#id').val();
    $('#edit_form').bootstrapValidator({
        message: 'Это значение не подходит',
        fields: {
            nomerVagona: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым'
                    },
                    remote: {
                        url: '/zavod/valid_vagon',
                        data: function (validator) {
                            return {
                                id: validator.getFieldElements('id').val()
                            };
                        },
                        message: 'Вагон с таким номером есть в базе',
                        type: 'GET'
                    }
                }
            },
            "rodVagona.id": {
                validators: {
                    greaterThan: {
                        value: 1,
                        message: 'Поле не может быть пустым!'
                    },
                    remote: {
                        url: '/zavod/valid_pogruzka_mkr',
                        data: function (validator) {
                            return {
                                id: validator.getFieldElements('id').val(),
                                idRV: validator.getFieldElements('idRV').val(),
                                idRV_2: validator.getFieldElements("rodVagona.id").val()
                            };
                        },
                        message: 'Этот Вагон был погоружен МКР!',
                        type: 'GET'
                    }
                }
            },
            tara: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым!'
                    },
                    numeric: {
                        message: 'В поле можно вводить только цифры!'
                    },
                    greaterThan: {
                        value: 0.0001,
                        message: 'Введенное число должно быть больше 0!'
                    },
                    remote: {
                        url: '/zavod/valid_vagon_tara',
                        data: function (validator) {
                            return {
                                id: validator.getFieldElements('id').val(),
                                gruzopodyomnost: validator.getFieldElements('gruzopodyomnost').val()
                            }
                        },
                        message: 'Тара не может быть изменена',
                        type: 'GET'
                    }
                }
            },
            gruzopodyomnost: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым!'
                    },
                    numeric: {
                        message: 'В поле можно вводить только цифры!'
                    },
                    greaterThan: {
                        value: 0.0001,
                        message: 'Введенное число должно быть больше 0!'
                    },
                    remote: {
                        url: '/zavod/valid_vagon_tara',
                        data: function (validator) {
                            return {
                                id: validator.getFieldElements('id').val(),
                                tara: validator.getFieldElements('tara').val()
                            }
                        },
                        message: 'Грузоподъемность не может быть изменена',
                        type: 'GET'
                    }
                }
            }
        }
    });
});
function editPorozniy() {
    var t = $('input#dtpdp').val();
    var ww = $('#datetimepicker3').data("DateTimePicker").getDate();
    var cc = new Date();
    cc.setTime(Date.parse(ww));
    //alert(ww.getFullYear());
    //var ccc=cc.getFullYear();
    //alert(ccc);

    var gruz = {
        id: $('select#gruz option:selected').val(),
        name: $('select#gruz option:selected').text()
    };
    var dataPribitiya = DateToStr(cc);
    var nomerSvidetelstva = $('input#nomerSvidetelstva').val();

    vagonPorozniyJSON.gruz = gruz;
    vagonPorozniyJSON.dataPribitiya = dataPribitiya;
    vagonPorozniyJSON.nomerSvidetelstva = $.trim(nomerSvidetelstva);
    $.ajax({
        url: '/zavod/vagon/save_vagon_porozniy',
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
        data: JSON.stringify(vagonPorozniyJSON),
        success: function (html) {
            $('.modal-backdrop').hide(700);
            $('#myModal_2').modal().fadeIn(1000);
            showSbit('/zavod/vagon/poroznieAll');
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
    $('#datetimepicker3').datetimepicker({
        pickTime: false,
        language: 'ru',
        //format: 'dd.MM.yyyy',
        defaultDate: new Date($('input#data_pribitiya_hide').val())
    });
});

$("#datetimepicker31").on("dp.hide", function (e) {
    var x = $('#datetimepicker31').data("DateTimePicker").getDate();
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

function StrToDate(Dat) {
    var year = Number(Dat.split(".")[2]);
    var month = Number(Dat.split(".")[1]);
    var day = Number(Dat.split(".")[0]);
    var dat = new Date(year, month, day);
    return dat
}

function DateToStr(Dat) {

    var year = Dat.getFullYear();
    var month = Dat.getMonth();
    var day = Dat.getDate();
    return [year, month + 1, day];
    //return '['+year+','+month+','+day+']';
}

$('.selectpicker').selectpicker({});

$('select#gruz').on('changed.bs.select', function (e) {
    var x = $('select#gruz option:selected').val();
    var div = $('div#ns_grour');
    if (x > 2) {
        div.hide(600);
    }
    else {
        div.show(600);
    }
    
});

$('select#gruz').on('loaded.bs.select', function (e) {
    var x = $('select#gruz option:selected').val();
    var div = $('div#ns_grour');
    if (x > 2) {
        div.hide();
    }
    else {
        div.show();
    }

});
$(document).ready(function () {
    $('#edit_form').bootstrapValidator({
        message: 'Это значение не подходит',
        fields: {
            nomer: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым'
                    },
                    remote: {
                        url: 'valid_sertificat_nomer/im',
                        data: function (validator) {
                            return {
                                id: validator.getFieldElements('id').val(),
                                data: validator.getFieldElements('dataDobavleniya').val()
                            };
                        },
                        message: 'Сертификат с таким номером уже есть в этом году!',
                        type: 'GET'
                    }
                }
            },
            aktivnost: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым'
                    },
                    numeric: {
                        message: 'В поле можно вводить только цифры!'
                    },
                    between: {
                        min: 0.0001,
                        max: 100,
                        message: 'Введенное число должно быть в пределах от 0 до 100'
                    }
                }
            },
            vremyaGascheniya: {
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
                    }
                }
            },
            temperaturaGascheniya: {
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
                    }
                }
            },
            soderUglekisloti: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым'
                    },
                    numeric: {
                        message: 'В поле можно вводить только цифры!'
                    },
                    between: {
                        min: 0.0001,
                        max: 100,
                        message: 'Введенное число должно быть в пределах от 0 до 100'
                    }
                }
            },
            sito02: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым'
                    },
                    numeric: {
                        message: 'В поле можно вводить только цифры!'
                    },
                    between: {
                        min: 0.0001,
                        max: 100,
                        message: 'Введенное число должно быть в пределах от 0 до 100'
                    }
                }
            },
            sito008: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым'
                    },
                    numeric: {
                        message: 'В поле можно вводить только цифры!'
                    },
                    between: {
                        min: 0.0001,
                        max: 100,
                        message: 'Введенное число должно быть в пределах от 0 до 100'
                    }
                }
            }
        }
    });
});
function edit() {
    //alert(stationID);
    var id = $('input#id').val();
    var nomer = $('input#nomer').val();
    var aktivnost = $('input#aktivnost').val();
    var pokupatel = {
        id: $('select#pokupatel option:selected').val()
    };
    var station = {
        id: stationID
    };
    var vremyaGascheniya = $('input#vremyaGascheniya').val();
    var temperaturaGascheniya = $('input#temperaturaGascheniya').val();
    var soderUglekisloti = $('input#soderUglekisloti').val();
    var sito02 = $('input#sito02').val();
    var sito008 = $('input#sito008').val();
    var data = $('input#dataDobavleniya').val();
    var otmetki = $('input#otmetki').val();
    var sertifikatIM = {
        id: id,
        nomer: nomer,
        data: data,
        pokupatel: pokupatel,
        station: station,
        aktivnost: aktivnost,
        vremyaGascheniya: vremyaGascheniya,
        temperaturaGascheniya: temperaturaGascheniya,
        soderUglekisloti: soderUglekisloti,
        sito02: sito02,
        sito008: sito008,
        otmetki: otmetki
    };
    $.ajax({
        url: '/zavod/sertificat/im/save',
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
        data: JSON.stringify(sertifikatIM),
        success: function (html) {
            $('.modal-backdrop').hide(700);
            $('#myModal_2').modal().fadeIn(1000);
            showSbit('/zavod/sertificat/all');
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

$('.selectpicker').selectpicker({
    liveSearch: true
});

$('.selectpicker').on('changed.bs.select', function (e) {
    var x = $(this).selectpicker('val');
    $.ajax({
        url: '/zavod/sertificat/pokupatel/' + x,
        success: function (html) {
            $('#pokupatel_stations').html(html);
        }
    });
});



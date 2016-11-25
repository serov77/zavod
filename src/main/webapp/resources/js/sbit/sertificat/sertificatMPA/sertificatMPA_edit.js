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
                        url: 'valid_sertificat_nomer/mpa',
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
            udRadio: {
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
            poristost: {
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
            nabuchanie: {
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
            massovayaDolyaVlagi: {
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
            zerovoySostav1250: {
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
            zerovoySostav0315: {
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
            zerovoySostav0071: {
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
    var id = $('input#id').val();
    var nomer = $('input#nomer').val();
    var udRadio = $('input#udRadio').val();
    var poristost = $('input#poristost').val();
    var nabuchanie = $('input#nabuchanie').val();
    var gidrofobnost = $('input#gidrofobnost').val();
    var massovayaDolyaVlagi = $('input#massovayaDolyaVlagi').val();
    var pokupatel = {
        id: $('select#pokupatel option:selected').val()
    };
    var station = {
        id: stationID
    };
    var zerovoySostav1250 = $('input#zerovoySostav1250').val();
    var zerovoySostav0315 = $('input#zerovoySostav0315').val();
    var zerovoySostav0071 = $('input#zerovoySostav0071').val();
    var data = $('input#dataDobavleniya').val();
    var otmetki = $('input#otmetki').val();
    var sertifikatMPN = {
        id: id,
        nomer: nomer,
        data: data,
        pokupatel: pokupatel,
        station: station,
        udRadio: udRadio,
        poristost: poristost,
        nabuchanie: nabuchanie,
        gidrofobnost: gidrofobnost,
        massovayaDolyaVlagi: massovayaDolyaVlagi,
        zerovoySostav1250: zerovoySostav1250,
        zerovoySostav0315: zerovoySostav0315,
        zerovoySostav0071: zerovoySostav0071,
        otmetki: otmetki
    };
    $.ajax({
        url: '/zavod/sertificat/mpa/save',
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
        data: JSON.stringify(sertifikatMPN),
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


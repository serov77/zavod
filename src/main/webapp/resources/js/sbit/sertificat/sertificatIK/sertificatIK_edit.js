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
                        url: 'valid_sertificat_nomer',
                        data: function (validator) {
                            return {
                                id: validator.getFieldElements('id').val(),
                                data: validator.getFieldElements('data').val()
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
                        min: 0,
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
                    }
                }
            },
            soderNepogZeren: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым'
                    },
                    numeric: {
                        message: 'В поле можно вводить только цифры!'
                    },
                    between: {
                        min: 0,
                        max: 100,
                        message: 'Введенное число должно быть в пределах от 0 до 100'
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
                        min: 0,
                        max: 100,
                        message: 'Введенное число должно быть в пределах от 0 до 100'
                    }
                }
            },
        }
    });
});
function edit() {
    var id = $('input#id').val();
    var nomer = $('input#nomer').val();
    var pokupatel = {
        id: $('select#pokupatel option:selected').val()
    };
    var vremyaGascheniya = $('input#vremyaGascheniya').val();
    var temperaturaGascheniya = $('input#temperaturaGascheniya').val();
    var soderNepogZeren = $('input#soderNepogZeren').val();
    var soderUglekisloti = $('input#soderUglekisloti').val();
    var data = $('input#data').val();
    $.ajax({
        url: '/zavod/sertifikat/ik/save',
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
        data: JSON.stringify(sertifikatIK),
        success: function (html) {
            $('.modal-backdrop').hide(700);
            $('#myModal_2').modal().fadeIn(1000);
            showSbit('pokupatel/all');
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


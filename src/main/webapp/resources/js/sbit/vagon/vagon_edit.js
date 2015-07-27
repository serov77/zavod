$(document).ready(function () {
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
                        url: 'valid_vagon',
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
                        url: 'valid_pogruzka_mkr',
                        data: function (validator) {
                            return {
                                id: validator.getFieldElements('id').val(),
                                idRV: validator.getFieldElements('idRV').val(),
                                idRV_2: validator.getFieldElements("rodVagona.id").val()
                            };
                        },
                        message: '"Этот Вагон был погоружен МКР!',
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
                    }
                }
            }
        }
    });
});
function edit() {
    var id = $('input#id').val();
    var nomerVagona = $('input#nomerVagona').val();
    var rodVagona = {
        id: $('select#rodVagona option:selected').val(),
        name: $('select#rodVagona option:selected').text()
    };
    var tara = $('input#tara').val();
    var gruzopodyomnost = $('input#gruzopodyomnost').val();
    var kolichestvoZpu = $('select#kolichestvoZpu option:selected').val();
    var dataDobavleniya = $('input#dataDobavleniya').val();
    var vagon = {
        id: id,
        nomerVagona: nomerVagona,
        rodVagona: rodVagona,
        tara: tara,
        gruzopodyomnost: gruzopodyomnost,
        kolichestvoZpu: kolichestvoZpu,
        dataDobavleniya: dataDobavleniya
    };

    $.ajax({
        url: '/zavod/vagon/save',
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
        data: JSON.stringify(vagon),
        success: function (html) {
            $('.modal-backdrop').hide(700);
            $('#myModal_2').modal().fadeIn(1000);
            showSbit('vagon/all');
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

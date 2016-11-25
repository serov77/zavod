$(document).ready(function () {
    $('.content').off('click');

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
                            var gruzopodyomnost = validator.getFieldElements('gruzopodyomnost').val();
                            if (gruzopodyomnost == "") {
                                gruzopodyomnost = 0;
                            }
                            return {
                                id: validator.getFieldElements('id').val(),
                                gruzopodyomnost: gruzopodyomnost
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
                            var tara = validator.getFieldElements('tara').val();
                            if (tara == "") {
                                tara = 0;
                            }
                            return {
                                id: validator.getFieldElements('id').val(),
                                tara: tara
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
    var dataDobavleniya = $('input#dataDobavleniya_2').val();
    if (dataDobavleniya == "") {
        dataDobavleniya = null;
    }
    var vagon = {
        id: id,
        nomerVagona: $.trim(nomerVagona),
        rodVagona: rodVagona,
        tara: tara,
        gruzopodyomnost: gruzopodyomnost,
        kolichestvoZpu: kolichestvoZpu,
        dataDobavleniya: dataDobavleniya
    };
    vagonJSON.nomerVagona = $('input#nomerVagona').val();
    vagonJSON.rodVagona = rodVagona;
    vagonJSON.tara = $('input#tara').val();
    vagonJSON.gruzopodyomnost = $('input#gruzopodyomnost').val();
    vagonJSON.kolichestvoZpu = $('select#kolichestvoZpu option:selected').val();
    $.ajax({
        url: '/zavod/vagon/save',
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
        data: JSON.stringify(vagonJSON),
        success: function (html) {
            $('.modal-backdrop').hide(700);
            $('#myModal_2').modal().fadeIn(1000);
            showSbit('/zavod/vagon/all');
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

$('.selectpicker').selectpicker({});

function Ftest_vagon_edit(obj) {
    var c = obj.value;
    c = c.replace(/,/, '.');
    obj.value = c;
    if (this.ST) return;
    var ov = obj.value
    var ovrl = ov.replace(/\d*\.?\d*/, '').length;
    this.ST = true;
    if (ovrl > 0) {
        obj.value = obj.lang;
        Fshowerror(obj);
        return;
    }
    obj.lang = obj.value;
    this.ST = null;
}

function Fshowerror(obj) {
    if (!this.OBJ) {
        this.OBJ = obj;
        obj.style.backgroundColor = 'pink';
        this.TIM = setTimeout(Fshowerror, 50)
    }
    else {
        this.OBJ.style.backgroundColor = '';
        clearTimeout(this.TIM);
        this.ST = null;
        Ftest(this.OBJ);
        this.OBJ = null
    }
}

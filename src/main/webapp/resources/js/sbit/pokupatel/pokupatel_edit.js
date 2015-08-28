$(document).ready(function () {
    var x = $('#id').val();
    $('#edit_form').bootstrapValidator({
        message: 'Это значение не подходит',
        fields: {
            name: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым'
                    }
                }
            },
            kod: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым!'
                    },
                    remote: {
                        url: 'valid_pokupatel_kod',
                        data: function (validator) {
                            return {
                                id: validator.getFieldElements('id').val()
                            };
                        },
                        message: 'Покупатель с таким кодом есть в базе',
                        type: 'GET'
                    }
                }
            },
            okpo: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым!'
                    },
                    remote: {
                        url: 'valid_pokupatel_okpo',
                        data: function (validator) {
                            return {
                                id: validator.getFieldElements('id').val()
                            };
                        },
                        message: 'Покупатель с таким ОКПО есть в базе',
                        type: 'GET'
                    }
                }
            }
        }
    });
});
function edit() {
    alert(pokupatelJSON.name);
    pokupatelJSON.name = $('input#name').val();
    pokupatelJSON.kod = $('input#kod').val();
    pokupatelJSON.okpo = $('input#okpo').val();
    var station_id = $('select#station option:selected').val();
    var station = {
        id: station_id,
        name: '',
        kod: ''
    };
    pokupatelJSON.station = station;

    $.ajax({
        url: '/zavod/pokupatel/save',
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
        data: JSON.stringify(pokupatelJSON),
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


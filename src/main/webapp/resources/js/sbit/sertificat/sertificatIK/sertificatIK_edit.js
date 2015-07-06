$(document).ready(function () {
    var x = $('#id').val();
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
        }
    });
});
function edit() {
    var id = $('input#id').val();
    var name = $('input#name').val();
    var kod = $('input#kod').val();
    var okpo = $('input#okpo').val();
    var station_id = $('select#station option:selected').val();
    var station = {
        id: station_id,
        name: '',
        kod: ''
    };
    var pokupatel = {
        id: id,
        name: name,
        kod: kod,
        okpo: okpo,
        station: station
    };

    $.ajax({
        url: '/zavod/pokupatel/save',
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
        data: JSON.stringify(pokupatel),
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


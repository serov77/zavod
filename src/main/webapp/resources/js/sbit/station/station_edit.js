$(document).ready(function () {
    var x = $('#id').val();
    $('#edit_form').bootstrapValidator({
        message: 'Это значение не подходит',
        fields: {
            nameStation: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым'
                    }
                }
            },
            kod: {
                validators: {
                    notEmpty: {
                        message: 'Поле не может быть пустым'
                    },
                    remote: {
                        url: 'valid_station',
                        data: function (validator) {
                            return {
                                id: validator.getFieldElements('id').val()
                            };
                        },
                        message: 'Станция с таким кодом есть в базе',
                        type: 'GET'
                    }
                }
            }
        }
    });
});
function edit() {
    var id = $('input#id').val();
    var name = $('textarea#name').val();
    var kod = $('input#kod').val();
    var station = {
        id: id,
        name: name,
        kod: kod
    };

    $.ajax({
        url: '/zavod/station/save',
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
        data: JSON.stringify(station),
        success: function (html) {
            $('.modal-backdrop').hide(700);
            $('#myModal_2').modal().fadeIn(1000);
            showSbit('station/all');
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
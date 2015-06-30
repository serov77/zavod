//            Функции

// Ajax Загрузка таблиц по клику на меню
function showSbit(url) {
    $.ajax({
        url: url,
        beforeSend: function () {
            $('#content').html('<img src="/zavod/resources/img/ajax-loader.gif" />');
        },
        complete: function () {
            $('#content').show(100);
        },
        success: function (html) {
            $('#content').html(html);
        }
    });
}

function login(){
    $('#myModal_3').modal();
}



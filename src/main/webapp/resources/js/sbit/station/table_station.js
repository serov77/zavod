$(document).ready(function () {
    //    Настройка и запуск таблицы Вагоны
    $('#stations').DataTable({
        "language": {
            "lengthMenu": "Показывать _MENU_ записей на странице",
            "zeroRecords": "Нет записей",
            "info": "Страница _PAGE_ из _PAGES_",
            "infoEmpty": "Нет записей",
            "sSearch": "Поиск",
            oPaginate: {
                sFirst: "Первая",
                sLast: "Последняя",
                sNext: "Вперед",
                sPrevious: "Назад"
            },
            "infoFiltered": "(Фильтр из _MAX_ записей)"
        },
        "order": [[0, "desc"]]
    });
    $('body').on('click', '.butt_station', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/station/edit/" + x;
        editVagon(url);
        $("#myModal").modal();
    });

    $('.butt_add_station').click(function () {
        editVagon('/zavod/station/add');
        $("#myModal").modal();
    });

    function editVagon(url) {
        $.ajax({
            url: url,
            //type: 'POST',
            beforeSend: function () {
                $('#mesto').html('<img src="/zavod/resources/img/ajax-loader.gif" />');
            },
            complete: function () {
                $('#mesto').show(100);
            },
            success: function (html) {
                $('#mesto').html(html);
            }
        });
    }

    $('tbody').on('click', 'tr', function () {
        $(this).toggleClass('selected');
    });

    $(function () {
        $("[data-toggle='tooltip']").tooltip();
    });

});

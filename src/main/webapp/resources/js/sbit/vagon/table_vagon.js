$(document).ready(function () {
    //    Настройка и запуск таблицы Вагоны
    $('#vagons').DataTable({
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

    //$('.butt').click(function () {
    //    var x = $(this).attr("rel");
    //    var url = "vagon/edit/" + x;
    //    editVagon(url);
    //    $("#myModal").modal();
    //});

    $('.butt_add').click(function () {
        editVagon('vagon/add');
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

    $('body').on('click','.butt_edit', function () {
        var x = $(this).attr("rel");
        var url = "vagon/edit/" + x;
        editVagon(url);
        $("#myModal").modal();
    });

    $('body').on('click','.butt_pogr', function () {
        var x = $(this).attr("rel");
        var url = "/pogruzka/add/" + x;
        editVagon(url);
        $("#myModal").modal();
    });

    function addPogruzka(url) {
        $.ajax({
            url: url,
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
});






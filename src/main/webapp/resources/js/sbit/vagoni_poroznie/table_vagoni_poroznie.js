$(document).ready(function () {
    //    Настройка и запуск таблицы Вагоны
    /*$('#vagoni_poroznie').DataTable({
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
        "order": [[0, "asc"]]
    });
    
    function editVagon(url) {
        $('input#idRV').text($('select#rodVagona option:selected').val());
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

    $('body').on('click','.butt_pogr', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/pogruzka/add/" + x;
        editVagon(url);
        $("#myModal").modal();
    });

    $('body').on('click','.butt_porozniy_edit', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/vagon/poroznie_edit/" + x;
        editVagon(url);
        $("#myModal").modal();
    });

    $('#butt_pechat_zayavki').click(function () {
        editVagon('/zavod/vagon/pechat_zayavki');
        $("#myModal").modal();
    });*/

    $(function () {
        $('#dtp_data_zayavki').datetimepicker(
            {pickTime: false, language: 'ru', defaultDate: new Date()}
        );
    });
    
    $(function () {
        $("[data-toggle='tooltip']").tooltip();
    });
});






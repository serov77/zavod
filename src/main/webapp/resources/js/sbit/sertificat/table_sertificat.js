$(document).ready(function () {
    //    Настройка и запуск таблицы Вагоны
    /*$('#sertificatsIK, #sertificatsIM, #sertificatsMPN, #sertificatsIKNeIsp, #sertificatIKBezPol, #sertificatsIMBezPol, #sertificatsMPNNeIsp, #sertificatsMPNBezPol').DataTable({
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
    $('body').on('click', '.butt_sertifikat', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/sertificat/edit/" + x;
        editSertificat(url);
        $("#myModal").modal();
    });

    $('body').on('click', '.butt_add_sert', function () {
        var x = $(this).attr("rel");
        var url = '/zavod/sertificat/' + x + '/add';
        editSertificat(url);
        $("#myModal").modal();
    });

    function editSertificat(url) {
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

    $('tbody').on('click', 'tr', function () {
        $(this).toggleClass('selected');
    });*/

});

$('.selectpicker').selectpicker({
    liveSearch: true
});

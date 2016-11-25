$(document).ready(function () {
    IK();
    IM();
    MPA();
    MPN();
    //$('.content').off('click');
    //    Настройка и запуск таблицы Вагоны
    /*$('#pogruzkaIK, #pogruzkaIK_2, #pogruzkaIM, #pogruzkaIM_2, #pogruzkaMPN, #pogruzkaMPN_2').DataTable({
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
    $('body').on('click', '.butt_pogr_edit', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/pogruzka/edit/" + x;
        editPogruzka(url);
        $("#myModal").modal();
    });

    $('body').on('click', '.butt_otmena', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/pogruzka/otmena/" + x;
        $.ajax({
            url: url,
            contentType: 'application/json; charset=utf-8',
            type: 'GET',
            //data: JSON.stringify(pogruzka),
            complete: function () {
                //$('#mesto').show(100);
            },
            success: function (html) {
                //$('.modal-backdrop').hide(700);
                $('#myModal_2').modal().fadeIn(1000);
                showSbit('/zavod/pogruzka/all');
            }
        });
    });

    $('body').on('click', '.butt_otmena_pogr_IK', function () {
        var x = $(this).attr("rel");
        var url = "zavod/pogruzka/otmena_pogr/" + x;
        $.ajax({
            url: url,
            contentType: 'application/json; charset=utf-8',
            type: 'GET',
            //data: JSON.stringify(pogruzka),
            complete: function () {
                //$('#mesto').show(100);
            },
            success: function (html) {
                //$('.modal-backdrop').hide(700);
                $('#myModal_2').modal().fadeIn(1000);
                showSbit('/zavod/pogruzka/all');
            }
        });
    });
    $('body').on('click', '.butt_otmena_pogr_IM', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/pogruzka/otmena_pogr/" + x;
        $.ajax({
            url: url,
            contentType: 'application/json; charset=utf-8',
            type: 'GET',
            //data: JSON.stringify(pogruzka),
            complete: function () {
                //$('#mesto').show(100);
            },
            success: function (html) {
                //$('.modal-backdrop').hide(700);
                $('#myModal_2').modal().fadeIn(1000);
                showSbit('/zavod/pogruzka/all');
            }
        });
    });
    $('body').on('click', '.butt_otmena_pogr_MPN', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/pogruzka/otmena_pogr/" + x;
        $.ajax({
            url: url,
            contentType: 'application/json; charset=utf-8',
            type: 'GET',
            //data: JSON.stringify(pogruzka),
            complete: function () {
                //$('#mesto').show(100);
            },
            success: function (html) {
                //$('.modal-backdrop').hide(700);
                $('#myModal_2').modal().fadeIn(1000);
                showSbit('/zavod/pogruzka/all');
            }
        });
    });

    $('body').on('click', '#butt_otpr_ik', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/pogruzka/otpravka/" + x;
        editPogruzka(url);
        $("#myModal").modal();
    });

    $('body').on('click', '#butt_otpr_im', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/pogruzka/otpravka/" + x;
        editPogruzka(url);
        $("#myModal").modal();
    });
    

    function editPogruzka(url) {
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
     */
    $('tbody').on('click', 'tr', function () {
        $(this).toggleClass('selected');
    })

/*
    var arrIK = new Array();
    var xIK = "";
    var dataOtpravleniyaIK = "";
    
    $("body ").on("mousedown","#pogruzkaIK tr", function (e) {
        if(e.button == 2) {
            if (arrIK.length == 0) {
                dataOtpravleniyaIK = $(this).find(".dataOtpravleniya").text();
            }
            if ($(this).find(".dataOtpravleniya").text() == dataOtpravleniyaIK) {
                $(this).find(".nomer_vagonaIK").toggleClass("class_red");
                if ($(this)) {
                    var z = parseInt($(this).find(".id_pogruzkaIK").text());
                    if (in_array(z, arrIK)) {
                        arrIK.splice(arrIK.indexOf(z), 1);
                    } else {
                        arrIK.push(z);
                    }
                }
                $("div.printIK:visible").append(xIK);
            }
        }
    });

    var arrIM = new Array();
    var xIM = "";
    var dataOtpravleniyaIM = "";
    $("body ").on("mousedown","#pogruzkaIM tr", function (e) {
        if(e.button == 2) {
            if (arrIM.length == 0) {
                dataOtpravleniyaIM = $(this).find(".dataOtpravleniya").text();
            }
            if ($(this).find(".dataOtpravleniya").text() == dataOtpravleniyaIM) {
                $(this).find(".nomer_vagonaIM").toggleClass("class_red");
                if ($(this)) {
                    var z = parseInt($(this).find(".id_pogruzkaIM").text());
                    if (in_array(z, arrIM)) {
                        arrIM.splice(arrIM.indexOf(z), 1);
                    } else {
                        arrIM.push(z);
                    }
                }
                $("div.printIM:visible").append(xIM);
            }
        }
    });

    var arrMPN = new Array();
    var xMPN = "";
    var dataOtpravleniyaMPN = "";
    $("body ").on("mousedown","#pogruzkaMPN tr", function (e) {
        if(e.button == 2) {
            if (arrMPN.length == 0) {
                dataOtpravleniyaMPN = $(this).find(".dataOtpravleniya").text();
            }
            if ($(this).find(".dataOtpravleniya").text() == dataOtpravleniyaMPN) {
                $(this).find(".nomer_vagonaMPN").toggleClass("class_red");
                if ($(this)) {
                    var z = parseInt($(this).find(".id_pogruzkaMPN").text());
                    if (in_array(z, arrMPN)) {
                        arrMPN.splice(arrMPN.indexOf(z), 1);
                    } else {
                        arrMPN.push(z);
                    }
                }
                $("div.printMPN:visible").append(xMPN);
            }
        }
    });*/

    $("table").on("contextmenu", false);

    $(function () {
        $("[data-toggle='tooltip']").tooltip();
    });

    /*$('body').on('click', '.butt_print', function () {
        var v = $(this).attr('rel');
        var url = "/zavod/pogruzka/pechat" + v;
        var arr;
        switch (v) {
            case "IK":
                arr = arrIK;
                break;
            case "IM":
                arr = arrIM;
                break;
            case "MPN":
                arr = arrMPN;
                break;
        }
        test(url, arr);
        $("#myModal").modal();
    });

    function test(url, arr) {
        var x = {"y": arr};

        $.ajax({
            type: "POST",
            url: url,
            data: $.param(x, true),
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
    }*/
});

function in_array(value, array) {
    for (var i = 0; i < array.length; i++) {
        if (array[i] == value) return true;
    }
    return false;
}

$('.selectpicker').selectpicker({
    //liveSearch: true
});




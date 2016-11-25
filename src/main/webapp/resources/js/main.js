// Ajax Загрузка таблиц по клику на меню

function table_vagons() {
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
}

function table_vagons_poroznie() {
    $('#vagoni_poroznie').DataTable({
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
        "order": [[4, "asc"]]
    });
}

function table_sertifikat() {
    $('#sertificatsIK, #sertificatsIM, #sertificatsMPN, #sertificatsIKNeIsp,#sertificatsIMNeIsp, #sertificatIKBezPol, #sertificatsIMBezPol, #sertificatsMPNNeIsp, #sertificatsMPNBezPol, #sertificatsMPA, #sertificatsMPANeIsp, #sertificatsMPABezPol').DataTable({
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
}

function table_pogruzka() {
    $('#pogruzkaIK, #pogruzkaIK_2, #pogruzkaIM, #pogruzkaIM_2, #pogruzkaMPN, #pogruzkaMPN_2,  #pogruzkaMPA, #pogruzkaMPA_2').DataTable({
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
}


function showSbit(url, funk) {
    //alert(url.substring(19, -19));
    $.ajax({
        url: url,
        beforeSend: function () {
            var content = $('#content');
            //content.empty();
            //content.html(html);
            content.html('<img src="/zavod/resources/img/ajax-loader.gif" />');
        },
        complete: function () {
            switch (url) {
                case '/zavod/vagon/all': {
                    table_vagons();
                }
                    break;
                case '/zavod/vagon/poroznieAll': {
                    table_vagons_poroznie();
                }
                    break;
                case '/zavod/sertificat/all': {
                    table_sertifikat();
                }
            }

            if (url.substring(19, -19) == '/zavod/pogruzka/all') {
                table_pogruzka();
            }

            $('#content').show(100);
        },
        success: function (html) {
            var content = $('#content');
            content.html(html);
            switch (url) {
                case '/zavod/vagon/all': {

                }
                    break;
                case '/zavod/vagon/poroznieAll': {

                }
                    break;
                case '/zavod/sertificat/all': {
                    load_tab_sert();
                }
            }
            if (url.substring(19, -19) == '/zavod/pogruzka/all') {
                load_tab_pogr();
            }

        }
    })
}


function Ftest(obj) {
    var c = obj.value;
    c = c.replace(/,/, '.');
    obj.value = c;
    if (this.ST) return;
    var ov = obj.value;
    var ovrl = ov.replace(/\d*\.?\d*/, '').length;
    this.ST = true;
    if (ovrl > 0) {
        obj.value = obj.lang;
        Fshowerror(obj);
        return;
    }
    obj.lang = obj.value;
    this.ST = null;
    var tara = $("input#taraVag").val();
    var brutto = $("input#brutto").val();
    var x = (brutto - tara).toFixed(1);
    $("input#netto").val(x);
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

var kolIK;
var kolIDIK = new Array();
function IK() {
    //alert('qq');
    for (i = 0; i < kolIDIK.length; i++) {
        var x = '#'+kolIDIK[i]+" .nomer_vagonaIK";
        $(x).addClass("class_red");
    }
    $('div #kolIK').text(kolIDIK);
}
function kolIKFunc() {
    $('div #kolIK').text(kolIDIK);
}

var kolIM;
var kolIDIM = new Array();
function IM() {
    //alert('qq');
    for (i = 0; i < kolIDIM.length; i++) {
        var x = '#'+kolIDIM[i]+" .nomer_vagonaIM";
        $(x).addClass("class_red");
    }
    $('div #kolIM').text(kolIDIM);
}
function kolIMFunc() {
    $('div #kolIM').text(kolIDIM);
}

var kolMPN;
var kolIDMPN = new Array();
function MPN() {
    //alert('qq');
    for (i = 0; i < kolIDMPN.length; i++) {
        var x = '#'+kolIDMPN[i]+" .nomer_vagonaMPN";
        $(x).addClass("class_red");
    }
    $('div #kolMPN').text(kolIDMPN);
}
function kolMPNFunc() {
    $('div #kolMPN').text(kolIDMPN);
}

var kolMPA;
var kolIDMPA = new Array();
function MPA() {
    //alert('qq');
    for (i = 0; i < kolIDMPA.length; i++) {
        var x = '#'+kolIDMPA[i]+" .nomer_vagonaMPA";
        $(x).addClass("class_red");
    }
    $('div #kolMPA').text(kolIDMPA);
}
function kolMPAFunc() {
    $('div #kolMPA').text(kolIDMPA);
}

$(document).ready(function () {
    //all

    //jQuery(".container").bind( 'DOMSubtreeModified',function(){ // отслеживаем изменение содержимого блока 2

    //});


    //$('body').on('click', 'button, a', function () {
    //    pogruzkaOut();
    //});


    $('body').on('click', 'tr', function () {
        $(this).toggleClass('selected');
    });

    //table_vagon.js

    $('body').on('click', '.butt_edit', function () {
        var x = $(this).attr("rel");

        var url = "/zavod/vagon/edit/" + x;
        editVagon_1(url);
        $("#myModal").modal();
    });

    $('body').on('click', '.butt_add', function () {
        editVagon_1('/zavod/vagon/add');
        $("#myModal").modal();
    });

    $('body').on('click', '#butt_poroz', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/vagon/poroznie/" + x;
        editVagon_1(url);
        $("#myModal").modal();
    });

    function editVagon_1(url) {
        $('input#idRV').text($('select#rodVagona option:selected').val());
        //alert($('select#rodVagona option:selected').val());
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
                //alert($('#mesto').html());
                //var content = $('#mesto');
                //content.empty();
                //$('tbody').off('click');
                $('#mesto').html(html);
            }
        });

    }

//table_vagoni_poroznie.js
    $('body').on('click', '.butt_pogr', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/pogruzka/add/" + x;
        editVagon(url);
        $("#myModal").modal();
    });

    $('body').on('click', '.butt_porozniy_edit', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/vagon/poroznie_edit/" + x;
        editVagon(url);
        $("#myModal").modal();
    });

    $('body').on('click', '#butt_pechat_zayavki1', function () {
        editVagon('/zavod/vagon/pechat_zayavki');
        $("#myModal").modal();
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

    //table_sertificat.js

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

    //table_pogruzka.js

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
                showSbit('/zavod/pogruzka/all/0');
            }
        });
    });

    $('body').on('click', '.butt_otmena_pogr_IK', function () {
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
                showSbit('/zavod/pogruzka/all/0');
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
                showSbit('/zavod/pogruzka/all/0');
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
                showSbit('/zavod/pogruzka/all/0');
            }
        });
    });

    $('body').on('click', '.butt_otmena_pogr_MPA', function () {
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
                showSbit('/zavod/pogruzka/all/0');
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

    $('body').on('click', '.butt_otpr_mpn', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/pogruzka/otpravka/" + x;
        editPogruzka(url);
        $("#myModal").modal();
    });

    $('body').on('click', '.butt_otpr_mpa', function () {
        var x = $(this).attr("rel");
        var url = "/zavod/pogruzka/otpravka/" + x;
        editPogruzka(url);
        $("#myModal").modal();
    });

    function editPogruzka(url) {
        $.ajax({
            url: url,
            beforeSend: function () {
                //pogruzkaOut();
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

    var arrIK = new Array();
    var arrIDIK = new Array();
   // var xIK = "";
    var dataOtpravleniyaIK = "";

    $("body ").on("mousedown", "#pogruzkaIK tr", function (e) {
        //alert("1");
        if (e.button == 2) {
            if (arrIK.length == 0) {
                dataOtpravleniyaIK = $(this).find(".dataOtpravleniya").text();
            }
            if ($(this).find(".dataOtpravleniya").text() == dataOtpravleniyaIK) {
                $(this).find(".nomer_vagonaIK").toggleClass("class_red");
                if ($(this)) {
                    var z = parseInt($(this).find(".id_pogruzkaIK").text());
                    var x = $(this).attr('id');
                    if (in_array(z, arrIK)) {
                        arrIK.splice(arrIK.indexOf(z), 1);
                        arrIDIK.splice(arrIDIK.indexOf(x), 1);
                    } else {
                        arrIDIK.push(x);
                        arrIK.push(z);
                    }
                }
                kolIK = arrIK.length;
                kolIDIK = arrIDIK;
                kolIKFunc();
            }
        }
    });

    var arrIM = new Array();
    var arrIDIM = new Array();
    var dataOtpravleniyaIM = "";
    $("body ").on("mousedown", "#pogruzkaIM tr", function (e) {
        if (e.button == 2) {
            if (arrIM.length == 0) {
                dataOtpravleniyaIM = $(this).find(".dataOtpravleniya").text();
            }
            if ($(this).find(".dataOtpravleniya").text() == dataOtpravleniyaIM) {
                $(this).find(".nomer_vagonaIM").toggleClass("class_red");
                if ($(this)) {
                    var z = parseInt($(this).find(".id_pogruzkaIM").text());
                    var x = $(this).attr('id');
                    if (in_array(z, arrIM)) {
                        arrIM.splice(arrIM.indexOf(z), 1);
                        arrIDIM.splice(arrIDIM.indexOf(x), 1);
                    } else {
                        arrIDIM.push(x);
                        arrIM.push(z);
                    }
                }
                kolIM = arrIM.length;
                kolIDIM = arrIDIM;
                kolIMFunc();
            }
        }
    });


    var arrMPN = new Array();
    var arrIDMPN = new Array();
    var dataOtpravleniyaMPN = "";
    $("body ").on("mousedown", "#pogruzkaMPN tr", function (e) {
        if (e.button == 2) {
            if (arrMPN.length == 0) {
                dataOtpravleniyaMPN = $(this).find(".dataOtpravleniya").text();
            }
            if ($(this).find(".dataOtpravleniya").text() == dataOtpravleniyaMPN) {
                $(this).find(".nomer_vagonaMPN").toggleClass("class_red");
                if ($(this)) {
                    var z = parseInt($(this).find(".id_pogruzkaMPN").text());
                    var x = $(this).attr('id');
                    if (in_array(z, arrMPN)) {
                        arrMPN.splice(arrMPN.indexOf(z), 1);
                        arrIDMPN.splice(arrIDMPN.indexOf(x), 1);
                    } else {
                        arrIDMPN.push(x);
                        arrMPN.push(z);
                    }
                }
                kolMPN = arrMPN.length;
                kolIDMPN = arrIDMPN;
                kolMPNFunc();
            }
        }
    });

    var arrMPA = new Array();
    var arrIDMPA = new Array();
    var dataOtpravleniyaMPA = "";

    $("body ").on("mousedown", "#pogruzkaMPA tr", function (e) {
        if (e.button == 2) {
            if (arrMPA.length == 0) {
                dataOtpravleniyaMPA = $(this).find(".dataOtpravleniya").text();
            }
            if ($(this).find(".dataOtpravleniya").text() == dataOtpravleniyaMPA) {
                $(this).find(".nomer_vagonaMPA").toggleClass("class_red");
                if ($(this)) {
                    var z = parseInt($(this).find(".id_pogruzkaMPA").text());
                    var x = $(this).attr('id');
                    if (in_array(z, arrMPA)) {
                        arrMPA.splice(arrMPA.indexOf(z), 1);
                        arrIDMPA.splice(arrIDMPA.indexOf(x), 1);
                    } else {
                        arrIDMPA.push(x);
                        arrMPA.push(z);
                    }
                }
                kolMPA = arrMPA.length;
                kolIDMPA = arrIDMPA;
                kolMPAFunc();
            }
        }
    });


    $('body').on('click', '.butt_print', function () {
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
            case "MPA":
                arr = arrMPA;
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
    }


    $('body').on('change', '#period', function () {

        //alert(this.value);
        showSbit("/zavod/pogruzka/all/" + this.value);
        //showSbit("/zavod/pogruzka/all");

    });

    $('.selectpicker').selectpicker({
        liveSearch: true
    });

    //pogruzka_otpr.js

});


function login() {
    $('#myModal_3').modal();
}


function pogruzkaOut(url) {

}

function statistikaPogruzka() {
    showSbit('/zavod/pogruzka/all');
    //alert(xikm);
    //var x = xikm;
    //alert($('[href = '+xikm+']').attr('href'))
    //var ikm = $("#accordion .pogr_main");
    //$('#qqqq').click();
    //alert(xikm.attr('href'));
    //$('[href = ' + x + ']').click();

    //$('body').on('click', '#qqqq', function () {
    //alert($('#qqqq').attr('href'));
    //});
    //alert('asd');
}



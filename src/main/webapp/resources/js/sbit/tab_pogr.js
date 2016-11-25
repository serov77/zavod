var ik;
var ik_2;
var ik_3;

var im;
var im_2;
var im_3;

var mpn;
var mpn_2;
var mpn_3;

var mpa;
var mpa_2;
var mpa_3;

$(document).ready(function () {


    $('body').on('click', '#ik', function () {
        if ($('#ik').attr('aria-expanded') == 'true') {
            ik = 0;
        }
        else {
            ik = 1;
            im = 0;
            mpn = 0;
            mpa = 0;
        }
    });

    $('body').on('click', '#ik_2', function () {
        if ($('#ik_2').attr('aria-expanded') == 'true') {
            ik_2 = 0;
        }
        else {
            ik_2 = 1;
        }
    });

    $('body').on('click', '#ik_3', function () {
        if ($('#ik_3').attr('aria-expanded') == 'true') {
            ik_3 = 0;
        }
        else {
            ik_3 = 1;
        }
    });


    $('body').on('click', '#im', function () {
        if ($('#im').attr('aria-expanded') == 'true') {
            im = 0;
        }
        else {
            ik = 0;
            im = 1;
            mpn = 0;
            mpa = 0;
        }
    });

    $('body').on('click', '#im_2', function () {
        if ($('#im_2').attr('aria-expanded') == 'true') {
            im_2 = 0;
        }
        else {
            im_2 = 1;
        }
    });

    $('body').on('click', '#im_3', function () {
        if ($('#im_3').attr('aria-expanded') == 'true') {
            im_3 = 0;
        }
        else {
            im_3 = 1;
        }
    });


    $('body').on('click', '#mpn', function () {
        if ($('#mpn').attr('aria-expanded') == 'true') {
            mpn = 0;
        }
        else {
            ik = 0;
            im = 0;
            mpn = 1;
            mpa = 0;
        }
    });

    $('body').on('click', '#mpn_2', function () {
        if ($('#mpn_2').attr('aria-expanded') == 'true') {
            mpn_2 = 0;
        }
        else {
            mpn_2 = 1;
        }
    });

    $('body').on('click', '#mpn_3', function () {
        if ($('#mpn_3').attr('aria-expanded') == 'true') {
            mpn_3 = 0;
        }
        else {
            mpn_3 = 1;
        }
    });


    $('body').on('click', '#mpa', function () {
        if ($('#mpa').attr('aria-expanded') == 'true') {
            mpa = 0;
        }
        else {
            ik = 0;
            im = 0;
            mpn = 0;
            mpa = 1;
        }
    });

    $('body').on('click', '#mpa_2', function () {
        if ($('#mpa_2').attr('aria-expanded') == 'true') {
            mpa_2 = 0;
        }
        else {
            mpa_2 = 1;
        }
    });

    $('body').on('click', '#mpa_3', function () {
        if ($('#mpa_3').attr('aria-expanded') == 'true') {
            mpa_3 = 0;
        }
        else {
            mpa_3 = 1;
        }
    });


});

function load_tab_pogr() {
    //alert(ik_2)
    if (ik == 1) {
        $('#ik').click();
        if (ik_2 == 1) {
            $('#ik_2').click();
        }
        if (ik_3 == 1) {
            $('#ik_3').click();
        }
    }


    if (im == 1) {
        $('#im').click();
        if (im_2 == 1) {
            $('#im_2').click();
        }
        if (im_3 == 1) {
            $('#im_3').click();
        }
    }


    if (mpn == 1) {
        $('#mpn').click();
        if (mpn_2 == 1) {
            $('#mpn_2').click();
        }
        if (mpn_3 == 1) {
            $('#mpn_3').click();
        }
    }


    if (mpa == 1) {
        $('#mpa').click();
        if (mpa_2 == 1) {
            $('#mpa_2').click();
        }
        if (mpa_3 == 1) {
            $('#mpa_3').click();
        }
    }


}

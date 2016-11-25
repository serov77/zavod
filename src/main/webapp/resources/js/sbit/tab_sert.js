var sert_ik;
var sert_ik_2;
var sert_ik_3;
var sert_ik_4;

var sert_im;
var sert_im_2;
var sert_im_3;
var sert_im_4;

var sert_mpn;
var sert_mpn_2;
var sert_mpn_3;
var sert_mpn_4;

var sert_mpa;
var sert_mpa_2;
var sert_mpa_3;
var sert_mpa_4;

$(document).ready(function () {
    $('body').on('click', '#sert_ik', function () {
        if ($('#sert_ik').attr('aria-expanded') == 'true') {
            sert_ik = 0;
        }
        else {
            sert_ik = 1;
            sert_im = 0;
            sert_mpn = 0;
            sert_mpa = 0;
        }
    });

    $('body').on('click', '#sert_ik_2', function () {
        if ($('#sert_ik_2').attr('aria-expanded') == 'true') {
            sert_ik_2 = 0;
        }
        else {
            sert_ik_2 = 1;
        }
    });

    $('body').on('click', '#sert_ik_3', function () {
        if ($('#sert_ik_3').attr('aria-expanded') == 'true') {
            sert_ik_3 = 0;
        }
        else {
            sert_ik_3 = 1;
        }
    });

    $('body').on('click', '#sert_ik_4', function () {
        if ($('#sert_ik_4').attr('aria-expanded') == 'true') {
            sert_ik_4 = 0;
        }
        else {
            sert_ik_4 = 1;
        }
    });




    $('body').on('click', '#sert_im', function () {
        if ($('#sert_im').attr('aria-expanded') == 'true') {
            sert_im = 0;
        }
        else {
            sert_ik = 0;
            sert_im = 1;
            sert_mpn = 0;
            sert_mpa = 0;
        }
    });

    $('body').on('click', '#sert_im_2', function () {
        if ($('#sert_im_2').attr('aria-expanded') == 'true') {
            sert_im_2 = 0;
        }
        else {
            sert_im_2 = 1;
        }
    });

    $('body').on('click', '#sert_im_3', function () {
        if ($('#sert_im_3').attr('aria-expanded') == 'true') {
            sert_im_3 = 0;
        }
        else {
            sert_im_3 = 1;
        }
    });

    $('body').on('click', '#sert_im_4', function () {
        if ($('#sert_ik_4').attr('aria-expanded') == 'true') {
            sert_im_4 = 0;
        }
        else {
            sert_im_4 = 1;
        }
    });





    $('body').on('click', '#sert_mpn', function () {
        if ($('#sert_mpn').attr('aria-expanded') == 'true') {
            sert_mpn = 0;
        }
        else {
            sert_ik = 0;
            sert_im = 0;
            sert_mpn = 1;
            sert_mpa = 0;
        }
    });

    $('body').on('click', '#sert_mpn_2', function () {
        if ($('#sert_mpn_2').attr('aria-expanded') == 'true') {
            sert_mpn_2 = 0;
        }
        else {
            sert_mpn_2 = 1;
        }
    });

    $('body').on('click', '#sert_mpn_3', function () {
        if ($('#sert_mpn_3').attr('aria-expanded') == 'true') {
            sert_mpn_3 = 0;
        }
        else {
            sert_mpn_3 = 1;
        }
    });

    $('body').on('click', '#sert_mpn_4', function () {
        if ($('#sert_mpn_4').attr('aria-expanded') == 'true') {
            sert_mpn_4 = 0;
        }
        else {
            sert_mpn_4 = 1;
        }
    });

    $('body').on('click', '#sert_mpa', function () {
        if ($('#sert_mpa').attr('aria-expanded') == 'true') {
            sert_mpa = 0;
        }
        else {
            sert_ik = 0;
            sert_im = 0;
            sert_mpn = 0;
            sert_mpa = 1;
        }
    });

    $('body').on('click', '#sert_mpa_2', function () {
        if ($('#sert_mpa_2').attr('aria-expanded') == 'true') {
            sert_mpa_2 = 0;
        }
        else {
            sert_mpa_2 = 1;
        }
    });

    $('body').on('click', '#sert_mpa_3', function () {
        if ($('#sert_mpa_3').attr('aria-expanded') == 'true') {
            sert_mpa_3 = 0;
        }
        else {
            sert_mpa_3 = 1;
        }
    });

    $('body').on('click', '#sert_mpa_4', function () {
        if ($('#sert_mpa_4').attr('aria-expanded') == 'true') {
            sert_mpa_4 = 0;
        }
        else {
            sert_mpa_4 = 1;
        }
    });
});

function load_tab_sert() {
    if (sert_ik == 1) {
        $('#sert_ik').click();
        if (sert_ik_2 == 1) {
            $('#sert_ik_2').click();
        }
        if (sert_ik_3 == 1) {
            $('#sert_ik_3').click();
        }
        if (sert_ik_4 == 1) {
            $('#sert_ik_4').click();
        }
    }

    if (sert_im == 1) {
        $('#sert_im').click();
        if (sert_im_2 == 1) {
            $('#sert_im_2').click();
        }
        if (sert_im_3 == 1) {
            $('#sert_im_3').click();
        }
        if (sert_im_4 == 1) {
            $('#sert_im_4').click();
        }
    }

    if (sert_mpn == 1) {
        $('#sert_mpn').click();
        if (sert_mpn_2 == 1) {
            $('#sert_mpn_2').click();
        }
        if (sert_mpn_3 == 1) {
            $('#sert_mpn_3').click();
        }
        if (sert_mpn_4 == 1) {
            $('#sert_mpn_4').click();
        }
    }

    if (sert_mpa == 1) {
        $('#sert_mpa').click();
        if (sert_mpa_2 == 1) {
            $('#sert_mpa_2').click();
        }
        if (sert_mpa_3 == 1) {
            $('#sert_mpa_3').click();
        }
        if (sert_mpa_4 == 1) {
            $('#sert_mpa_4').click();
        }
    }
}
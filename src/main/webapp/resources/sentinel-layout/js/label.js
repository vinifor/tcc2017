/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    function updateText(event) {
        var input = $(this);
        setTimeout(function () {
            var val = input.val();
            if (val !== "") {
                if (input.parent().parent().hasClass("floating-placeholder")) {
                    input.parent().parent().addClass("floating-placeholder-float");
                } else {
                    input.parent().addClass("floating-placeholder-float");
                }
            }
            else {
                if (input.parent().parent().hasClass("floating-placeholder-float")) {
                    input.parent().parent().removeClass("floating-placeholder-float");
                } else {
                    input.parent().removeClass("floating-placeholder-float");
                }
            }
        }, 1);
    }
//    $(".floating-placeholder input").keydown(updateText);
//    $(".floating-placeholder input").change(updateText);
    $(".floating-placeholder input").before(updateText);
//    $(".floating-placeholder textarea").keydown(updateText);
//    $(".floating-placeholder textarea").change(updateText);
    $(".floating-placeholder textarea").before(updateText);
});

$(document).ready(function () {
    function updateTextLight(event) {
        var input = $(this);
        setTimeout(function () {
            var val = input.val();
            if (val !== "")
                input.parent().addClass("floating-placeholder-light-float");
            else
                input.parent().removeClass("floating-placeholder-light-float");
        }, 1);
    }
    $(".floating-placeholder-light input").keydown(updateTextLight);
    $(".floating-placeholder-light input").change(updateTextLight);
    $(".floating-placeholder-light input").before(updateTextLight);
});

function updateForm() {
    function updateText(event) {
        var input = $(this);
        setTimeout(function () {
            var val = input.val();
            if (val !== "") {
                if (input.parent().parent().hasClass("floating-placeholder")) {
                    input.parent().parent().addClass("floating-placeholder-float");
                } else {
                    input.parent().addClass("floating-placeholder-float");
                }
            }
            else {
                if (input.parent().parent().hasClass("floating-placeholder-float")) {
                    input.parent().parent().removeClass("floating-placeholder-float");
                } else {
                    input.parent().removeClass("floating-placeholder-float");
                }
            }
        }, 1);
    }
    $(".floating-placeholder input").keydown(updateText);
    $(".floating-placeholder input").change(updateText);
    $(".floating-placeholder input").before(updateText);
    $(".floating-placeholder textarea").keydown(updateText);
    $(".floating-placeholder textarea").change(updateText);
    $(".floating-placeholder textarea").before(updateText);
}
;

function fo(input) {
    setTimeout(function () {
        input.parent().addClass("floating-placeholder-float");
    }, 1);
}

function bl(input) {
    setTimeout(function () {
        if (input.val() === "") {
            input.parent().removeClass("floating-placeholder-float");
        }
    }, 1);
}

function is(input) {
    setTimeout(function () {
        input.parent().parent().addClass("floating-placeholder-float");
    }, 1);
}

function acfo(input) {
    setTimeout(function () {
//        alert(input.val());
        input.parent().parent().addClass("floating-placeholder-float");
    }, 1);
}

function acbl(input) {
    setTimeout(function () {
        if (input.val() === "") {
            input.parent().parent().removeClass("floating-placeholder-float");
        }
    }, 1);
}

/* Máscaras ER */
function mascara(o, f) {
    v_obj = o
    v_fun = f
    setTimeout("execmascara()", 1)
}
function execmascara() {
    v_obj.value = v_fun(v_obj.value)
}
function mcep(v) {
    v = v.substring(0, 9)
    v = v.replace(/\D/g, "")                    //Remove tudo o que não é dígito
    v = v.replace(/^(\d{5})(\d)/, "$1-$2")         //Esse é tão fácil que não merece explicações
    return v;
}
function mtel(v) {
    v = v.replace(/\D/g, "");             //Remove tudo o que não é dígito
    v = v.replace(/^(\d{2})(\d)/g, "($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
    v = v.replace(/(\d)(\d{4})$/, "$1-$2");    //Coloca hífen entre o quarto e o quinto dígitos
    return v;
}
function cnpj(v) {
    v = v.replace(/\D/g, "")                           //Remove tudo o que não é dígito
    v = v.replace(/^(\d{2})(\d)/, "$1.$2")             //Coloca ponto entre o segundo e o terceiro dígitos
    v = v.replace(/^(\d{2})\.(\d{3})(\d)/, "$1.$2.$3") //Coloca ponto entre o quinto e o sexto dígitos
    v = v.replace(/\.(\d{3})(\d)/, ".$1/$2")           //Coloca uma barra entre o oitavo e o nono dígitos
    v = v.replace(/(\d{4})(\d)/, "$1-$2")              //Coloca um hífen depois do bloco de quatro dígitos
    return v;
}
function mcpf(v) {
    v = v.replace(/\D/g, "")                    //Remove tudo o que não é dígito
    v = v.replace(/(\d{3})(\d)/, "$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
    v = v.replace(/(\d{3})(\d)/, "$1.$2")       //Coloca um ponto entre o terceiro e o quarto dígitos
    //de novo (para o segundo bloco de números)
    v = v.replace(/(\d{3})(\d{1,2})$/, "$1-$2") //Coloca um hífen entre o terceiro e o quarto dígitos
    return v;
}
function mdata(v) {
    v = v.replace(/\D/g, "");                    //Remove tudo o que não é dígito
    v = v.replace(/(\d{2})(\d)/, "$1/$2");
    v = v.replace(/(\d{2})(\d)/, "$1/$2");

    v = v.replace(/(\d{2})(\d{2})$/, "$1$2");
    if (v.length > 0) {
        v = v.substring(0, 10);
    }
    return v;
}
function mdatahora(v) {
    v = v.replace(/\D/g, "");                    //Remove tudo o que não é dígito
    v = v.replace(/(\d{2})(\d)/, "$1/$2");
    v = v.replace(/(\d{2})(\d)/, "$1/$2");

    v = v.replace(/(\d{2})(\d{2})$/, "$1$2");
    if (v.length > 0) {
        v = v.substring(0, 19);
    }
    return v;
}
function mtempo(v) {
    v = v.replace(/\D/g, "");                    //Remove tudo o que não é dígito
    v = v.replace(/(\d{1})(\d{2})(\d{2})/, "$1:$2.$3");
    return v;
}
function mhora(v) {
    v = v.replace(/\D/g, "");                    //Remove tudo o que não é dígito
    v = v.replace(/(\d{2})(\d)/, "$1h$2");
    return v;
}
function mrg(v) {
    v = v.replace(/\D/g, "");                                      //Remove tudo o que não é dígito
    v = v.replace(/(\d)(\d{7})$/, "$1.$2");    //Coloca o . antes dos últimos 3 dígitos, e antes do verificador
    v = v.replace(/(\d)(\d{4})$/, "$1.$2");    //Coloca o . antes dos últimos 3 dígitos, e antes do verificador
    v = v.replace(/(\d)(\d)$/, "$1-$2");               //Coloca o - antes do último dígito
    return v;
}
function mnum(v) {
    v = v.replace(/\D/g, "");                                      //Remove tudo o que não é dígito
    return v;
}
function mvalor(v) {
    v = v.replace(/\D/g, "");//Remove tudo o que não é dígito
    v = v.replace(/(\d)(\d{8})$/, "$1.$2");//coloca o ponto dos milhões
    v = v.replace(/(\d)(\d{5})$/, "$1.$2");//coloca o ponto dos milhares

    return v;
}
function mvalor2(v) {
    v = v.replace(/\D/, "");//Remove tudo o que não é dígito
    v = v.replace(/(\d)(\d{8})$/, "$1.$2");//coloca o ponto dos milhões
    v = v.replace(/(\d)(\d{5})$/, "$1.$2");//coloca o ponto dos milhares

    if (v.length === 2) {
        return v + ',00';
    }
    return v;
}

PrimeFaces.locales['pt_BR'] = {
    closeText: 'Fechar',
    prevText: 'Anterior',
    nextText: 'Próximo',
    currentText: 'Começo',
    monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
    monthNamesShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Des'],
    dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
    dayNamesShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sáb'],
    dayNamesMin: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
    weekHeader: 'Semana',
    firstDay: 0,
    isRTL: false,
    showMonthAfterYear: false,
    yearSuffix: '',
    timeOnlyTitle: 'Só Horas',
    timeText: 'Tempo',
    hourText: 'Hora',
    minuteText: 'Minuto',
    secondText: 'Segundo',
    currentText: 'Data Atual',
            ampm: false,
    month: 'Mês',
    week: 'Semana',
    day: 'Dia',
    allDayText: 'Todo Dia'
};

window.onload = function startmenu() {
    if ($(document.getElementById("layout-menubar")).hasClass("slimmenu")) {
        $("#layout-portlets-cover").removeClass("sticky-body-open");
        $("#layout-portlets-cover").addClass("sticky-body-close");
    } else {
        $("#layout-portlets-cover").removeClass("sticky-body-close");
        $("#layout-portlets-cover").addClass("sticky-body-open");
    }
//    up();
};

function menuresize() {
    if ($(document.getElementById("layout-menubar")).hasClass("slimmenu")) {
        $("#layout-portlets-cover").removeClass("sticky-body-close");
        $("#layout-portlets-cover").addClass("sticky-body-open");
    } else {
        $("#layout-portlets-cover").removeClass("sticky-body-open");
        $("#layout-portlets-cover").addClass("sticky-body-close");
    }
//    up();
}

function logout() {
    window.location.replace(window.location.protocol + "//" + window.location.host + "/comercialweb/j_spring_security_logout");
}

function changeLang(a) {
    var b, elemento = "";
    if (document.createEvent) {
        var c = document.createEvent("HTMLEvents");
        c.initEvent("click", true, true)
    }
    if (a == 'pt') {
        elemento = $(".goog-te-banner-frame:eq(0)").contents().find("button[id*='restore']")
    } else {
        switch (a) {
            case 'de':
                b = "alem";
                break;
            case 'es':
                b = "espanhol";
                break;
            case 'fr':
                b = "fran";
                break;
            case 'en':
                b = "Ing";
                break;
            case 'it':
                b = "italiano";
                break
        }
        elemento = $(".goog-te-menu-frame:eq(0)").contents().find("span:contains('" + b + "')");
    }
    if (elemento.length > 0) {
        if (document.createEvent) {
            elemento[0].dispatchEvent(c)
        } else {
            elemento[0].click()
        }
    }
}

//function googleTranslateElementInit() {
//    new google.translate.TranslateElement({
//        pageLanguage: 'pt',
//        autoDisplay: false,
//        includedLanguages: 'de,es,fr,en,it',
//        layout: google.translate.TranslateElement.InlineLayout.SIMPLE
//    },
//    'google_translate_element');
//}
function googleTranslateElementInit() {
    new google.translate.TranslateElement({
        pageLanguage: 'pt',
        includedLanguages: 'en,pt',
        layout: google.translate.TranslateElement.InlineLayout.SIMPLE,
        autoDisplay: false},
    'google_translate_element');
}

function invisible() {
    var show = document.getElementById("show");
    var hide = document.getElementById("hide");
    if (show.style.display === "none") {
        show.style.display = "inline-block";
        hide.style.display = "none";
    } else {
        hide.style.display = "inline-block";
        show.style.display = "none";
    }
}

function switchLoc(text) {
    var searchInput = document.getElementById("form:list:filter");
    searchInput.placeholder = text;
}


function pasarMayuscula(obj, id) {
    obj = obj.toUpperCase();
    document.getElementById(id).value = obj;
}

function pasarMinuscula(obj, id) {
    obj = obj.toLowerCase();
    document.getElementById(id).value = obj;
}
function validarLetras(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla == 8)
        return true;// backspace
    if (tecla == 32)
        return true;// espacio
    if (tecla == 9)
        return true;// tab
    patron = /[A-Za-z\s]/;
    te = String.fromCharCode(tecla);
    return patron.test(te);// prueba de patron
}

function ValidarNumFloat(e, obj) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla == 8)
        return true;
    if (tecla == 32)
        return true;// espacio
    if (tecla == 9)
        return true;// tab
    Punto = obj.value.split('.');
    if (Punto.length >= 2) {
        patron = /[0-9]/;
    }
    else 
        patron = /[0-9.]/;
    te = String.fromCharCode(tecla);

    return patron.test(te);
}

function validarNum(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla == 8)
        return true;
    if (tecla == 32)
        return true;// espacio
    if (tecla == 9)
        return true;// tab
    patron = /\d/;
    te = String.fromCharCode(tecla);
    return patron.test(te);
}

function validarCalendario(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    patron = /[A-Za-z\s]/;
    te = String.fromCharCode(tecla);
    return patron.test(te);// prueba de patron
}

function pasarValor(obj, id) {
    document.getElementById(id).value = obj;
    alert('hola' + id);
}
PrimeFaces.locales['es'] = {
    closeText : 'Cerrar', prevText : 'Anterior', nextText : 'Siguiente', monthNames : ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'], monthNamesShort : ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'], dayNames : ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'], dayNamesShort : ['Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'], dayNamesMin : ['D', 'L', 'M', 'X', 'J', 'V', 'S'], weekHeader : 'Semana', firstDay : 1, isRTL : false, showMonthAfterYear : false, yearSuffix : '', timeOnlyTitle : 'Sólo hora', timeText : 'Tiempo', hourText : 'Hora', minuteText : 'Minuto', secondText : 'Segundo', currentText : 'Fecha actual', ampm : false, month : 'Mes', week : 'Semana', day : 'Día', allDayText : 'Todo el día'
};

function isNumberKey(evt) {
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
        return false;

    return true;
}
$(document).unbind('keydown').bind('keydown', function (event) {
    var doPrevent = false;
    if (event.which === 8 || event.keyCode === 8) {
        var d = event.srcElement || event.target;
        if ((d.tagName.toUpperCase() === 'INPUT' && 
        (d.type.toUpperCase() === 'TEXT' || 
        d.type.toUpperCase() === 'PASSWORD' || 
        d.type.toUpperCase() === 'FILE' || 
        d.type.toUpperCase() === 'EMAIL' || 
        d.type.toUpperCase() === 'SEARCH' || 
        d.type.toUpperCase() === 'DATE')) || 
        d.tagName.toUpperCase() === 'TEXTAREA') {
            doPrevent = d.readOnly || d.disabled;
        }else if (document.activeElement.type != "text") {
            // Cancel backspace if not in a text element
            doPrevent = true;
        }
        else {
            doPrevent = true;
        }

    }
    if (doPrevent) {
        event.preventDefault();
    }
    if ((event.which === 13 || event.keyCode === 13)) {
        return false;
    }
    else {
        return true;
    }
});

function getCaretPosition(ctrl) {
    var CaretPos = 0;    // IE Support
    if (document.selection) {
        ctrl.focus();
        var Sel = document.selection.createRange();
        Sel.moveStart('character', -ctrl.value.length);
        CaretPos = Sel.text.length;
    }
    // Firefox support
    else if (ctrl.selectionStart || ctrl.selectionStart == '0') {
        CaretPos = ctrl.selectionStart;
    }

    return CaretPos;
}

function setCaretPosition(ctrl, pos) {
    if (ctrl.setSelectionRange) {
        ctrl.focus();
        ctrl.setSelectionRange(pos,pos);
    }
    else if (ctrl.createTextRange) {
        var range = ctrl.createTextRange();
        range.collapse(true);
        range.moveEnd('character', pos);
        range.moveStart('character', pos);
        range.select();
    }
}

$(function() {
validarMayusculas('input');
validarMayusculas('TEXTAREA');
});

function validarMayusculas(nameTag){
     $(nameTag).keyup(function(e) {
    var caretPosition = getCaretPosition(this);
     tecla = (document.all) ? e.keyCode : e.which;
    if(tecla == 37 || tecla == 38 || tecla == 39 || tecla == 40 || tecla == 46 || tecla == 32|| tecla == 8) {
        return;
    }
        this.value = this.value.toLocaleUpperCase();
        setCaretPosition(this, caretPosition);
    });
}
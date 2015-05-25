
              
 function pasarMayuscula(obj, id) {
                  if (tecla == 8)
                      return true;// backspace
                  if (tecla == 32)
                      return true;// espacio
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
                  patron =/[A-Za-z\s]/; 
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
                  patron =/[A-Za-z\s]/; 
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
          
 function isNumberKey(evt)
      {
         var charCode = (evt.which) ? evt.which : event.keyCode
         if (charCode != 46 && charCode > 31 && (charCode < 48 || charCode > 57))
            return false;

         return true;
      }

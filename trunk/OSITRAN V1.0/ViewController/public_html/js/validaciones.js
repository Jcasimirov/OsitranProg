
              
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
                  patron = /[a-zA-Z]/;//patron
                  te = String.fromCharCode(tecla);
                  return patron.test(te);// prueba de patron
              }

 PrimeFaces.locales['es'] = {
              closeText : 'Cerrar', prevText : 'Anterior', nextText : 'Siguiente', monthNames : ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'], monthNamesShort : ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'], dayNames : ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'], dayNamesShort : ['Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'], dayNamesMin : ['D', 'L', 'M', 'X', 'J', 'V', 'S'], weekHeader : 'Semana', firstDay : 1, isRTL : false, showMonthAfterYear : false, yearSuffix : '', timeOnlyTitle : 'Sólo hora', timeText : 'Tiempo', hourText : 'Hora', minuteText : 'Minuto', secondText : 'Segundo', currentText : 'Fecha actual', ampm : false, month : 'Mes', week : 'Semana', day : 'Día', allDayText : 'Todo el día'
          };

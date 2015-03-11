
function saludo(){
alert('HOLA MUNDO');
}

function pasarMayuscula(obj, id) {
                  obj = obj.toUpperCase();
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



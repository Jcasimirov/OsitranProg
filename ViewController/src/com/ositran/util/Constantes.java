package com.ositran.util;

import java.io.File;


public class Constantes {
    public static String SO = System.getProperty("os.name");
    public static String UNIDAD="D:";
    public static String RUTA=SO.toUpperCase().startsWith("W")?UNIDAD+File.separator :File.separator +"usr"+File.separator ;
    public static String RUTACONTRATOSPDF=RUTA+ File.separator +"filesositran"+File.separator+"temp"+File.separator+"contratos"+File.separator;
    public static String RUTAFICHASRESUMEN=RUTA+File.separator +"filesositran"+File.separator+"temp"+File.separator +"resumen"+File.separator;
    public static String RUTAADENDA=RUTA+File.separator +"filesositran"+File.separator +"temp"+File.separator +"adendas"+File.separator;
    public static String RUTAADENDAENTREGA=RUTA+File.separator +"filesositran"+File.separator +"temp"+File.separator +"entrega"+File.separator;
    public static String RUTACAO=RUTA+File.separator +"filesositran"+File.separator +"temp"+File.separator +"cao"+File.separator;
    public static String RUTAHITO=RUTA+File.separator +"filesositran"+File.separator +"temp"+File.separator +"hito"+File.separator;
    public static String RUTAPPO=RUTA+File.separator +"filesositran"+File.separator +"temp"+File.separator +"ppo"+File.separator;
    public static String RUTAPENALIDADES=RUTA+File.separator +"filesositran"+File.separator +"temp"+File.separator +"penalidades"+File.separator;

    public static String ARCHIVONOENCONTRADO = "Archivo no encontrado.";
    public static String EXITOCONTRATOACTUALIZADO = "Contrato Actualizado Satisfactoriamente.";
    public static String GRABARMENSAJESATISFACTORIO = "Se Grabo Satisfactoriamente.";
    public static String ELIMINARMENSAJESATISFACTORIO = "Se Elimino Satisfactoriamente.";
    public static String ERRORGUARDAR = "No se pudo Guardar.";
    public static String ERRORBORRAR = "No se pudo Borrar.";
    public static String EXITO = "Exito";
    public static String ERROR = "Error";
    public static String SELECCIONECONTRATO = "Seleccione un Contrato";
    public static Integer SUPERVISADOXOSITRAN=1;
    public static Integer SUPERVISADOXINDICACION=0;
    public static Integer TIPINFAEROPUERTOS=2;
    
    public static String RUTANOTIFICACION=RUTA+File.separator +"filesositran"+File.separator +"temp"+File.separator +"notificacion"+File.separator ;
    
    public static Integer ESTADORECONOCIMIENTO_OBSERVADO=0;
    public static Integer ESTADORECONOCIMIENTO_DECLARADO=4;
    public static Integer ESTADORECONOCIMIENTO_RECTIFICADO=5;
    public static Integer SOLES=1;
}

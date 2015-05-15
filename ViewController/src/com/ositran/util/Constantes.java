package com.ositran.util;

import java.io.File;


public class Constantes {
    public static String SO = System.getProperty("os.name");
    public static String FILESEPARATOR=File.separator+File.separator;
    public static String RAIZWINDOWS="D:"+FILESEPARATOR;
    public static String RAIZUNIX=File.separator +"usr"+File.separator;
    public static String DIRECTORIO="filesositran"+FILESEPARATOR+"temp"+FILESEPARATOR;
    public static String RUTABASE=SO.toUpperCase().startsWith("W")?RAIZWINDOWS+DIRECTORIO:RAIZUNIX+DIRECTORIO;
    
    public static String RUTACONTRATOSPDF=RUTABASE+"contratos"+File.separator;
    public static String RUTAFICHASRESUMEN=RUTABASE+"resumen"+File.separator;
    public static String RUTAADENDA=RUTABASE+"adendas"+File.separator;
    public static String RUTAADENDAENTREGA=RUTABASE+"entrega"+File.separator;
    public static String RUTACAO=RUTABASE+"cao"+File.separator;
    public static String RUTAHITO=RUTABASE+"hito"+File.separator;
    public static String RUTAPPO=RUTABASE+"ppo"+File.separator;
    public static String RUTAPENALIDADES=RUTABASE+"penalidades"+File.separator;
    public static String RUTANOTIFICACION=RUTABASE+"notificacion"+File.separator ;

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
    

    
    public static Integer ESTADORECONOCIMIENTO_OBSERVADO=0;
    public static Integer ESTADORECONOCIMIENTO_DECLARADO=4;
    public static Integer ESTADORECONOCIMIENTO_RECTIFICADO=5;
    public static Integer SOLES=1;
}

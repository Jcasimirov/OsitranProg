package com.ositran.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.text.SimpleDateFormat;

import java.util.Date;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;

public class Reutilizar {
    public static Reutilizar newInstance=new Reutilizar();
    SimpleDateFormat fd=new SimpleDateFormat("dd/MM/yyyy");
    public void copiarArchivoenServidor(String rutadestino, InputStream in) {
        try {
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(rutadestino));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public DefaultStreamedContent preDownload(String rutaOrigen)throws FileNotFoundException{
      
            File file = new File(rutaOrigen);
            InputStream input = new FileInputStream(file);
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            return (new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
        
         
    }
    public void borrarArchivos(String ruta){
        File fichero=new File(ruta);
        fichero.delete();
    }
    
    public String convertirFechaenCadena(Date fecha){
        String dateacadena="";
        if(fecha!=null)
            dateacadena =fd.format(fecha);
        return dateacadena;
    }
    public static void setNewInstance(Reutilizar newInstance) {
        Reutilizar.newInstance = newInstance;
    }

    public static Reutilizar getNewInstance() {
        return newInstance;
    }

}

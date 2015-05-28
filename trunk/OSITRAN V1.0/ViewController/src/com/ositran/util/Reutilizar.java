package com.ositran.util;

import com.ositran.vo.bean.UsuarioVO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.net.UnknownHostException;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DefaultStreamedContent;

public class Reutilizar {
    private static Reutilizar newInstance;
    private  Reutilizar(){
        
    }
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
    public DefaultStreamedContent preDownload(String rutaOrigen)throws Exception{


        try {
            File file = new File(rutaOrigen);
            InputStream input = new FileInputStream(file);
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            return (new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
        } catch (Exception fnfe) {
           throw fnfe;
        }
       
    }
    public UsuarioVO obtenerDatosUsuarioLogueado(){
        FacesContext faceContext=FacesContext.getCurrentInstance();
        HttpServletRequest httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        HttpSession session = httpServletRequest.getSession();
        System.out.println("usuario que se logueo:"+((UsuarioVO)session.getAttribute("atributosUsuario")).getUsuNombre());
        return ((UsuarioVO)session.getAttribute("atributosUsuario"));
    }
    /* public SupervisorInversionesVO obtenerDatosEmpleadoLogueado(){
        FacesContext faceContext=FacesContext.getCurrentInstance();
        HttpServletRequest httpServletRequest=(HttpServletRequest)faceContext.getExternalContext().getRequest();
        HttpSession session = httpServletRequest.getSession();
        System.out.println("usuario que se logueo:"+((SupervisorInversionesVO)session.getAttribute("atributosEmpleado")).getTinId());
        return ((SupervisorInversionesVO)session.getAttribute("atributosEmpleado"));
    }  */
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
    public Date cambiarDiaenFecha(Date fecha,int dia){
        Calendar cal=Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.DAY_OF_MONTH,dia);
        return cal.getTime();
    }
    public static void setNewInstance(Reutilizar newInstance) {
        Reutilizar.newInstance = newInstance;
    }

    public static Reutilizar getNewInstance() {
        if(newInstance==null){
            newInstance=new Reutilizar();
        }
        return newInstance;
    }
    public BigDecimal sumaBigDecimal(BigDecimal monto1,BigDecimal monto2){
        monto1=monto1.add(monto2);
        return (monto1);
    }
    public BigDecimal restaBigDecimal(BigDecimal monto1,BigDecimal monto2){
        monto1=monto1.subtract(monto2);
        return monto1;
    }
    public BigDecimal multiplicaBigDecimal(BigDecimal monto1,BigDecimal monto2){
        monto1=monto1.multiply(monto2);
        return monto1;
    }
    public BigDecimal divideBigDecimal(BigDecimal monto1,BigDecimal monto2){
        monto1=monto1.divide(monto2);
        return monto1;
    }
    public static BigDecimal redondearBigDecimal(BigDecimal d) {
      return d.setScale(2, RoundingMode.HALF_EVEN);
    }
    public static String obtenerIpCliente(){
        //String remoteAddr = ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRemoteAddr();
        String remoteAddr = "";
        try {
            remoteAddr = java.net.InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException uhe) {
            // TODO: Add catch code
            uhe.printStackTrace();
        }
        return remoteAddr;
    }
    public Object copyD(Object orig) {
           Object obj = null;
           try {
               // Write the object out to a byte array
               ByteArrayOutputStream bos = new ByteArrayOutputStream();
               ObjectOutputStream out = new ObjectOutputStream(bos);
               out.writeObject(orig);
               out.flush();
               out.close();

               // Make an input stream from the byte array and read
               // a copy of the object back in.
               ObjectInputStream in = new ObjectInputStream(
                   new ByteArrayInputStream(bos.toByteArray()));
               obj = in.readObject();
           }
           catch(IOException e) {
               e.printStackTrace();
           }
           catch(ClassNotFoundException cnfe) {
               cnfe.printStackTrace();
           }
           return obj;
       }
    public static <T> T copy( T source )
      {
        try
        {
          ByteArrayOutputStream ostream = new ByteArrayOutputStream();
          ObjectOutputStream oostream = new ObjectOutputStream( ostream );
       
          oostream.writeObject( source );
          oostream.flush();
       
          byte[] bytes = ostream.toByteArray();
           
          InputStream istream = new ByteArrayInputStream( bytes );
          ObjectInputStream oistream = new ObjectInputStream( istream );
           
          return ( T )oistream.readObject();
        }
        catch( RuntimeException e )
          { throw e; }
        catch( Exception e )
          { throw new IllegalArgumentException( source.getClass().getName(), e ); }
      }
    public static Date obtenerFechaActual(){
        Date fecha=new Date();
        return fecha; 
    }
}

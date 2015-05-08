package com.ositran.daoimpl;

import com.ositran.dao.ValorizacionInversionAvanceDetalleDAO;
import com.ositran.model.InversionTipo;
import com.ositran.model.ValorizacionInversionAvanceDetalle;
import com.ositran.util.HibernateUtil;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class ValorizacionInversionAvanceDetalleDAOImpl implements ValorizacionInversionAvanceDetalleDAO {
    
    public ValorizacionInversionAvanceDetalleDAOImpl() {
        super();
    }

    @Override
    public List<ValorizacionInversionAvanceDetalle> query() throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(ValorizacionInversionAvanceDetalle.class).list();
    }
    
    @Override
    public List<ValorizacionInversionAvanceDetalle> query1(int codigoValorizacion) throws SQLException, Exception {
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        query =session.createQuery("FROM ValorizacionInversionAvanceDetalle  E WHERE E.tiaNumero=:busqueda ");
        query.setParameter("busqueda",codigoValorizacion);
        return query.list();
    }

    @Override
    public String insert(ValorizacionInversionAvanceDetalle valorizacionInversionAvanceDetalle) throws SQLException,
                                                                                                       Exception {
        System.out.println("DAO");
        System.out.println("monead"+valorizacionInversionAvanceDetalle.getMonId());
        System.out.println("CABECERA"+valorizacionInversionAvanceDetalle.getTiaNumero());
        System.out.println("INVER"+valorizacionInversionAvanceDetalle.getDtiId());
        System.out.println("INVERTIPO"+valorizacionInversionAvanceDetalle.getTivId());
        
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(valorizacionInversionAvanceDetalle);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
      
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            ValorizacionInversionAvanceDetalle valorizacionInversionAvanceDetalle = (ValorizacionInversionAvanceDetalle) session.get(ValorizacionInversionAvanceDetalle.class, id);
            session.delete(valorizacionInversionAvanceDetalle);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String update(ValorizacionInversionAvanceDetalle valorizacionInversionAvanceDetalle) throws SQLException,
                                                                                                       Exception {

        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(valorizacionInversionAvanceDetalle);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public ValorizacionInversionAvanceDetalle get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    
    @Override
    public List<ValorizacionInversionAvanceDetalle> getInvAvanceDetallesInvAvance(Integer tiaNumero) throws SQLException, Exception {
        
        System.out.println("INI DAO METHOD: getInvAvanceDetallesInvAvance");
        System.out.println("tiaNumero:" + tiaNumero);    
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
 
        Query query; 
        query = session.createSQLQuery("SELECT ia.TIA_NUMERO, " + 
        "ia.IAD_ID, " + 
        "ia.TIA_TOTAL, " + 
        "ia.TIA_MONTO_PRESENTADO, " + 
        "ia.IAD_IGV, " + 
        "ia.MON_ID, " + 
        "ia.IAD_PDF, " + 
        "ia.TIV_ID, " + 
        "ia.DTI_ID, " + 
        "ia.TIN_ID, " + 
        "ia.CSI_ID, " + 
        "ia.INF_ID, " + 
        "ia.INV_ID, " + 
        "ia.IAD_DESCRIPCION, " + 
        "ia.IAD_FEC_INICIO, " + 
        "ia.IAD_FEC_FIN,inv.INV_DESCRIPCION FROM  T_INV_AVN_DETALLE ia left join T_CONTRATO_INVERSION inv " +
                                    " on ia.INV_ID=inv.INV_ID \n" + 
                                    " where  ia.tia_Numero = :tianumero order by ia.iad_Id DESC");
        query.setParameter("tianumero",tiaNumero);          
        List<Object[]> list = (List<Object[]>)query.list();
        List<ValorizacionInversionAvanceDetalle> lista=new ArrayList<ValorizacionInversionAvanceDetalle>();
        for (Object[] item : list) {
            ValorizacionInversionAvanceDetalle avnAvnDetalle=new ValorizacionInversionAvanceDetalle();
           avnAvnDetalle.setTiaNumero(item[0]!=null?(new Integer(item[0].toString())):null); 
           avnAvnDetalle.setIad_Id(item[1]!=null?new Integer(item[1].toString()):null);  
           avnAvnDetalle.setTiaTotal(item[2]!=null?(BigDecimal)item[2]:null);    
           avnAvnDetalle.setMontoPresentado(item[3]!=null?(BigDecimal)item[3]:null);   
           avnAvnDetalle.setIgv(item[4]!=null?(BigDecimal)item[4]:null); 
           avnAvnDetalle.setMonId(item[5]!=null?new Integer(item[5].toString()):null);   
           avnAvnDetalle.setIadPDF(item[6]!=null?item[6].toString():null);
           avnAvnDetalle.setTivId(item[7]!=null?new Integer(item[7].toString()):null);
           avnAvnDetalle.setDtiId(item[8]!=null?new Integer(item[8].toString()):null);          
           avnAvnDetalle.setTinId(item[9]!=null?new Integer(item[9].toString()):null);
           avnAvnDetalle.setCsiId(item[10]!=null?new Integer(item[10].toString()):null);
           avnAvnDetalle.setInfId(item[11]!=null?new Integer(item[11].toString()):null);  
           avnAvnDetalle.setInvId(item[12]!=null?new Integer(item[12].toString()):null);
           avnAvnDetalle.setIadDescripcion(item[13]!=null?item[13].toString():null);           
           avnAvnDetalle.setIadFechaInicio(item[14]!=null?(Date)item[14]:null);           
           avnAvnDetalle.setIadFechaFin(item[15]!=null?(Date)item[15]:null);
           avnAvnDetalle.setNombreInversion(item[16]!=null?item[16].toString():null);
           lista.add(avnAvnDetalle);
       }
        System.out.println("FIN DAO METHOD: getInvAvanceDetallesInvAvance");
        session.close();
        return lista; 


    }
    
    
}

package com.ositran.daoimpl;


import com.ositran.dao.AsignarResponsableSupDAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import java.sql.SQLException;
import com.ositran.util.HibernateUtil;
import com.ositran.model.ContratoResSupDetalle;
import com.ositran.model.ContratoRespSup;


public class AsignarResponsableSupDAOImpl implements AsignarResponsableSupDAO {
    

    public AsignarResponsableSupDAOImpl() {
        super();
    }
    
    @Override
    public List<ContratoResSupDetalle> ListarDetalle(int codigoContrato, int compromiso) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query;
        query = session.createQuery("From ContratoResSupDetalle c where c.conId = :contrato and c.rsdEstado <> 0 and c.ccoId = :compromiso");
        query.setParameter("contrato",codigoContrato);
        query.setParameter("compromiso",compromiso);
        List<ContratoResSupDetalle> list = query.list();
        session.getTransaction().commit();
        session.close();
        return list; 
    }


    @Override
    public ContratoRespSup insertCab(ContratoRespSup contratoRespSup) throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(contratoRespSup);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return contratoRespSup;
    }
    
    @Override
    public String insertDet(ContratoResSupDetalle contratoResSupDetalle) throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(contratoResSupDetalle);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }
    

    @Override
    public String updateDet(ContratoResSupDetalle contratoResSupDetalle) throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contratoResSupDetalle);
            session.getTransaction().commit();            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public ContratoRespSup getCab(Integer id) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ContratoRespSup ccntratoRespSup=(ContratoRespSup)session.get(ContratoRespSup.class, id);
        session.getTransaction().commit();
        return ccntratoRespSup;
    }
    
    
    @Override
    public ContratoResSupDetalle getDet(Integer id) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ContratoResSupDetalle contratoResSupDetalle=(ContratoResSupDetalle)session.get(ContratoResSupDetalle.class, id);
        session.getTransaction().commit();
        return contratoResSupDetalle;
    }
    
    @Override
    public ContratoRespSup ValidaCab(Integer concesion, Integer compromiso) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM ContratoRespSup c WHERE c.csiId = :concesion and c.ccoId = :compromiso ");
        query.setParameter("concesion",concesion);
        query.setParameter("compromiso",compromiso);
        List<ContratoRespSup> lista= query.list();
        session.getTransaction().commit();
        session.close();
        if (lista.size() > 0){
            ContratoRespSup cab = lista.get(lista.size() - 1);
            return cab;
        }        
         return null; 
    }
    
    @Override
    public String ObtieneNombre(Integer tipoDoc, String nroDocumento,Integer tipoSup) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();    
        Query query;
        String nombre = "";
        if(tipoSup != null && tipoSup>0){
            if(tipoSup == 1){
                query=session.createQuery("select s.tsiNombre FROM SupervisorInversiones s WHERE s.tsiNroDocumento = :nro and s.tdoId = :tipo ");
            }else {
                query=session.createQuery("select e.supNombre FROM EmpresaSupervisora e WHERE e.supNroDocumento = :nro and e.tdoId = :tipo ");
            }    
            query.setParameter("nro",nroDocumento);  
            query.setParameter("tipo",tipoDoc);  
            nombre = query.uniqueResult().toString();
            session.getTransaction().commit();
            session.close();
        }        
        return nombre; 
    }
    
    @Override
    public int ValidaAsignación(Integer contrato, Integer tipoInfra, Integer compromiso, Integer concesion, Integer aeropuerto, Integer inversion, Integer tipoDoc, String nroDoc, Integer tipoQuery) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();    
        Query query;
        int validacion = 0;
        //tipoQuery filtra el query si es para aeropuerto o para los otros tipos de infraestructuras
        if(tipoQuery == 1){
            query=session.createQuery("select count(det) \n" + 
            "from ContratoResSupDetalle det, ContratoRespSup cab\n" + 
            "where cab.rsuId = det.rsuId and \n" + 
            "      cab.conId = :contrato and \n" + 
            "      cab.ccoId = :compromiso and \n" + 
            "      cab.tccTipo = 1 and \n" + 
            "      cab.invId = :inversion and \n" + 
            "      cab.infId = :aeropuerto and \n" + 
            "      cab.tinId = :tipoInfraestructura and \n" + 
            "      cab.csiId = :concesion and \n" + 
            "      det.tdoId = :tipodocumento and \n" + 
            "      det.rsdEstado = 1 and \n" + 
            "      det.rsdNroDocumento = :nrodocumento " );
            
            
            query.setParameter("inversion",inversion); 
            query.setParameter("aeropuerto",aeropuerto); 
            
        }else{
            query=session.createQuery("select count(det) \n" + 
            "from ContratoResSupDetalle det, ContratoRespSup cab \n" + 
            "where cab.rsuId = det.rsuId and \n" + 
            "      cab.conId = :contrato and \n" + 
            "      cab.ccoId = :compromiso and \n" + 
            "      cab.tccTipo = 1 and \n" + 
            "      cab.tinId = :tipoInfraestructura and \n" + 
            "      cab.csiId = :concesion and \n" + 
            "      det.tdoId = :tipodocumento and \n" + 
            "      det.rsdEstado = 1 and \n" + 
            "      det.rsdNroDocumento = :nrodocumento");
            
        }                
        query.setParameter("contrato",contrato);  
        query.setParameter("tipoInfraestructura",tipoInfra); 
        query.setParameter("compromiso",compromiso); 
        query.setParameter("concesion",concesion); 
        query.setParameter("tipodocumento",tipoDoc); 
        query.setParameter("nrodocumento",nroDoc);
        String a = query.uniqueResult().toString();
        if (a != null || !a.trim().equals("")){
            validacion = Integer.parseInt(a);
        }
        session.getTransaction().commit();
        session.close();
       
        return validacion; 
    }
    
    @Override
    public  List<ContratoResSupDetalle> BuscarAsignacion (Integer contrato, Integer etapa, Integer aeropuerto, Integer inversion, Integer tipoSupervision) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();    
        Query query;
        String nombre = "";
        if(aeropuerto != null && aeropuerto != 0){
                query=session.createQuery("FROM ContratoResSupDetalle c WHERE c.conId = :contrato and c.ccoId = :etapa and c.tipoSup = :tipoSupervision and c.rsdEstado = 1 and c.infId = :aeropuerto c.invId = :inversion");
                query.setParameter("aeropuerto",aeropuerto);  
                query.setParameter("inversion",inversion); 
            }else {
                query=session.createQuery("FROM ContratoResSupDetalle c WHERE c.conId = :contrato and c.ccoId = :etapa and c.tipoSup = :tipoSupervision and c.rsdEstado = 1");                
            }    
            query.setParameter("contrato",contrato);  
            query.setParameter("etapa",etapa); 
            query.setParameter("tipoSupervision",tipoSupervision); 
            List<ContratoResSupDetalle> list = query.list();
            session.getTransaction().commit();
            session.close();
            return list; 
        }          
    
}

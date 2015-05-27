package com.ositran.daoimpl;


import com.ositran.dao.AsignarResponsableSupDAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import java.sql.SQLException;
import com.ositran.util.HibernateUtil;
import com.ositran.model.ContratoResSupDetalle;
import com.ositran.model.ContratoRespSup;

import org.hibernate.Transaction;


public class AsignarResponsableSupDAOImpl implements AsignarResponsableSupDAO {

    public AsignarResponsableSupDAOImpl() {
        super();
    }
    
    @Override
    public List<ContratoResSupDetalle> ListarDetalle(Integer codigoContrato, Integer compromiso, Integer codigoAeropuerto, Integer codigoInversion) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            Query query;
            tx=session.beginTransaction();
            if((codigoAeropuerto != null && codigoAeropuerto != 0) && (codigoInversion!=null && codigoInversion == 0)){
                    query=session.createQuery("select distinct c FROM ContratoResSupDetalle c WHERE c.conId = :contrato and c.ccoId = :etapa  and c.rsdEstado > 0 and c.infId = :aeropuerto");
                    query.setParameter("aeropuerto",codigoAeropuerto);  
                
            }else if(codigoAeropuerto != null && codigoAeropuerto != 0  && codigoInversion !=null && codigoInversion != 0){
                    query=session.createQuery("select distinct c FROM ContratoResSupDetalle c WHERE c.conId = :contrato and c.ccoId = :etapa  and c.rsdEstado > 0 and c.infId = :aeropuerto and c.invId = :inversion");
                    query.setParameter("aeropuerto",codigoAeropuerto);  
                    query.setParameter("inversion",codigoInversion); 
            }else {
                    query=session.createQuery("select distinct c FROM ContratoResSupDetalle c WHERE c.conId = :contrato and c.ccoId = :etapa  and c.rsdEstado > 0 ");                
            }    
            query.setParameter("contrato",codigoContrato);
            query.setParameter("etapa",compromiso);
            List<ContratoResSupDetalle> list = query.list();
            tx.commit();
            return list;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }


    @Override
    public ContratoRespSup insertCab(ContratoRespSup contratoRespSup) throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.persist(contratoRespSup);
            tx.commit();
            return contratoRespSup;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result=e.getMessage();
            throw e;
        } finally {
            session.close();
	}
    }
    
    @Override
    public String insertDet(ContratoResSupDetalle contratoResSupDetalle) throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.persist(contratoResSupDetalle);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result=e.getMessage();
        } finally {
            session.close();
	}
        return result;
    }
    

    @Override
    public String updateDet(ContratoResSupDetalle contratoResSupDetalle) throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(contratoResSupDetalle);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result=e.getMessage();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public ContratoRespSup getCab(Integer id) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoRespSup ccntratoRespSup=(ContratoRespSup)session.get(ContratoRespSup.class, id);
            tx.commit();
            return ccntratoRespSup;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
    
    @Override
    public ContratoResSupDetalle getDet(Integer id) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoResSupDetalle contratoResSupDetalle=(ContratoResSupDetalle)session.get(ContratoResSupDetalle.class, id);
            tx.commit();
            return contratoResSupDetalle;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
    
    @Override
    public ContratoRespSup ValidaCab(Integer concesion, Integer compromiso) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        List<ContratoRespSup> lista;
        try {
            tx=session.beginTransaction();
            Query query;
            query=session.createQuery("FROM ContratoRespSup c WHERE c.csiId = :concesion and c.ccoId = :compromiso ");
            query.setParameter("concesion",concesion);
            query.setParameter("compromiso",compromiso);
            lista=query.list();
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
        if (lista!=null && lista.size() > 0){
            ContratoRespSup cab = lista.get(lista.size() - 1);
            return cab;
        }
        return null; 
    }
    
    @Override
    public String ObtieneNombre(Integer tipoDoc, String nroDocumento,Integer tipoSup) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        Query query;
        String nombre = "";
        if(tipoSup != null && tipoSup>0){
            try {
                tx=session.beginTransaction();
                if(tipoSup == 1){
                    query=session.createQuery("select s.tsiNombre FROM SupervisorInversiones s WHERE s.tsiNroDocumento = :nro and s.tdoId = :tipo ");
                }else {
                    query=session.createQuery("select e.supNombre FROM EmpresaSupervisora e WHERE e.supNroDocumento = :nro and e.tdoId = :tipo ");
                }    
                query.setParameter("nro",nroDocumento);  
                query.setParameter("tipo",tipoDoc);  
                nombre = query.uniqueResult().toString();
                tx.commit();
            } catch (Exception e) {
                if (tx!=null) {
                    tx.rollback();
                }
                throw e;
            } finally {
                session.close();
            }
        }
        return nombre;
    }
    
    @Override
    public String ObtieneCorreo(Integer tipoDoc, String nroDocumento,Integer tipoSup) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        Query query;
        String nombre = "";
        if(tipoSup != null && tipoSup>0){
            try {
                tx=session.beginTransaction();
                if(tipoSup == 1){
                    query=session.createQuery("select s.tsiCorreo FROM SupervisorInversiones s WHERE s.tsiNroDocumento = :nro and s.tdoId = :tipo ");
                }else {
                    query=session.createQuery("select e.supCorreo FROM EmpresaSupervisora e WHERE e.supNroDocumento = :nro and e.tdoId = :tipo ");
                }    
                query.setParameter("nro",nroDocumento);  
                query.setParameter("tipo",tipoDoc);  
                nombre = query.uniqueResult().toString();
                tx.commit();
            } catch (Exception e) {
                if (tx!=null) {
                    tx.rollback();
                }
                throw e;
            } finally {
                session.close();
            }
        }        
        return nombre;
    }
    
    @Override
    public int ValidaAsignación(Integer contrato, Integer tipoInfra, Integer compromiso, Integer concesion, Integer aeropuerto, Integer inversion, Integer tipoDoc, String nroDoc, Integer tipoQuery) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        Query query;
        int validacion = 0;
        try {
            tx=session.beginTransaction();
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
            tx.commit();
            return validacion;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
    
    @Override
    public  List<ContratoResSupDetalle> BuscarAsignacion (Integer contrato, Integer etapa, Integer aeropuerto, Integer inversion, Integer tipoSupervision) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        Query query;
        String nombre = "";
            try {
                tx=session.beginTransaction();
                if((aeropuerto != null && aeropuerto != 0) && (inversion == null || inversion == 0)){

                        query=session.createQuery("FROM ContratoResSupDetalle c WHERE c.conId = :contrato and c.ccoId = :etapa and c.tipoSup = :tipoSupervision and c.rsdEstado = 1 and c.infId = :aeropuerto");
                        query.setParameter("aeropuerto",aeropuerto);  
                    
                }else if((aeropuerto != null && aeropuerto != 0) && inversion != null && inversion != 0){
                        query=session.createQuery("FROM ContratoResSupDetalle c WHERE c.conId = :contrato and c.ccoId = :etapa and c.tipoSup = :tipoSupervision and c.rsdEstado = 1 and c.infId = :aeropuerto and c.invId = :inversion");
                        query.setParameter("aeropuerto",aeropuerto);  
                        query.setParameter("inversion",inversion); 
                    }else {
                        query=session.createQuery("FROM ContratoResSupDetalle c WHERE c.conId = :contrato and c.ccoId = :etapa and c.tipoSup = :tipoSupervision and c.rsdEstado =1");                
                    }    
                query.setParameter("contrato",contrato);  
                query.setParameter("etapa",etapa); 
                query.setParameter("tipoSupervision",tipoSupervision); 
                List<ContratoResSupDetalle> list = query.list();
                tx.commit();
                return list;
            } catch (Exception e) {
                if (tx!=null) {
                    tx.rollback();
                }
                throw e;
            } finally {
                session.close();
            }
        }
}
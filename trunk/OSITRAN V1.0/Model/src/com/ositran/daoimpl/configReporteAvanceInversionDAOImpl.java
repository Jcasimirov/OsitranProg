package com.ositran.daoimpl;

import com.ositran.dao.configReporteAvanceInversionDAO;
import com.ositran.model.Concesion;
import com.ositran.model.TRepCnfgAvncInvCab;
import com.ositran.model.TRepCnfgAvncInvDet;
import com.ositran.util.HibernateUtil;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class configReporteAvanceInversionDAOImpl implements configReporteAvanceInversionDAO {
    
    public List<TRepCnfgAvncInvCab> obtenerTRepCnfgAvncInvCabActiva() throws Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List<TRepCnfgAvncInvCab> list=(List<TRepCnfgAvncInvCab>)session.createQuery("FROM TRepCnfgAvncInvCab a WHERE a.caiEstado=1").list();
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
    
    public List<Object> obtenerReporteInversionConDetalle() throws Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List<Object> list=session.createQuery("SELECT det, con, tipo " + 
            "FROM TRepCnfgAvncInvCab cab, TRepCnfgAvncInvDet det, Concesion con, InfraestructuraTipo tipo " + 
            "WHERE cab.caiEstado=1 AND det.caiId=cab.caiId AND det.csiId=con.csiId AND det.tinId=con.tinId AND con.tinId=tipo.tinId").list();
            List<Concesion> concesionesConfiguradas=new ArrayList<Concesion>();
            for (Object aux : list) {
                concesionesConfiguradas.add((Concesion)(((Object[])aux)[1]));
            }
            List<Object> list2=session.createQuery("SELECT con, tipo " + 
            "FROM Concesion con, InfraestructuraTipo tipo " + 
            "WHERE con.tinId=tipo.tinId AND NOT EXISTS (FROM TRepCnfgAvncInvCab cab, TRepCnfgAvncInvDet det " + 
            "WHERE cab.caiEstado=1 AND det.caiId=cab.caiId AND det.csiId=con.csiId AND det.tinId=con.tinId)").list();
            //System.out.println("LIST ANTES DE AGREGAR: "+list.size());
            list.addAll(list2);
            //System.out.println("LIST DESPUÉS DE AGREGAR: "+list.size());
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
    
    public List<Object> obtenerReporteInversionSinDetalle() throws Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List<Object> list=session.createQuery("SELECT con, tipo " +
            "FROM Concesion con, InfraestructuraTipo tipo " +
            "WHERE con.tinId=tipo.tinId").list();
            //for (Object aux : list) {
            //System.out.println((((Object[])aux)[0]).getCsiId()+"   "+concesion.getTinId());
            //}
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
    public void actualizaConfigReporteInversion(List<TRepCnfgAvncInvDet> reporteInversionPersistente, TRepCnfgAvncInvCab cabReporteInversionActivoPersistente) throws Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(cabReporteInversionActivoPersistente);
            for(TRepCnfgAvncInvDet aux : reporteInversionPersistente) {
                if (aux.getAidId()==null) {
                    //BigDecimal secuenciaGenerada=(BigDecimal)session.createSQLQuery("select sq_rep_cnfg_avnc_inv_det.nextval from dual").uniqueResult();
                    //aux.setAidId(secuenciaGenerada);
                    session.persist(aux);
                } else {
                    session.update(aux);
                }
            }
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
    
    @Override
    public void insertaConfigReporteInversion(List<TRepCnfgAvncInvDet> reporteInversionPersistente, TRepCnfgAvncInvCab cabReporteInversionActivoPersistente) throws Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.persist(cabReporteInversionActivoPersistente);
            List<TRepCnfgAvncInvCab> list=(List<TRepCnfgAvncInvCab>)session.createQuery("FROM TRepCnfgAvncInvCab a WHERE a.caiEstado=1").list();
            if(list==null || list.size()==0) {
                throw new IllegalStateException("No se obtuvo algún REPORTE DE AVANCE DE INVERSIÓN ACTIVO. Verificar en la tabla \"t_rep_cnfg_avnc_inv_cab\"");
            } else {
                if(list.size()>1) {
                    throw new IllegalStateException("Se obtuvo más de un REPORTE DE AVANCE DE INVERSIÓN ACTIVO. Verificar en la tabla \"t_rep_cnfg_avnc_inv_cab\"");
                } else {
                    BigDecimal cabID=list.get(0).getCaiId();
                    for(TRepCnfgAvncInvDet aux : reporteInversionPersistente) {
                        aux.setCaiId(cabID);
                        //BigDecimal secuenciaGenerada=(BigDecimal)session.createSQLQuery("select sq_rep_cnfg_avnc_inv_det.nextval from dual").uniqueResult();
                        //aux.setAidId(secuenciaGenerada);
                        session.persist(aux);
                    }
                    tx.commit();
                }
            }
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
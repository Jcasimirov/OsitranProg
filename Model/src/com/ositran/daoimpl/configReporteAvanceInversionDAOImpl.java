package com.ositran.daoimpl;

import com.ositran.dao.configReporteAvanceInversionDAO;
import com.ositran.model.TRepCnfgAvncInvCab;
import com.ositran.model.TRepCnfgAvncInvDet;
import com.ositran.util.HibernateUtil;

import java.math.BigDecimal;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public class configReporteAvanceInversionDAOImpl implements configReporteAvanceInversionDAO {
    
    public List<TRepCnfgAvncInvDet> obtenerTodoTRepCnfgAvncInvDet() throws HibernateException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        try {
            List<TRepCnfgAvncInvDet> list=(List<TRepCnfgAvncInvDet>)session.createQuery("From TRepCnfgAvncInvDet").list();
            session.getTransaction().commit();
            return list;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public List<TRepCnfgAvncInvCab> obtenerTRepCnfgAvncInvCabActiva() throws HibernateException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        try {
            List<TRepCnfgAvncInvCab> list=(List<TRepCnfgAvncInvCab>)session.createQuery("FROM TRepCnfgAvncInvCab a WHERE a.caiEstado=1").list();
            session.getTransaction().commit();
            return list;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public List<Object> obtenerReporteInversionConDetalle() throws HibernateException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        try {
            List<Object> list=session.createQuery("SELECT det, con, tipo " + 
            "FROM TRepCnfgAvncInvCab cab, TRepCnfgAvncInvDet det, Concesion con, InfraestructuraTipo tipo " + 
            "WHERE cab.caiEstado=1 AND det.caiId=cab.caiId AND det.csiId=con.csiId AND det.tinId=con.tinId " + 
            "AND con.tinId=tipo.tinId").list();
            session.getTransaction().commit();
            return list;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    public List<Object> obtenerReporteInversionSinDetalle() throws HibernateException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        try {
            List<Object> list=session.createQuery("SELECT con, tipo " +
            "FROM Concesion con, InfraestructuraTipo tipo " +
            "WHERE con.tinId=tipo.tinId").list();
            session.getTransaction().commit();
            return list;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    @Override
    public void actualizaConfigReporteInversion(List<TRepCnfgAvncInvDet> reporteInversionPersistente, TRepCnfgAvncInvCab cabReporteInversionActivoPersistente) throws HibernateException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        try {
            session.update(cabReporteInversionActivoPersistente);
            for(TRepCnfgAvncInvDet aux : reporteInversionPersistente) {
                session.update(aux);
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
    
    @Override
    public void insertaConfigReporteInversion(List<TRepCnfgAvncInvDet> reporteInversionPersistente, TRepCnfgAvncInvCab cabReporteInversionActivoPersistente) throws HibernateException, IllegalStateException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        try {
            session.persist(cabReporteInversionActivoPersistente);
            List<TRepCnfgAvncInvCab> list=(List<TRepCnfgAvncInvCab>)session.createQuery("FROM TRepCnfgAvncInvCab a WHERE a.caiEstado=1").list();
            if(list==null || list.size()==0) {
                session.getTransaction().rollback();
                throw new IllegalStateException("No se obtuvo algún REPORTE DE AVANCE DE INVERSIÓN ACTIVO. Verificar en la tabla \"t_rep_cnfg_avnc_inv_cab\"");
            } else {
                if(list.size()>1) {
                    session.getTransaction().rollback();
                    throw new IllegalStateException("Se obtuvo más de un REPORTE DE AVANCE DE INVERSIÓN ACTIVO. Verificar en la tabla \"t_rep_cnfg_avnc_inv_cab\"");
                } else {
                    BigDecimal cabID=list.get(0).getCaiId();
                    for(TRepCnfgAvncInvDet aux : reporteInversionPersistente) {
                        aux.setCaiId(cabID);
                        session.persist(aux);
                    }
                    session.getTransaction().commit();
                }
            }
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

}

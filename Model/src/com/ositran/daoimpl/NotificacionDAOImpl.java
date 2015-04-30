package com.ositran.daoimpl;

import com.ositran.dao.NotificacionDAO;
import com.ositran.model.Inv;
import com.ositran.model.InvAvn;
import com.ositran.model.InvReajuste;
import com.ositran.model.InvReconocimiento;
import com.ositran.model.ValorizacionNotificacion;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class NotificacionDAOImpl implements NotificacionDAO {
    
    List<InvAvn> list = null; 
    public NotificacionDAOImpl() {
        super();
    }

    @Override
    public List<InvAvn> ListarDeclaraciones() throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        list=session.createQuery("FROM InvAvn i WHERE i.iaeId > 3").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    
    @Override
    public String NotificarInversion(InvAvn invAvn, ValorizacionNotificacion valorizacionNotificacion) throws SQLException{
    String result=null;
    Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
    try {
        session.beginTransaction();
        session.update(invAvn);
        session.getTransaction().commit();
        
        session.beginTransaction();
        session.persist(valorizacionNotificacion);
        session.getTransaction().commit();
                
    } catch (Exception e) {
        session.getTransaction().rollback();
        result=e.getMessage();
        System.out.println(result);
    }
    session.close();
    return result;
    }
    
    public List<InvAvn> obtenerDeclaracionesxIdContrato(int idcontrato) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query=session.createQuery("FROM InvAvn i WHERE i.iaeId = 4  and i.conId=:idcontrato order by i.tiaNumero asc");
        query.setParameter("idcontrato", idcontrato);
        List lista=query.list();
        session.close();
        return (List<InvAvn>)lista;
    }
    
    @Override
    public List<InvAvn> ListarDeclaracionesSupervContratoCompromiso(int contratoCompromisoId) throws SQLException{            
        System.out.println("contratoCompromisoId: " + contratoCompromisoId);
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        query =session.createQuery("FROM InvAvn i WHERE i.iaeId = 3 AND ccoId = :contratoCompromisoId");
        query.setParameter("contratoCompromisoId",contratoCompromisoId);
        System.out.println("tanaño de la listra:" + query.list().size());
        return query.list();
    }
    public void updateRectificacion(InvAvn invAvn,List<InvReconocimiento> reconocimiento,List<InvReajuste> reajuste,Inv inv)throws Exception{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(invAvn);
            for (InvReconocimiento rec : reconocimiento){
                session.update(rec);  
            }
            System.out.println("*******************dao reajuste"+reajuste.size());
            for (InvReajuste rea : reajuste){
                session.update(rea);
                
            }
            updateINV(inv,session);            
            session.getTransaction().commit();
                    
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            System.out.println(result);
            e.printStackTrace();
        }finally{
            session.close();  
        }

        
    }
    public void updateINV(Inv inv,Session session){
        String result="";
              Query query =
                session.createQuery("update  Inv  set \n" +
                                    "        invEstado=:invEstado,\n" +
                                    "        invEstadoReconocimiento=:invEstadoReconocimiento,\n" +
                                    "        invFechaEmisionDocFomalizacion=:invFechaEmisionDocFomalizacion,\n" +
                                    "        invFechaEmisionInforme=:invFechaEmisionInforme,\n" +
                                    "        invFechaEmisionOficio=:invFechaEmisionOficio,\n" +
                                    "        invMontoTipoCambio=:invMontoTipoCambio,\n" +
                                    "        invMontoTotalAprobado=:invMontoTotalAprobado,\n" +
                                    "        invMontoTotalReajuste=:invMontoTotalReajuste,\n" +
                                    "        invNota=:invNota,\n" +
                                    "        invNroDocFormalizacion=:invNroDocFormalizacion,\n" +
                                    "        invNumeroInforme=:invNumeroInforme,\n" +
                                    "        invNumeroOficio=:invNumeroOficio,\n" +
                                    "        invObservaciones=:invObservaciones,\n" +
                                    "        invRegSalidaInforme=:invRegSalidaInforme,\n" +
                                    "        invRegSalidaOficio=:invRegSalidaOficio,\n" +
                                    "        monId=:monId \n" +
                                    "        where invId=:invId" +
                                    "        and   tiaNumero=:tiaNumero");
            query.setParameter("invEstado", inv.getInvEstado());
            query.setParameter("invEstadoReconocimiento", inv.getInvEstadoReconocimiento());
            query.setParameter("invFechaEmisionDocFomalizacion", inv.getInvFechaEmisionDocFomalizacion());
            query.setParameter("invFechaEmisionInforme", inv.getInvFechaEmisionInforme());
            query.setParameter("invFechaEmisionOficio", inv.getInvFechaEmisionOficio());
            query.setParameter("invMontoTipoCambio", inv.getInvMontoTipoCambio());
            query.setParameter("invMontoTotalAprobado", inv.getInvMontoTotalAprobado());
            query.setParameter("invMontoTotalReajuste", inv.getInvMontoTotalReajuste());
            query.setParameter("invNota", inv.getInvNota());
            query.setParameter("invNroDocFormalizacion", inv.getInvNroDocFormalizacion());
            query.setParameter("invNumeroInforme", inv.getInvNumeroInforme());
            query.setParameter("invNumeroOficio", inv.getInvNumeroOficio());
            query.setParameter("invObservaciones", inv.getInvObservaciones());
            query.setParameter("invRegSalidaInforme", inv.getInvRegSalidaInforme());
            query.setParameter("invRegSalidaOficio", inv.getInvRegSalidaOficio());
            query.setParameter("monId", inv.getMonId());
            query.setParameter("invId", inv.getInvId());
            query.setParameter("tiaNumero", inv.getTiaNumero());
            query.executeUpdate();

       
        
    }
}

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
        List list=session.createQuery("FROM InvAvn i WHERE i.iaeId = 4 order by i.tiaNumero asc").list();
        session.close();
        return (List<InvAvn>)list;
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
    public void updateRectificacion(InvAvn invAvn,List<InvReconocimiento> reconocimiento,List<InvReajuste> reajuste,Inv inv)throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(invAvn);
            for (InvReconocimiento rec : reconocimiento){
                session.update(rec);  
            }
            for (InvReajuste rea : reajuste){
                session.update(rea);
            }
            session.update(inv);            
            session.getTransaction().commit();
                    
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            System.out.println(result);
            e.printStackTrace();
        }
        session.close();
        
    }
}

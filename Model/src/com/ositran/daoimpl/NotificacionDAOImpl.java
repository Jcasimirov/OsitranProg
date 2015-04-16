package com.ositran.daoimpl;

import java.util.List;
import org.hibernate.Session;
import java.sql.SQLException;
import com.ositran.util.HibernateUtil;;
import com.ositran.dao.NotificacionDAO;
import com.ositran.model.InvAvn;
import com.ositran.model.ValorizacionNotificacion;


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
    

}

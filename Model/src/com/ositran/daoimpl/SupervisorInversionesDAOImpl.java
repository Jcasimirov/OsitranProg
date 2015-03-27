
package com.ositran.daoimpl;
import com.ositran.dao.SupervisorInversionesDAO;
import com.ositran.model.SupervisorInversiones;
import com.ositran.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class SupervisorInversionesDAOImpl implements SupervisorInversionesDAO{

    @Override
    public List<SupervisorInversiones> buscarCoordinador(int codtipoInfraestructura) throws SQLException {
        List<SupervisorInversiones> list =null;
        try{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query;  
        query = session.createQuery("From SupervisorInversiones c WHERE c.tinId = :busqueda");   
        query.setParameter("busqueda",codtipoInfraestructura);
        list = query.list();
        session.getTransaction().commit();
        session.close();
            
        }catch (Exception e) {
            e.printStackTrace();
               
        }
        return list;   
    }
}
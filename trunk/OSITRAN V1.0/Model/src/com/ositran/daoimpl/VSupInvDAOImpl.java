package com.ositran.daoimpl;

import com.ositran.dao.VSupInvDAO;
import com.ositran.model.VSupInv;

import com.ositran.model.VEmpSup;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class VSupInvDAOImpl implements VSupInvDAO{
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
  
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
    
    @Override
    public List<VSupInv> buscarCoordinador(int codtipoInfraestructura) throws SQLException {
        
        List<VSupInv> list =null;
        try{
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query;  
        
            query = session.createQuery("From VCoordInSitu c  WHERE c.tsiEstado <> 0  and c.tinId = :busqueda");
                  
        query.setParameter("busqueda",codtipoInfraestructura);
        list = query.list();
        session.getTransaction().commit();
        session.close();
        
        }catch (Exception e) {
                 System.out.println("erro en el dao"); 
        }
        return list;   
    }
}

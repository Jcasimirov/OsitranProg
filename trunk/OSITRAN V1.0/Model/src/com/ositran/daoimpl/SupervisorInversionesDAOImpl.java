
package com.ositran.daoimpl;

import com.ositran.dao.SupervisorInversionesDAO;
import com.ositran.model.InversionTipo;
import com.ositran.model.SupervisorInversiones;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class SupervisorInversionesDAOImpl implements SupervisorInversionesDAO{
    SupervisorInversiones supervisorInversiones=new SupervisorInversiones();
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
            System.out.println("**********************");
            System.out.println(codtipoInfraestructura);
            System.out.println(list);
        session.getTransaction().commit();
        session.close();
            
        }catch (Exception e) {
            e.printStackTrace();
               
        }
        return list;   
    }

    @Override
    public SupervisorInversiones getSupervisorInversiones(int codtipoInfraestructura) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        SupervisorInversiones contratoAdenda=(SupervisorInversiones)session.get(SupervisorInversiones.class, codtipoInfraestructura);
        return contratoAdenda;
    }
    @Override
    public SupervisorInversiones buscarSupervisor(int tsiId) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query;  
        query = session.createQuery("From SupervisorInversiones c WHERE c.tsiId = :tsiId");   
        query.setParameter("tsiId",tsiId);
        SupervisorInversiones  sup =(SupervisorInversiones) query.uniqueResult();

        session.close();
      
        return sup;   
    }

    @Override
    public SupervisorInversiones get(Integer id) throws SQLException, Exception {
        System.out.println("SUPERVISORRRRRRRRRRRRRRRR");
        System.out.println(id);
        
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        supervisorInversiones= (SupervisorInversiones) session.get(SupervisorInversiones.class, id);
        return supervisorInversiones;
    }


    public void setSupervisorInversiones(SupervisorInversiones supervisorInversiones) {
        this.supervisorInversiones = supervisorInversiones;
    }

    public SupervisorInversiones getSupervisorInversiones() {
        return supervisorInversiones;
    }
}

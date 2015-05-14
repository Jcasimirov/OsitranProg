package com.ositran.daoimpl;

import com.ositran.dao.ConcesionDAO;
import com.ositran.model.Concesion;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class ConcesionDAOImpl implements ConcesionDAO {
   
   
    @Override
    public List<Concesion> query() throws SQLException{
        System.out.println("DAO");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list = session.createQuery("From Concesion o where o.csiEstado <> 0 and o.csiId <> 0 order by CSI_ID DESC ").list();
        session.getTransaction().commit();

        
        return list;
    }

    @Override
    public String insert(Concesion concesion) throws SQLException{
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(concesion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public int idConcesion(Concesion concesion) throws SQLException{
        int result = 0;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(concesion);
            result=concesion.getCsiId();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            
        }
        return result;
    }
    @Override
    public String delete(Integer id) throws SQLException{
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            Concesion concesion = (Concesion) session.get(Concesion.class, id);
            session.delete(concesion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Concesion concesion) throws SQLException{    
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(concesion);
            session.getTransaction().commit();
           
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }


    @Override
    public String update2(Concesion concesion) throws SQLException{
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(concesion);
            session.getTransaction().commit();
           
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }





    @Override
    public Concesion get(Integer id) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Concesion concesion = (Concesion) session.get(Concesion.class, id);
        session.close();
        return concesion;
    }
    //charles
    public List<Concesion> queryfiltro(int codigo, String nombre) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query;  
        if(codigo < 1 ){
            query = session.createQuery("FROM Concesion c WHERE c.csiEstado <> 0 and lower(c.csiNombre) like lower(:busqueda2)");
        }else{
            query = session.createQuery("FROM Concesion c WHERE c.csiEstado <> 0 and c.tinId like :busqueda1 and lower(c.csiNombre) like lower(:busqueda2)");
          
            query.setInteger("busqueda1",codigo);
        }        
        query.setString("busqueda2","%"+nombre+"%");
        List<Concesion> list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    // Iosusky
        public List<Concesion> filtrarConcesion(int tipoInfraestructura) throws SQLException{
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
          
            Query query=null;  
            query = session.createQuery("FROM Concesion c WHERE c.csiEstado <> 0 and c.tinId <> 0 and c.tinId = :busqueda ");
            query.setParameter("busqueda",tipoInfraestructura);
            List<Concesion>   list = query.list();
            session.close();
            return list;
        }

    public List<Concesion> listarConcesiones() throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List<Concesion> list = session.createQuery("select o from Concesion o where o.csiEstado <> 0 order by o.csiId").list();
        session.close();
        return list;
    }    
    public List<Concesion> listarConcesionesxIdConcesion(int idConcesion) throws Exception{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query=null;  
        query =session.createQuery("From Concesion o where o.csiEstado <> 0 and o.csiId=:idConcesion order by o.csiId");
        query.setParameter("idConcesion",idConcesion);
        List lista=query.list();
        
        session.close();
        return (List<Concesion>)lista;
    }
   
}

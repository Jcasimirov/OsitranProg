package com.ositran.daoimpl;

import com.ositran.dao.RolDAO;
import com.ositran.model.InversionTipo;
import com.ositran.model.Rol;
import com.ositran.util.HibernateUtil;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class RolDAOImpl implements  RolDAO{

    Rol rol;
    
    @Override
    @SuppressWarnings("unchecked")
    
   
    
    public List<Rol> query() {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(Rol.class).add(Restrictions.eq("rolEstado",1)).list(); 
        
    }
    
      @Override
    public List<Rol> query1(String filtro) {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(Rol.class).add(Restrictions.eq("rolEstado",1)).add(Restrictions.like("menNombre","%" + filtro + "%")).list(); 
    }
    
    @Override
    public int getCodigo(Rol rol) {
        
               int result = 0;
               Session session =HibernateUtil.getSessionAnnotationFactory().openSession();
               try {
                   session.beginTransaction();
                   session.save(rol);
                   result=rol.getRolId();
                   session.getTransaction().commit();
               } catch (Exception e) {
                   session.getTransaction().rollback();
                   
               }
               return result;
    }
    
  
    
    
    @Override
    public String insert(Rol rol) {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(rol);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.getTransaction().begin();
        Query query;
        query=session.createQuery("update Rol E set E.rolEstado = 0  WHERE  E.rolId= :codigo");
        query.setParameter("codigo",id );
        query.executeUpdate();
        session.getTransaction().commit();
        return null;
    }

    @Override
    public String update(Rol rol) {

        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(rol);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public Rol get(Integer id) {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        rol = (Rol) session.get(Rol.class, id);
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }


  
}

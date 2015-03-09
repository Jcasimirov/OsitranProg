package com.ositran.daoimpl;

import com.ositran.dao.RolDAO;
import com.ositran.model.Rol;
import com.ositran.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class RolDAOImpl implements  RolDAO{

    Rol rol;
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Rol> query() {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(Rol.class).list();
       
       
    }

    @Override
    public String insert(Rol rol) {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(Rol rol) {
        // TODO Implement this method
        return null;
    }

    @Override
    public Rol get(Integer id) {
        // TODO Implement this method
        return null;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }
}

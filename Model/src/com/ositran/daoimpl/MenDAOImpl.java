package com.ositran.daoimpl;

import com.ositran.dao.MenDAO;
import com.ositran.model.Men;
import com.ositran.util.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MenDAOImpl implements MenDAO{

    Men men;
    public MenDAOImpl() {
        super();
    }
    
    @Override
    public String getNombre(Integer codigo) {
        System.out.println("***********************Llego Al Services//////////////////////////////7");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query;
        List list;
        query=session.createQuery("FROM Men  E WHERE E.menId= :codigo");
        query.setParameter("codigo",codigo );
        list= query.list();  
        System.out.println("**************************");
        System.out.println(list.size());
        men=(Men)list.get(0);
        System.out.println("**************************");
        String nombre=men.getMenNombre();
        return nombre;
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<Men> query() {
        System.out.println("DAOO");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(Men.class).list();
    }

    @Override
    public String insert(Men men) {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(Men men) {
        // TODO Implement this method
        return null;
    }

    @Override
    public Men get(Integer id) {
        // TODO Implement this method
        return null;
    }

    public void setMen(Men men) {
        this.men = men;
    }

    public Men getMen() {
        return men;
    }

    
}

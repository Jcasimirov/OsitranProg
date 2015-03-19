package com.ositran.daoimpl;

import com.ositran.dao.MenDAO;
import com.ositran.model.InversionTipo;
import com.ositran.model.Men;
import com.ositran.util.HibernateUtil;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class MenDAOImpl implements MenDAO{

    Men men;
    public MenDAOImpl() {
        super();
    }
    
    
    @Override
    public int getPadre(Integer codigo) {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query;
        List list;
        query=session.createQuery("FROM Men  E WHERE E.menId= :codigo");
        query.setParameter("codigo",codigo );
        list= query.list();  
        men=(Men)list.get(0);
        int codigoP =men.getMenPadre();
        return codigoP;
    }
    
    @Override
    public String getNombre(Integer codigo) {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query;
        List list;
        query=session.createQuery("FROM Men  E WHERE E.menId= :codigo");
        query.setParameter("codigo",codigo );
        list= query.list();  
        men=(Men)list.get(0);
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
    public List<Men> query1(String filtro) {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(Men.class).add(Restrictions.like("menNombre","%" + filtro + "%")).list();
    }

    @Override
    public String insert(Men men) {
        return null;
    }

    @Override
    public String delete(Integer id) {
        return null;
    }

    @Override
    public String update(Men men) {
        System.out.println("llego hasta el DAO IMPL");
        System.out.println(men.getMenId());
        System.out.println(men.getMenNombre());
        System.out.println(men.getDescripcion());
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$");
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(men);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Men get(Integer id) {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        men = (Men) session.get(Men.class, id);
        return men;
    }

    public void setMen(Men men) {
        this.men = men;
    }

    public Men getMen() {
        return men;
    }


    
}

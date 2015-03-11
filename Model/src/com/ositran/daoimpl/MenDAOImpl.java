package com.ositran.daoimpl;

import com.ositran.dao.MenDAO;
import com.ositran.model.Men;
import com.ositran.util.HibernateUtil;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MenDAOImpl implements MenDAO{

    Men men;
    public MenDAOImpl() {
        super();
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

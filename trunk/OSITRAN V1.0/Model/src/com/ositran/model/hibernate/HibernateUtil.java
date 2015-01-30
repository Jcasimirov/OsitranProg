package com.ositran.model.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    
    public HibernateUtil() {
        super();
    }
    
    static{
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();

            //sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            //sessionFactory = new Configuration().configure("./hibernate.cfg.xml").buildSessionFactory();
       } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() throws HibernateException{
        return sessionFactory;
    }    
}

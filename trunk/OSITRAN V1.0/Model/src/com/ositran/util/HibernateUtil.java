package com.ositran.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionAnnotationFactory;
    private static int countNC = 0;
    private static int countC = 0;

    private static SessionFactory buildSessionAnnotationFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry =
            new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionAnnotationFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionAnnotationFactory;

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionAnnotationFactory() {
        if (sessionAnnotationFactory == null) {
            System.out.println("Contador C = " + (++countC));
            sessionAnnotationFactory = buildSessionAnnotationFactory();
        } else {
            System.out.println("Contador NC = " + (++countNC));
        }
        return sessionAnnotationFactory;
    }

}

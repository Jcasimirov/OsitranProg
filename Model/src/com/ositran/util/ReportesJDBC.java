package com.ositran.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class ReportesJDBC {
    static String driver;
    static String url;
    static String user;
    static String pass;

    public ReportesJDBC() {
        super();
    }
    
    private static SessionFactory sessionAnnotationFactory;

    public static Connection getConnection(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry =
        new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionAnnotationFactory = configuration.buildSessionFactory(serviceRegistry);
        
        driver=configuration.getProperty(Environment.DRIVER);
        url=configuration.getProperty(Environment.URL);
        user=configuration.getProperty(Environment.USER);
        pass=configuration.getProperty(Environment.PASS);
        Connection con=null;
        try{
            Class.forName(driver);
            System.out.println("________________________________________");
            System.out.println("________________________________________");
            System.out.println("________________________________________");
            System.out.println("CONNECITON");
            System.out.println("driver: "+driver);
            System.out.println("url: "+url);
            System.out.println("user: "+user);
            System.out.println("pass: "+pass);
            System.out.println("________________________________________");
            System.out.println("________________________________________");
            System.out.println("________________________________________");
            con=DriverManager.getConnection(url, user, pass);
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return con;
        }
    }
}
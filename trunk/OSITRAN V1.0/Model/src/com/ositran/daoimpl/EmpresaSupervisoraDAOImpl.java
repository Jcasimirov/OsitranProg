package com.ositran.daoimpl;

import com.ositran.dao.EmpresaSupervisoraDAO;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ositran.dao.InfraestructuraTipoDAO;
import com.ositran.model.EmpresaSupervisora;
import com.ositran.model.Event;
import com.ositran.model.Igv;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.model.hibernate.HibernateUtil;

import java.math.BigDecimal;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class EmpresaSupervisoraDAOImpl implements EmpresaSupervisoraDAO {
    
        private JdbcTemplate jdbcTemplate;
        
        public void setDataSource(DataSource ds){
            this.jdbcTemplate=new JdbcTemplate(ds);
        }
	
	private static final Logger logger = LoggerFactory.getLogger(EmpresaSupervisoraDAOImpl.class);
        
        
        private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        List<EmpresaSupervisora> list = null;
        

        
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
        
    public EmpresaSupervisoraDAOImpl() {
        super();
    }
    
    @Override
    public List<EmpresaSupervisora> query() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        list= session.createQuery("select o from EmpresaSupervisora o").list();            
        System.out.println("LISTA = "+list);
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    @Override
    public List<EmpresaSupervisora> FiltrarEmpSup(String atributo) {
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM EmpresaSupervisora  E WHERE lower(E.supNombre) like  lower(:busqueda)");
        query.setParameter("busqueda","%"+atributo+"%");
        list= query.list();
        session.getTransaction().commit();
        session.close();
        return list;
        
    }

        @Override
        public String insert(EmpresaSupervisora empresaSupervisora) {
            String result=null;
            Session session = sessionFactory.openSession();
            try {
                session.beginTransaction();
                session.persist(empresaSupervisora);
                session.getTransaction().commit();
                
           } catch (Exception e) {
                session.getTransaction().rollback();
                result=e.getMessage();
            }
            session.close();
            return result;
        }
        
        @Override
        public String delete(Integer id) {
            String result=null;
            //Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Session session = sessionFactory.openSession();
            try {
                session.beginTransaction();
                EmpresaSupervisora empresaSupervisora=(EmpresaSupervisora)session.get(EmpresaSupervisora.class, id);
                session.delete(empresaSupervisora);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                result=e.getMessage();
            }
            session.close();
            return result;
        }
        
    @Override
    public String update(EmpresaSupervisora empresaSupervisora) {
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(empresaSupervisora);
            session.getTransaction().commit();
            logger.info("EmpresaSupervisora updated successfully, EmpresaSupervisora Details="+empresaSupervisora);
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            System.out.println(result);
        }
        session.close();
        return result;
    }
        
        @Override
        public EmpresaSupervisora get(Integer id) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            EmpresaSupervisora empresaSupervisora=(EmpresaSupervisora)session.get(EmpresaSupervisora.class, id);
            session.getTransaction().commit();
            session.close();
            return empresaSupervisora;
        }

}

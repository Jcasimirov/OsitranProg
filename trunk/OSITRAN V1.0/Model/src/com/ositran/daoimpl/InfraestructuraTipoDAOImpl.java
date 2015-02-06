package com.ositran.daoimpl;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ositran.dao.InfraestructuraTipoDAO;
import com.ositran.model.Event;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.model.hibernate.HibernateUtil;

import java.math.BigDecimal;

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
public class InfraestructuraTipoDAOImpl implements InfraestructuraTipoDAO {
    
        private JdbcTemplate jdbcTemplate;
        
        public void setDataSource(DataSource ds){
            this.jdbcTemplate=new JdbcTemplate(ds);
        }
	
	private static final Logger logger = LoggerFactory.getLogger(InfraestructuraTipoDAOImpl.class);

        private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

        @Override
        public String insert(InfraestructuraTipo InfraestructuraTipo) {
            String result=null;
            Session session = sessionFactory.openSession();
            try {
                session.beginTransaction();
                session.persist(InfraestructuraTipo);
                session.getTransaction().commit();
           } catch (Exception e) {
                session.getTransaction().rollback();
                result=e.getMessage();
            }
            return result;
        }
        
        @Override
        public String delete(Integer id) {
            String result=null;
            //Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Session session = sessionFactory.openSession();
            try {
                session.beginTransaction();
                InfraestructuraTipo InfraestructuraTipo=(InfraestructuraTipo)session.get(InfraestructuraTipo.class, id);
                session.delete(InfraestructuraTipo);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                result=e.getMessage();
            }
            return result;
        }
        
        @Override
        public String update(InfraestructuraTipo InfraestructuraTipo) {
            String result=null;
            Session session = sessionFactory.openSession();
            try {
                session.beginTransaction();
                session.update(InfraestructuraTipo);
                session.getTransaction().commit();
                logger.info("InfraestructuraTipo updated successfully, InfraestructuraTipo Details="+InfraestructuraTipo);
            } catch (Exception e) {
                session.getTransaction().rollback();
                result=e.getMessage();
            }
            return result;
        }
        
        @Override
        public InfraestructuraTipo get(Integer id) {
            //Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            InfraestructuraTipo InfraestructuraTipo=(InfraestructuraTipo)session.get(InfraestructuraTipo.class, id);
            session.getTransaction().commit();
            return InfraestructuraTipo;
        }

        @Override
        public List query() {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List list=session.createQuery("select o from InfraestructuraTipo o").list();
            System.out.println("LISTA = "+list);
            session.getTransaction().commit();
            return list;
        }
        
        public static void main(String[] args) {
            InfraestructuraTipoDAOImpl daoImpl=new InfraestructuraTipoDAOImpl();
            //daoImpl.query();
            /*
             * Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); // NPE
            session = sessionFactory.openSession();
            System.out.println("Inserting Record");
            Event contact = new Event();
            contact.setTitle("Deepak3");
            session.save(contact);
            System.out.println("Done");
            Transaction tx = session.beginTransaction();
            session.flush();
            session.getTransaction().commit();
            tx.commit();
            session.close();
            */
            Resource resource = new FileSystemResource("src/spring-hibernate.xml");
            BeanFactory factory = new XmlBeanFactory(resource);
            System.out.println(factory);
            /*InfraestructuraTipoDAOImpl servicio=(InfraestructuraTipoDAOImpl)factory.getBean("InfraestructuraTipoDAO");
            
            InfraestructuraTipo u=new InfraestructuraTipo();
            u.setId(2);
            u.setNombre("nombre");
            u.setCountry("country");
            servicio.insert(u);
            /*
            servicio.insertarEvent(event2);
            servicio.insertarEvent(event3);
            servicio.insertarEvent(event4);
            servicio.insertarEvent(event5);
            */
            //Event e4=servicio.obtenerEvent(event4.getId());
            //System.out.println(e4.getId()+" "+e4.getTitle());
            
        ;
        }
}

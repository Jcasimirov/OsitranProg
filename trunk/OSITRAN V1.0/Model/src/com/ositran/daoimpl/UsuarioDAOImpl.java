package com.ositran.daoimpl;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ositran.dao.UsuarioDAO;
import com.ositran.model.Event;
import com.ositran.model.Usuario;
import com.ositran.model.hibernate.HibernateUtil;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
    
        private JdbcTemplate jdbcTemplate;
        
        public void setDataSource(DataSource ds){
            this.jdbcTemplate=new JdbcTemplate(ds);
        }
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);

	//private SessionFactory sessionFactory;
        private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}


	@Override
	public void addUsuario(Usuario u) {
	    sessionFactory.getCurrentSession().save(u);
            
            /*EntityManagerFactory emf=Persistence.createEntityManagerFactory("USUARIO");
            EntityManager em=emf.createEntityManager();
            EntityTransaction tx=em.getTransaction();
            tx.begin();
            em.persist(u);
            tx.commit();
            em.close();
            emf.close();*/
		/*Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
	    Transaction tx = session.beginTransaction();
	    session.flush();
	    session.getTransaction().commit();
	    tx.commit();
		logger.info("Person saved successfully, Person Details="+p);*/
	}

	@Override
	public void updateUsuario(Usuario p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}

	//@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listUsuarios() {
        return sessionFactory.getCurrentSession().createQuery("from Usuario").list();
        /*System.out.println("lista de usuarios DAO impl");
		Session session = this.sessionFactory.getCurrentSession();
		List<Usuario> personsList = session.createQuery("from Usuario").list();
		for(Usuario p : personsList){
			logger.info("Person List::"+p);
		}
		return personsList;
            */
	}

	@Override
	public Usuario getUsuarioById(BigDecimal id) {
		Session session = this.sessionFactory.getCurrentSession();	
	    Usuario p = (Usuario) session.load(Usuario.class, id);
		//Usuario p = (Usuario) session.load(Usuario.class, new java.math.BigDecimal(id));
		logger.info("Person loaded successfully, Person details="+p);
		return p;
	}

	@Override
	public void removeUsuario(BigDecimal id) {
		Session session = this.sessionFactory.getCurrentSession();
		Usuario p = (Usuario) session.load(Usuario.class, id);
                //Usuario p = (Usuario) session.load(Usuario.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Person deleted successfully, person details="+p);
	}


        @Override
        public String insert(Usuario usuario) {
            String result=null;
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            try {
                session.beginTransaction();
                session.persist(usuario);
                session.getTransaction().commit();
           } catch (Exception e) {
                session.getTransaction().rollback();
                result=e.getMessage();
            }
            return result;
        }
        
        @Override
        public String delete(BigDecimal id) {
            String result=null;
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            try {
                session.beginTransaction();
                Usuario usuario=(Usuario)session.get(Usuario.class, id);
                session.delete(usuario);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                result=e.getMessage();
            }
            return result;
        }
        
        @Override
        public String update(Usuario usuario) {
            String result=null;
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            try {
                session.beginTransaction();
                session.update(usuario);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                result=e.getMessage();
            }
            return result;
        }
        
        @Override
        public Usuario get(BigDecimal id) {
            Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Usuario usuario=(Usuario)session.get(Usuario.class, id);
            session.getTransaction().commit();
            return usuario;
        }

        @Override
        public List query() {
            System.out.println("- - - - ------------------------------------------------------");
            ///Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            System.out.println("----------------------------------------------------------");
            List list=session.createQuery("select o from Usuario o").list();
            System.out.println("LISTA = "+list);
            System.out.println("----------------------------------------------------------");
            session.getTransaction().commit();
            return list;
        }
        
        public static void main(String[] args) {
            UsuarioDAOImpl daoImpl=new UsuarioDAOImpl();
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
            /*UsuarioDAOImpl servicio=(UsuarioDAOImpl)factory.getBean("usuarioDAO");
            
            Usuario u=new Usuario();
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

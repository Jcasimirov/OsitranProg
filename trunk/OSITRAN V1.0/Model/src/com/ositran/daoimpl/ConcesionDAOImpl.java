package com.ositran.daoimpl;

import com.ositran.dao.ConcesionDAO;
import com.ositran.model.Concesion;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;

public class ConcesionDAOImpl implements ConcesionDAO {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    private static final Logger logger = LoggerFactory.getLogger(InfraestructuraTipoDAOImpl.class);
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    public ConcesionDAOImpl() {
        super();
    }

    @Override
    public List<Concesion> query() {
        System.out.println("DAO");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery("select o from Concesion o order by CSI_ID DESC").list();
        session.getTransaction().commit();
         /* Concesion con=new Concesion();
        con=(Concesion)list.get(0);
        System.out.println("Antes");
        System.out.println(con.getInfraestructuraTipo().getTinNombre());
        System.out.println("despues"); */
        
        return list;
    }

    @Override
    public String insert(Concesion concesion) throws SQLException{
        String result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(concesion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public int idConcesion(Concesion concesion) {
        System.out.println("llego al ID concesion");
        int result = 0;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(concesion);
            result=concesion.getCsiId();
            System.out.println(result);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            
        }
        return result;
    }
    @Override
    public String delete(Integer id) {
        String result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Concesion concesion = (Concesion) session.get(Concesion.class, id);
            session.delete(concesion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Concesion concesion) {
        String result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(concesion);
            session.getTransaction().commit();
            logger.info("InfraestructuraTipo updated successfully, InfraestructuraTipo Details=" + concesion);
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public Concesion get(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Concesion concesion = (Concesion) session.get(Concesion.class, id);
        session.getTransaction().commit();
        return concesion;
    }
    
    public List<Concesion> queryfiltro(int codigo, String nombre){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query;  
        if(codigo < 1 ){
            query = session.createQuery("FROM Concesion c WHERE lower(c.csiNombre) like lower(:busqueda2)");
        }else{
            query = session.createQuery("FROM Concesion c WHERE c.infraestructuraTipo.tinId like :busqueda1 and lower(c.csiNombre) like lower(:busqueda2)");
            query.setParameter("busqueda1",codigo);
        }        
        query.setParameter("busqueda2","%"+nombre+"%");
        List<Concesion> list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    

   
}

package com.ositran.daoimpl;

import com.ositran.dao.ConcesionarioDAO;
import com.ositran.model.Concesionario;

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

public class ConcesionarioDAOImpl implements ConcesionarioDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    private static final Logger logger = LoggerFactory.getLogger(InfraestructuraTipoDAOImpl.class);
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public ConcesionarioDAOImpl() {
        super();
    }
    
    @Override
    public int getCanNombres(String nombre) throws SQLException, Exception {
        int cantidad=0;
        Session session = sessionFactory.openSession();
        Query query;
        List list;
        query=session.createQuery("FROM Concesionario  E WHERE  E.cncNombre like :nombre");
        query.setParameter("nombre",nombre );
        list= query.list();   
        cantidad=list.size();
        return cantidad;
    }
    
    @Override
    public List<Concesionario> query()  throws SQLException ,Exception{
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery("select o from Concesionario o").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List<Concesionario> queryF(String filtro)  throws SQLException ,Exception{
        Session session = sessionFactory.openSession();
        Query query;
        session.beginTransaction();
        query =
            session.createQuery("FROM Concesionario  E WHERE  E.cncDescripcion like :filtro1 or E.cncRepresentanteLegal like :filtro1");
        query.setParameter("filtro1", "%" + filtro + "%");
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(Concesionario concesionario)  throws SQLException ,Exception{
        String result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(concesionario);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id)  throws SQLException ,Exception{
        String result = null;
        //Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Concesionario concesionario = (Concesionario) session.get(Concesionario.class, id);
            session.delete(concesionario);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Concesionario concesionario)  throws SQLException ,Exception{
        String result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(concesionario);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public Concesionario get(Integer id)  throws SQLException ,Exception{
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Concesionario concesionario = (Concesionario) session.get(Concesionario.class, id);
        session.getTransaction().commit();
        return concesionario;
    }


   
}

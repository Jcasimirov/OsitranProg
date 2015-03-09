package com.ositran.daoimpl;
import com.ositran.dao.IgvDAO;
import com.ositran.model.Igv;
import com.ositran.model.InfraestructuraTipo;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;
import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;

public class IgvDAOImpl implements IgvDAO {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource ds){
        this.jdbcTemplate=new JdbcTemplate(ds);
    }
    
    private static final Logger logger = LoggerFactory.getLogger(IgvDAOImpl.class);

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }
    
    
    public IgvDAOImpl() {
        super();
    }

    @Override
    public List<Igv> query() throws SQLException{
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list=session.createQuery("select o from Igv o where o.igvEstado <> 0").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(Igv igv) throws SQLException{
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(igv);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException{
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Igv igv=(Igv)session.get(Igv.class, id);
            session.delete(igv);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Igv igv) throws SQLException{
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(igv);
            session.getTransaction().commit();
            logger.info("Se actualizó satisfactoriamente el IGV"+igv);
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }
    

    @Override
    public Igv get(Integer id) throws SQLException{
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Igv igv=(Igv)session.get(Igv.class, id);
        session.getTransaction().commit();
        return igv;
    }
    
    
    
    
    
}

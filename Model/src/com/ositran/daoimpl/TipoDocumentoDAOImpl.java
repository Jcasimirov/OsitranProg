package com.ositran.daoimpl;


import com.ositran.dao.TipoDocumentoDAO;




import com.ositran.model.TipoDocumento;

import java.sql.SQLException;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;

public class TipoDocumentoDAOImpl implements TipoDocumentoDAO {
    
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource ds){
        this.jdbcTemplate=new JdbcTemplate(ds);
    }
    
    private static final Logger logger = LoggerFactory.getLogger(TipoDocumentoDAOImpl.class);

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    public void setSessionFactory(SessionFactory sf){
            this.sessionFactory = sf;
    }
    
    
    public TipoDocumentoDAOImpl() {
        super();
    }

    @Override
    public List<TipoDocumento> query() throws SQLException{
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list=session.createQuery("select o from TipoDocumento o").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(TipoDocumento tipodocumento) throws SQLException{
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(tipodocumento);
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
            TipoDocumento tipodocumento=(TipoDocumento)session.get(TipoDocumento.class, id);
            session.delete(tipodocumento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(TipoDocumento tipodocumento) throws SQLException{
        String result=null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(tipodocumento);
            session.getTransaction().commit();
            logger.info("TipoDocumento updated successfully, TipoDocumento Details="+tipodocumento);
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public TipoDocumento get(Integer id) throws SQLException{
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        TipoDocumento tipodocumento=(TipoDocumento)session.get(TipoDocumento.class, id);
        session.getTransaction().commit();
        return tipodocumento;
    }
    
    
    
    
    
}

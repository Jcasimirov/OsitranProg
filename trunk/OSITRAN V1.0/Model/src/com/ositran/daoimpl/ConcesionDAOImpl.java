package com.ositran.daoimpl;

import com.ositran.dao.ConcesionDAO;
import com.ositran.model.Concesion;

import com.ositran.model.Infraestructura;

import com.ositran.util.HibernateUtil;

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
    public List<Concesion> query() throws SQLException{
        System.out.println("DAO");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery("select o from Concesion o where o.csiEstado <> 0 order by CSI_ID DESC ").list();
        session.getTransaction().commit();

        
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
    public int idConcesion(Concesion concesion) throws SQLException{
        int result = 0;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(concesion);
            result=concesion.getCsiId();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            
        }
        return result;
    }
    @Override
    public String delete(Integer id) throws SQLException{
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
    public String update(Concesion concesion) throws SQLException{    
        String result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(concesion);
            session.getTransaction().commit();
           
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }


    @Override
    public String update2(Concesion concesion) throws SQLException{
        String result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(concesion);
            session.getTransaction().commit();
           
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }





    @Override
    public Concesion get(Integer id) throws SQLException{
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Concesion concesion = (Concesion) session.get(Concesion.class, id);
        session.getTransaction().commit();
        return concesion;
    }
    //charles
    public List<Concesion> queryfiltro(int codigo, String nombre) throws SQLException{
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query;  
        if(codigo < 1 ){
            query = session.createQuery("FROM Concesion c WHERE c.csiEstado <> 0 and lower(c.csiNombre) like lower(:busqueda2)");
        }else{
            query = session.createQuery("FROM Concesion c WHERE c.csiEstado <> 0 and c.tinId like :busqueda1 and lower(c.csiNombre) like lower(:busqueda2)");
          
            query.setInteger("busqueda1",codigo);
        }        
        query.setString("busqueda2","%"+nombre+"%");
        List<Concesion> list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    // Iosusky
        public List<Concesion> filtrarConcesion(int tipoInfraestructura) throws SQLException{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query;  
            if(tipoInfraestructura > 0 ){
                query = session.createQuery("FROM Concesion c WHERE c.csiEstado <> 0 and c.tinId = :busqueda");
                query.setParameter("busqueda",tipoInfraestructura);
            }else {
                query = session.createQuery("FROM Concesion c WHERE c.csiEstado <> 0 ");
            }        
            List<Concesion> list = query.list();
            session.getTransaction().commit();
            session.close();
            return list;
        }

    public List<Concesion> listarConcesiones() throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List<Concesion> list = session.createQuery("select o from Concesion o where o.csiEstado <> 0 order by CSI_ID DESC").list();
        return list;
    }    

   
}

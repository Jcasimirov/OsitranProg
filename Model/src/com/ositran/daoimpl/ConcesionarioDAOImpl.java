package com.ositran.daoimpl;

import com.ositran.dao.ConcesionarioDAO;
import com.ositran.model.Concesionario;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ConcesionarioDAOImpl implements ConcesionarioDAO {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Concesionario concesionario;
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
        query = session.createQuery("FROM Concesionario  E WHERE   upper(E.cncNombre) like :filtro1");
        query.setParameter("filtro1", "%" + filtro + "%");
        /*query = session.createQuery("FROM Concesionario  E WHERE  E.cncDescripcion like :filtro1 or E.cncRepresentanteLegal like :filtro1");
        query.setParameter("filtro1", "%" + filtro + "%");*/
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
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            concesionario = (Concesionario) session.get(Concesionario.class, id);
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
        concesionario = (Concesionario) session.get(Concesionario.class, id);
        session.getTransaction().commit();
        return concesionario;
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

}

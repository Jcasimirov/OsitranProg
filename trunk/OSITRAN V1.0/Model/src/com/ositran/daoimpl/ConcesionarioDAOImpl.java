package com.ositran.daoimpl;

import com.ositran.dao.ConcesionarioDAO;
import com.ositran.model.Concesionario;
import com.ositran.model.InversionTipo;
import com.ositran.model.Men;
import com.ositran.util.Entity;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;


public class ConcesionarioDAOImpl implements ConcesionarioDAO {
    Concesionario concesionario;
    public ConcesionarioDAOImpl() {
        super();
    }

    @Override
    public int getCanNombres(String nombre) throws SQLException, Exception {
        int cantidad = 0;
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        Query query;
        List list;
        session.getTransaction();
        session.beginTransaction();
        query = session.createQuery("FROM Concesionario  E WHERE  E.cncNombre like :nombre and E.cncEstado <> 0");
        query.setParameter("nombre", nombre);
        list = query.list();
        cantidad = list.size();
        session.getTransaction().commit();
        return cantidad;
    }

    @Override
    public List<Concesionario> query() throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list = session.createQuery("From Concesionario o where o.cncEstado <> 0 ORDER BY o.cncId DESC").list();
        session.getTransaction().commit();
        return  list;
    }

    @Override
    public List<Concesionario> queryF(String filtro) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        Query query;
        session.beginTransaction();
        query = session.createQuery("FROM Concesionario  E WHERE  ( upper(E.cncNombre) like :filtro1 or upper(E.cncSiglas) like:filtro1 or upper(E.cncDescripcion) like:filtro1) and E.cncEstado <> 0");
        query.setParameter("filtro1", "%" + filtro + "%");
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List<Concesionario> queryTD(int filtro) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        Query query;
        session.beginTransaction();
        query = session.createQuery("FROM Concesionario  E WHERE upper(E.tdoId)= :filtro1  and E.cncEstado <> 0");
        query.setParameter("filtro1",  filtro);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }
    
    
    
    @Override
    public String insert(Concesionario concesionario) throws SQLException, Exception {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.save(concesionario);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

   

    @Override
    public String update(Concesionario concesionario) throws SQLException, Exception {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            
            this.concesionario = get(concesionario.getCncId());
            System.out.println("1");
            this.concesionario = (Concesionario)Entity.updateChanges(this.concesionario, concesionario);
            System.out.println("1");
            session.update(this.concesionario);
            System.out.println("1");
            session.flush();
            System.out.println("1");
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public Concesionario get(Integer id) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        concesionario = (Concesionario) session.get(Concesionario.class, id);
        session.getTransaction().commit();
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }
    
    //Ivan
        public List<Concesionario> BusquedaConcesionario(String nombre, String Siglas, int tipodoc, String nrodoc)  throws SQLException ,Exception{
            Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
            session.beginTransaction();
            Query query;  
            if(tipodoc == 0){
                query = session.createQuery("FROM Concesionario c WHERE c.cncEstado <> 0 and lower(c.cncNombre) like lower(:busqueda1) and lower(c.cncDescripcion) like lower(:busqueda2)");
                query.setParameter("busqueda1","%"+nombre+"%");
                query.setParameter("busqueda2","%"+Siglas+"%");
            }else{
                query = session.createQuery("FROM Concesionario c WHERE c.cncEstado <> 0 and lower(c.cncNombre) like lower(:busqueda1) and lower(c.cncDescripcion) like lower(:busqueda2) and c.tdoId like :busqueda3 and c.cncNroDocumento like :busqueda4");
                query.setParameter("busqueda1","%"+nombre+"%");
                query.setParameter("busqueda2","%"+Siglas+"%");
                query.setParameter("busqueda3",tipodoc);
                query.setParameter("busqueda4",nrodoc);
            }
            List<Concesionario> list = query.list();
            session.getTransaction().commit();
            return list;
            
        }

   
}

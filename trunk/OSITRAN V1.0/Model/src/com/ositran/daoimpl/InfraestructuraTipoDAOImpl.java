package com.ositran.daoimpl;

import com.ositran.dao.InfraestructuraTipoDAO;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class InfraestructuraTipoDAOImpl implements InfraestructuraTipoDAO {
    InfraestructuraTipo infraestructuraTipo;

    @Override
    public String insert(InfraestructuraTipo infraestructuraTipo) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(infraestructuraTipo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            InfraestructuraTipo infraestructuraTipo = (InfraestructuraTipo) session.get(InfraestructuraTipo.class, id);
            session.delete(infraestructuraTipo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String update(InfraestructuraTipo infraestructuraTipo) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(infraestructuraTipo);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public InfraestructuraTipo get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        infraestructuraTipo = (InfraestructuraTipo) session.get(InfraestructuraTipo.class, id);
        return infraestructuraTipo;
    }

    @Override

    public List query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

        List list = session.createQuery("From InfraestructuraTipo o WHERE o.tinId > 0 and o.tinEstado<>0 order by TIN_ID asc").list();
        session.close();
        return list;
    }

    @Override
    public List<InfraestructuraTipo> AllSearch(String a) throws SQLException {
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        query =
            session.createQuery("FROM InfraestructuraTipo  I WHERE lower(I.tinNombre) like  lower(:busqueda) or lower(I.tinDescripcion) like lower(:busqueda)  order by TIN_ID asc");
        query.setParameter("busqueda", "%" + a + "%");
        return query.list();
    }


    public void setInfraestructuraTipo(InfraestructuraTipo infraestructuraTipo) {
        this.infraestructuraTipo = infraestructuraTipo;
    }

    public InfraestructuraTipo getInfraestructuraTipo() {
        return infraestructuraTipo;
    }
    
    @Override
    public String getNombre(int codigo) throws SQLException {
        String nombre;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        InfraestructuraTipo infraestructuraTipo = (InfraestructuraTipo) session.get(InfraestructuraTipo.class, codigo);
        nombre=infraestructuraTipo.getTinNombre();
        session.getTransaction().commit();
        return nombre;
    }
    

}

package com.ositran.daoimpl;


import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import java.sql.SQLException;
import com.ositran.util.HibernateUtil;
import com.ositran.dao.TipoDocumentoDAO;
import com.ositran.model.TipoDocumento;

public class TipoDocumentoDAOImpl implements TipoDocumentoDAO {
    
    public TipoDocumentoDAOImpl() {
        super();
    }

    @Override
    public List<TipoDocumento> query() throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("From TipoDocumento o").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(TipoDocumento tipodocumento) throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
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
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
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
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(tipodocumento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public TipoDocumento get(Integer id) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        TipoDocumento tipodocumento=(TipoDocumento)session.get(TipoDocumento.class, id);
        session.getTransaction().commit();
        return tipodocumento;
    }
    
    
    
    
    
}

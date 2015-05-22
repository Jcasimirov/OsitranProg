package com.ositran.daoimpl;

import com.ositran.dao.ContratoCompromisoDAO;
import com.ositran.model.ContratoCompromiso;
import com.ositran.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class ContratoCompromisoDAOImpl implements ContratoCompromisoDAO {
    public ContratoCompromisoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoCompromiso> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List results=session.createCriteria(ContratoCompromiso.class).list();
            tx.commit();
            return results;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<ContratoCompromiso> query1(int codigo) throws SQLException {
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            query =session.createQuery("FROM ContratoCompromiso cc where cc.conId = :filtro and cc.ccoEstado=1");
            query.setParameter("filtro",codigo);
            List<ContratoCompromiso> list = query.list();
            tx.commit();
            return list;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
    
    
    public List<ContratoCompromiso> querySupervisado(Integer conId) throws SQLException {
        System.out.println("hola llega hasta aqui");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query; 
            query = session.createQuery("FROM ContratoCompromiso cc where cc.ccoEstado <> 0" +
                                        "and cc.conId = :busqueda1 AND cc.tccTipo = 1 order by ccoId DESC");
            query.setParameter("busqueda1",conId);
            List<ContratoCompromiso> list = query.list();
            tx.commit();
            return list;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
    
    @Override
    public String insert(ContratoCompromiso contratoCompromiso) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(contratoCompromiso);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx!=null) {
                tx.rollback();
            }
            result=e.getMessage();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoCompromiso contratoCompromiso) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(contratoCompromiso);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result=e.getMessage();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public ContratoCompromiso get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoCompromiso contratoCompromiso=(ContratoCompromiso)session.get(ContratoCompromiso.class, id);
            tx.commit();
            return contratoCompromiso;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
    
    @Override
    public List<ContratoCompromiso> getCompromisosContrato(Integer conId) throws SQLException{
        System.out.println("INI DAO METHOD: getCompromisosContrato");
        System.out.println("conId: " + conId);        
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query; 
            query = session.createQuery("FROM ContratoCompromiso cc where cc.ccoEstado=1 " +
                                        "and cc.conId = :busqueda1 AND cc.tccTipo = 0 order by ccoId DESC");
            query.setParameter("busqueda1",conId);
            List<ContratoCompromiso> list = query.list();
            tx.commit();
            System.out.println("FIN DAO METHOD: getCompromisosContrato");
            return list;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
   
}

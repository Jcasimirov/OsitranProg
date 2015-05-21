package com.ositran.daoimpl;

import com.ositran.dao.ContratoCaoDAO;
import com.ositran.model.ContratoCao;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

@Repository
public class ContratoCaoDAOImpl implements ContratoCaoDAO {
    public ContratoCaoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoCao> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List list=session.createQuery("from ContratoCao cc where cc.caoEstado != 0").list();
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
    public String insert(ContratoCao contratoCao) throws SQLException {
        String result=null;
        System.out.println("## INI INSERT CAO");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.persist(contratoCao);
            tx.commit();
            System.out.println("## Insert OK");
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result=e.getMessage();
            System.out.println("## Insert rollback");
        } finally {
            session.close();
	}
        System.out.println("## FIN INSERT CAO");
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoCao contratoCao=(ContratoCao)session.get(ContratoCao.class, id);
            session.delete(contratoCao);
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
    public String update(ContratoCao contratoCao) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(contratoCao);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result = e.getMessage();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public ContratoCao get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoCao contratoCao = (ContratoCao) session.get(ContratoCao.class, id);
            tx.commit();
            return contratoCao;
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
    public List<ContratoCao> getCaosContrato(Integer conId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query; 
            query = session.createQuery("FROM ContratoCao cc where cc.caoEstado <> 0 and cc.conId = :busqueda1 order by caoId DESC");
            query.setParameter("busqueda1",conId);            
            List<ContratoCao> list = query.list();
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
}

package com.ositran.daoimpl;

import com.ositran.dao.ContratoCaoDAO;
import com.ositran.model.ContratoCao;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class ContratoCaoDAOImpl implements ContratoCaoDAO {
    public ContratoCaoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoCao> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("from ContratoCao cc where cc.caoEstado != 0").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(ContratoCao contratoCao) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(contratoCao);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            ContratoCao contratoCao=(ContratoCao)session.get(ContratoCao.class, id);
            session.delete(contratoCao);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(ContratoCao contratoCao) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contratoCao);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public ContratoCao get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ContratoCao contratoCao = (ContratoCao) session.get(ContratoCao.class, id);
        session.getTransaction().commit();
        return contratoCao;
    }
    
    @Override
    public List<ContratoCao> getCaosContrato(Integer conId) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query; 
        query = session.createQuery("FROM ContratoCao cc where cc.caoEstado <> 0 and cc.conId = :busqueda1 order by caoId DESC");
        query.setParameter("busqueda1",conId);            
        List<ContratoCao> list = query.list();
        session.getTransaction().commit();
        return list;        
              
        
        
    }  
}

package com.ositran.daoimpl;

import com.ositran.dao.ContratoEmpresaSupervisoraDAO;
import com.ositran.model.ContratoSupervisora;
import com.ositran.util.HibernateUtil;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ContratoEmpresaSupervisoraDAOImpl implements ContratoEmpresaSupervisoraDAO{
    ContratoSupervisora contratoSupervisora;

    public void setContratoSupervisora(ContratoSupervisora contratoSupervisora) {
        this.contratoSupervisora = contratoSupervisora;
    }

    public ContratoSupervisora getContratoSupervisora() {
        return contratoSupervisora;
    }

    @Override
    public List<ContratoSupervisora> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();        
        List<ContratoSupervisora> list = null;        
        try {
            session.beginTransaction();
            list = session.createQuery("from ContratoSupervisora c where c.cpsEstado <> 0").list();
            System.out.println(list.size());
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        }
        return list;

    }

    @Override
    public String insert(ContratoSupervisora contratoSupervisora) throws SQLException {
        String result=null;
        System.out.println("Entro al metodo  INSERT");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(contratoSupervisora);
            session.getTransaction().commit();
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            ContratoSupervisora contratoSupervisora = (ContratoSupervisora) session.get(ContratoSupervisora.class, id);
            session.delete(contratoSupervisora);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String update(ContratoSupervisora contratoSupervisora) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contratoSupervisora);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public ContratoSupervisora get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ContratoSupervisora contratoSupervisora=(ContratoSupervisora)session.get(ContratoSupervisora.class, id);
        session.getTransaction().commit();
        return contratoSupervisora;        
    }
    
     @Override
    public int ValidarContratoSupervisora(int i, int i2) throws SQLException {
        // TODO Implement this method
        return 0;
    }
    
    @Override
    public List<ContratoSupervisora> filtrarContraEmpSup(String empresaSupervisora) throws SQLException {
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        query =session.createQuery("FROM ContratoSupervisora u WHERE lower(u.cpsNroDeContrato) like lower(:busqueda) or lower(u.supId) like lower(:busqueda)");
        query.setParameter("busqueda", "%" + empresaSupervisora + "%");
        return query.list();
    }

    @Override
    public List<ContratoSupervisora> queryTD(int filtro) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        Query query;
        session.beginTransaction();
        query = session.createQuery("FROM ContratoSupervisora  E WHERE upper(E.tinId)= :filtro1 and upper(E.cpsEstado) <> 0");
        query.setParameter("filtro1",  filtro);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }

  
}

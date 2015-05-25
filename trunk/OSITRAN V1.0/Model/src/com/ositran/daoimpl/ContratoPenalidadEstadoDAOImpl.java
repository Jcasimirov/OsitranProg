package com.ositran.daoimpl;

import com.ositran.dao.ContratoPenalidadEstadoDAO;
import com.ositran.model.ContratoPenalidadEstado;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContratoPenalidadEstadoDAOImpl implements ContratoPenalidadEstadoDAO {
    public ContratoPenalidadEstadoDAOImpl() {
        super();
    }

    @Override
    public List<ContratoPenalidadEstado> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List<ContratoPenalidadEstado> list = session.createQuery("FROM ContratoPenalidadEstado").list();
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
    public List<ContratoPenalidadEstado> getXContrato() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }
    @Override
    public String insert(ContratoPenalidadEstado contratoPenalidadEstado) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoPenalidadEstado contratoPenalidadEstado) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoPenalidadEstado get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

 
}

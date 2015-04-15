package com.ositran.daoimpl;

import com.ositran.dao.ValorizacionInversionAvanceDAO;
import com.ositran.model.ValorizacionInversionAvance;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ValorizacionInversionAvanceDAOImpl implements ValorizacionInversionAvanceDAO{
    public ValorizacionInversionAvanceDAOImpl() {
        super();
    }

    @Override
    public List<ValorizacionInversionAvance> query() throws SQLException, Exception {
        // TODO Implement this method
        return Collections.emptyList();
    }
    
    @Override
    public List<ValorizacionInversionAvance> query1(int codigoContrato) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query;
        query=session.createQuery("FROM ValorizacionInversionAvance  E WHERE E.conId like :busqueda ");
        query.setParameter("busqueda",codigoContrato);
        return query.list();
    }
 

    @Override
    public int insert(ValorizacionInversionAvance valorizacionInversionAvance) throws SQLException, Exception {
   
        int codigoGenerado=0;
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(valorizacionInversionAvance);
            session.getTransaction().commit();
            codigoGenerado=valorizacionInversionAvance.getTiaNumero();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return codigoGenerado;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ValorizacionInversionAvance valorizacionInversionAvance) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public ValorizacionInversionAvance get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

  
}

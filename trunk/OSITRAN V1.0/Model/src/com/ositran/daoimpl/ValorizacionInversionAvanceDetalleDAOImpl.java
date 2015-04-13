package com.ositran.daoimpl;
import com.ositran.dao.ValorizacionInversionAvanceDetalleDAO;
import com.ositran.model.ValorizacionInversionAvanceDetalle;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

public class ValorizacionInversionAvanceDetalleDAOImpl implements ValorizacionInversionAvanceDetalleDAO {
    public ValorizacionInversionAvanceDetalleDAOImpl() {
        super();
    }

    @Override
    public List<ValorizacionInversionAvanceDetalle> query() throws SQLException, Exception {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ValorizacionInversionAvanceDetalle valorizacionInversionAvanceDetalle) throws SQLException,
                                                                                                       Exception {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(valorizacionInversionAvanceDetalle);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
      
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ValorizacionInversionAvanceDetalle valorizacionInversionAvanceDetalle) throws SQLException,
                                                                                                       Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public ValorizacionInversionAvanceDetalle get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }
}

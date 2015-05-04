package com.ositran.daoimpl;

import com.ositran.dao.InvAvnSupervisadaDetalleDAO;
import com.ositran.model.InvAvnSupervisadaDetalle;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

public class InvAvnSupervisadaDetalleDAOImpl implements InvAvnSupervisadaDetalleDAO{
    public InvAvnSupervisadaDetalleDAOImpl() {
        super();
    }

    @Override
    public List<InvAvnSupervisadaDetalle> query() throws SQLException, Exception {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public int insert(InvAvnSupervisadaDetalle invAvnSupervisadaDetalle) throws SQLException, Exception {
        int codigoCabecera=0;
        String result=null;
           Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
           try {
               session.beginTransaction();
               session.save(invAvnSupervisadaDetalle);
               session.getTransaction().commit();
              
               
          } catch (Exception e) {
               session.getTransaction().rollback();
               result=e.getMessage();
               e.printStackTrace();
           }
           return codigoCabecera;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(InvAvnSupervisadaDetalle invAvnSupervisadaDetalle) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public InvAvnSupervisadaDetalle get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }
}

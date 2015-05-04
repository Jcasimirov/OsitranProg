package com.ositran.daoimpl;

import com.ositran.dao.InvAvnSupervisadaDAO;
import com.ositran.model.InvAvnSupervisada;

import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

public class InvAvnSupervisadaDAOImpl implements InvAvnSupervisadaDAO {
    public InvAvnSupervisadaDAOImpl() {
        super();
    }

    @Override
    public List<InvAvnSupervisada> query() throws SQLException, Exception {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public int insert(InvAvnSupervisada invAvnSupervisada) throws SQLException, Exception {
        int codigoCabecera=0;
           Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
           try {
               session.beginTransaction();
               session.save(invAvnSupervisada);
               session.getTransaction().commit();
               codigoCabecera=invAvnSupervisada.getIasNumero().intValue();
          } catch (Exception e) {
               session.getTransaction().rollback();
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
    public String update(InvAvnSupervisada invAvnSupervisada) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public InvAvnSupervisada get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }
}

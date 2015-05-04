package com.ositran.daoimpl;

import com.ositran.dao.DerivarReconocimientoSupervisorDAO;
import com.ositran.model.DerivarReconocimientoSupervisor;
import com.ositran.model.InversionTipo;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

public class DerivarReconocimientoSupervisorDAOImpl implements DerivarReconocimientoSupervisorDAO{
    public DerivarReconocimientoSupervisorDAOImpl() {
        super();
    }


    @Override
    public List<DerivarReconocimientoSupervisor> query() throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        List list=session.createQuery("FROM DerivarReconocimientoSupervisor  E WHERE E.tivEstado <> 0").list();
        session.close();
        return list;
    }

    @Override
    public String insert(DerivarReconocimientoSupervisor derivarReconocimientoSupervisor) throws SQLException,Exception {
        System.out.println("anio");
        System.out.println(derivarReconocimientoSupervisor.getIadAnyo());
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(derivarReconocimientoSupervisor);
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
        return null;
    }

    @Override
    public String update(DerivarReconocimientoSupervisor derivarReconocimientoSupervisor) throws SQLException,
                                                                                                 Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public DerivarReconocimientoSupervisor get(Integer id) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }
}

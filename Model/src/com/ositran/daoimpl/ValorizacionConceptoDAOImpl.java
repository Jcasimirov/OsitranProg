package com.ositran.daoimpl;

import com.ositran.dao.ValorizacionConceptoDAO;
import com.ositran.model.ContratoCompromiso;
import com.ositran.model.InvReajuste;
import com.ositran.model.ValorizacionConcepto;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class ValorizacionConceptoDAOImpl implements ValorizacionConceptoDAO{
    public ValorizacionConceptoDAOImpl() {
        super();
    }


    @Override
    public List<ValorizacionConcepto> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        List list=session.createQuery("from ValorizacionConcepto cc").list();
        return list;
    }

    @Override
    public String insert(ValorizacionConcepto valorizacionConcepto) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ValorizacionConcepto valorizacionConcepto) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ValorizacionConcepto get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
                    session.beginTransaction();
                    ValorizacionConcepto valorizacionConcepto=(ValorizacionConcepto)session.get(ValorizacionConcepto.class, id);
                    session.getTransaction().commit();
                    session.close();
                    return valorizacionConcepto;
    }

    @Override
    public List<ValorizacionConcepto> getValorizacionConcepto(Integer cvaId) throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }
}



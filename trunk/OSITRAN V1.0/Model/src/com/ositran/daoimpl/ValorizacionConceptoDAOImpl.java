package com.ositran.daoimpl;

import com.ositran.dao.ValorizacionConceptoDAO;
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
    public String insert(InvReajuste invReajuste) throws SQLException {
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {

        return null;
    }

    @Override
    public String update(InvReajuste invReajuste) throws SQLException {
         return null;
    }

    @Override
    public InvReajuste get(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<ValorizacionConcepto> getInvReajustesAvance(Integer tiaNumero) throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }
}

package com.ositran.daoimpl;

import com.ositran.dao.InvAvnDerivadaDAO;
import com.ositran.model.InvAvnDerivada;
import com.ositran.model.InversionTipo;

import com.ositran.model.Moneda;
import com.ositran.util.HibernateUtil;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.eclipse.persistence.internal.oxm.schema.model.Restriction;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class InvAvnDerivadaDAOImpl implements InvAvnDerivadaDAO{
    InvAvnDerivada invAvnDerivada=new InvAvnDerivada();
    public InvAvnDerivadaDAOImpl() {
        super();
    }

    @Override
    public List<InvAvnDerivada> query() throws SQLException, Exception {
       return null;
    }

    @Override
    public String insert(InvAvnDerivada invAvnDerivada) throws SQLException, Exception {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(invAvnDerivada);
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
    public String update(InvAvnDerivada invAvnDerivada) throws SQLException, Exception {
        // TODO Implement this method
        return null;
    }

    @Override
    public InvAvnDerivada getAvanceInversion(Integer codigo) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Criteria criteria;
       criteria= session.createCriteria(InvAvnDerivada.class).add(Restrictions.eq("iadIdSup",codigo));
        return (InvAvnDerivada)criteria.uniqueResult();
    }
    
    
    @Override
    public InvAvnDerivada get(Integer id) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        invAvnDerivada = (InvAvnDerivada) session.get(InvAvnDerivada.class, id);
        return invAvnDerivada;
    }


    @Override
    public InvAvnDerivada get1(Integer id) throws SQLException, Exception {
        
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query;
        List list;
        query=session.createQuery("FROM InvAvnDerivada  E WHERE E.tiaNumero =:codigoValorizacion");
        query.setParameter("codigoValorizacion",id );
        invAvnDerivada=(InvAvnDerivada)query.uniqueResult();
        return invAvnDerivada;
        
    }
}

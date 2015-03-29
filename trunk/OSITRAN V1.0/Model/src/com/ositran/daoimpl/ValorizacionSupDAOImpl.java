package com.ositran.daoimpl;

import com.ositran.dao.ValorizacionSupDAO;
import com.ositran.model.JefeAreaContratoConcecion;
import com.ositran.model.ValorizacionSup;

import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ValorizacionSupDAOImpl implements ValorizacionSupDAO {
    public ValorizacionSupDAOImpl() {
        super();
    }


    @Override
    public List<ValorizacionSup> query() throws SQLException, Exception {
        return Collections.emptyList();
    }

    @Override
    public String insert(ValorizacionSup valorizacionSup) throws SQLException, Exception {
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        return null;
    }

    @Override
    public String update(ValorizacionSup valorizacionSup) throws SQLException, Exception {
        return null;
    }

    @Override
    public ValorizacionSup get(Integer id) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        ValorizacionSup valorizacionSup=(ValorizacionSup)session.get(ValorizacionSup.class, id); 
        session.getTransaction().commit();
        return valorizacionSup;
    }
    
    
}

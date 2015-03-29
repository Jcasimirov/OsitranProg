package com.ositran.daoimpl;

import com.ositran.dao.AvanceInversionWebDAO;
import com.ositran.model.AvanceInversionWeb;

import com.ositran.model.InversionTipo;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

public class AvanceInversionWebDAOImpl implements  AvanceInversionWebDAO{

    AvanceInversionWeb avanceInversionWeb;
    
    @Override
    public List<AvanceInversionWeb> query() throws SQLException, Exception {
        return Collections.emptyList();
    }

    @Override
    public String insert(AvanceInversionWeb avanceInversionWeb) throws SQLException, Exception {
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        return null;
    }

    @Override
    public String update(AvanceInversionWeb avanceInversionWeb) throws SQLException, Exception {
        return null;
    }

    @Override
    public AvanceInversionWeb get(Integer id) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        avanceInversionWeb = (AvanceInversionWeb) session.get(AvanceInversionWeb.class, id);
        return avanceInversionWeb;
    }


    public void setAvanceInversionWeb(AvanceInversionWeb avanceInversionWeb) {
        this.avanceInversionWeb = avanceInversionWeb;
    }

    public AvanceInversionWeb getAvanceInversionWeb() {
        return avanceInversionWeb;
    }
}

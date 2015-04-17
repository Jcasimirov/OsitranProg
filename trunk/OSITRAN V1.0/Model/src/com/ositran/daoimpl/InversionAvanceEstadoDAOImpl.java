package com.ositran.daoimpl;

import com.ositran.dao.InversionAvanceEstadoDAO;
import com.ositran.model.InvAvnEstado;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class InversionAvanceEstadoDAOImpl implements InversionAvanceEstadoDAO{
    public List<InvAvnEstado> query() throws SQLException{        
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        List list=session.createQuery("FROM InvAvnEstado  e").list();
        session.close();
        return list;
    }
    
   
}

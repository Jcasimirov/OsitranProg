package com.ositran.daoimpl;

import com.ositran.dao.JefeAreaContratoConcecionDAO;
import com.ositran.model.InversionTipo;
import com.ositran.model.JefeAreaContratoConcecion;

import com.ositran.model.Men;
import com.ositran.model.Rol;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class JefeAreaContratoConcecionDAOImpl implements JefeAreaContratoConcecionDAO {
    JefeAreaContratoConcecion jefeAreaContratoConcecion;

    @Override
    @SuppressWarnings("unchecked")
    public List<JefeAreaContratoConcecion> query() throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        return session.createCriteria(JefeAreaContratoConcecion.class).list();
    }

    @Override
    public String insert(JefeAreaContratoConcecion jefeAreaContratoConcecion) throws SQLException, Exception {
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException, Exception {
        return null;
    }

    @Override
    public String update(JefeAreaContratoConcecion jefeAreaContratoConcecion) throws SQLException, Exception {
        return null;
    }


    @Override
    public JefeAreaContratoConcecion get(Integer codigoTipoInfra) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query;
        List list;
        query=session.createQuery("FROM JefeAreaContratoConcecion  E WHERE E.sjaTipoInfraestructura= :codigo");
        query.setParameter("codigo",codigoTipoInfra );
        list= query.list();  
        jefeAreaContratoConcecion=(JefeAreaContratoConcecion)list.get(0);
        return jefeAreaContratoConcecion;

    }


    public void setJefeAreaContratoConcecion(JefeAreaContratoConcecion jefeAreaContratoConcecion) {
        this.jefeAreaContratoConcecion = jefeAreaContratoConcecion;
    }

    public JefeAreaContratoConcecion getJefeAreaContratoConcecion() {
        return jefeAreaContratoConcecion;
    }
}

package com.ositran.daoimpl;

import com.ositran.dao.ContratoJefeAreaDAO;
import com.ositran.model.ContratoJefeArea;
import com.ositran.model.InversionTipo;

import com.ositran.util.HibernateUtil;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

public class ContratoJefeAreaDAOImpl implements ContratoJefeAreaDAO{
    public ContratoJefeAreaDAOImpl() {
        super();
    }

    @Override
    public List<ContratoJefeArea> query() {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoJefeArea contratoJefeArea) {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(contratoJefeArea);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoJefeArea contratoJefeArea) {
        // TODO Implement this method
        return null;
    }

    @Override
    public InversionTipo get(Integer id) {
        // TODO Implement this method
        return null;
    }

    @Override
    public List<ContratoJefeArea> query1(String buscar) {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public int getCanNombres(String nombre) {
        // TODO Implement this method
        return 0;
    }
}

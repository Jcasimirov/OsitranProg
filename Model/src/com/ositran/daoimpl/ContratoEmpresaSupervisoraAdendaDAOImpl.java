package com.ositran.daoimpl;

import com.ositran.dao.ContratoEmpresaSupervisoraAdendaDAO;
import com.ositran.model.ContratoSupervisora;
import com.ositran.model.ContratoSupervisoraAdenda;
import com.ositran.model.EmpresaSupervisora;

import com.ositran.model.ValorizacionInversionAvanceDetalle;
import com.ositran.model.ValorizacionSupDetalle;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class ContratoEmpresaSupervisoraAdendaDAOImpl implements ContratoEmpresaSupervisoraAdendaDAO{
    public ContratoEmpresaSupervisoraAdendaDAOImpl() {
        super();
    }
    
    ContratoSupervisoraAdenda contratoSupervisoraAdenda;

    public void setContratoSupervisoraAdenda(ContratoSupervisoraAdenda contratoSupervisoraAdenda) {
        this.contratoSupervisoraAdenda = contratoSupervisoraAdenda;
    }

    public ContratoSupervisoraAdenda getContratoSupervisoraAdenda() {
        return contratoSupervisoraAdenda;
    }

    @Override
    public List<ContratoSupervisoraAdenda> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list = session.createQuery("select o from ContratoSupervisoraAdenda o").list();
        return list;
    }

    @Override
    public String insert(ContratoSupervisoraAdenda contratoSupervisoraAdenda) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(contratoSupervisoraAdenda);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            ContratoSupervisoraAdenda contratoSupervisoraAdenda = (ContratoSupervisoraAdenda) session.get(ContratoSupervisoraAdenda.class, id);
            session.delete(contratoSupervisoraAdenda);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public List<ContratoSupervisoraAdenda> getContratoSupervisoraAdenda(Integer cpsNroDeContrato) throws SQLException,
                                                                                                         Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query; 
        query = session.createQuery("FROM ContratoSupervisoraAdenda cs where cs.cpsNroDeContrato = :cpsNroDeContrato");
        query.setParameter("cpsNroDeContrato",cpsNroDeContrato);            

        List<ContratoSupervisoraAdenda> list = query.list();
        session.close();
        return list; 
    }
}

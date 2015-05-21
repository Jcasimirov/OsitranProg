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
import org.hibernate.Transaction;

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
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List list = session.createQuery("select o from ContratoSupervisoraAdenda o").list();
            tx.commit();
            return list;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public String insert(ContratoSupervisoraAdenda contratoSupervisoraAdenda) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(contratoSupervisoraAdenda);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result = e.getMessage();
            e.printStackTrace();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoSupervisoraAdenda contratoSupervisoraAdenda = (ContratoSupervisoraAdenda) session.get(ContratoSupervisoraAdenda.class, id);
            session.delete(contratoSupervisoraAdenda);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result = e.getMessage();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public List<ContratoSupervisoraAdenda> getContratoSupervisoraAdenda(Integer cpsNroDeContrato) throws SQLException,
                                                                                                         Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query; 
            query = session.createQuery("FROM ContratoSupervisoraAdenda cs where cs.cpsNroDeContrato = :cpsNroDeContrato");
            query.setParameter("cpsNroDeContrato",cpsNroDeContrato);
            List<ContratoSupervisoraAdenda> list = query.list();
            tx.commit();
            return list;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}

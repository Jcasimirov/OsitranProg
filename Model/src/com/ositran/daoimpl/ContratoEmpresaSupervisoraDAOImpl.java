package com.ositran.daoimpl;

import com.ositran.dao.ContratoEmpresaSupervisoraDAO;
import com.ositran.model.ContratoSupervisora;
import com.ositran.util.HibernateUtil;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContratoEmpresaSupervisoraDAOImpl implements ContratoEmpresaSupervisoraDAO{
    ContratoSupervisora contratoSupervisora;

    public void setContratoSupervisora(ContratoSupervisora contratoSupervisora) {
        this.contratoSupervisora = contratoSupervisora;
    }

    public ContratoSupervisora getContratoSupervisora() {
        return contratoSupervisora;
    }

    @Override
    public List<ContratoSupervisora> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();        
        List<ContratoSupervisora> list = null;
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            list = session.createQuery("from ContratoSupervisora c where c.cpsEstado <> 0").list();
            System.out.println(list.size());
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            session.close();
	}
        return list;
    }

    @Override
    public int insert(ContratoSupervisora contratoSupervisora) throws SQLException {
        String result=null;
        System.out.println("Entro al metodo  INSERT");
        int codigoGenerado=0;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.persist(contratoSupervisora);
            tx.commit();
            codigoGenerado=contratoSupervisora.getCpsNroDeContrato();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result=e.getMessage();
            e.printStackTrace();
        } finally {
            session.close();
	}
        return codigoGenerado;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoSupervisora contratoSupervisora = (ContratoSupervisora) session.get(ContratoSupervisora.class, id);
            session.delete(contratoSupervisora);
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
    public String update(ContratoSupervisora contratoSupervisora) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(contratoSupervisora);
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            result=e.getMessage();
            e.printStackTrace();
        } finally {
            session.close();
	}
        return result;
    }

    @Override
    public ContratoSupervisora get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            ContratoSupervisora contratoSupervisora=(ContratoSupervisora)session.get(ContratoSupervisora.class, id);
            tx.commit();
            return contratoSupervisora;
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
    public int ValidarContratoSupervisora(int i, int i2) throws SQLException {
        // TODO Implement this method
        return 0;
    }
    
    @Override
    public List<ContratoSupervisora> filtrarContraEmpSup(String empresaSupervisora) throws SQLException {
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            query =session.createQuery("FROM ContratoSupervisora u WHERE lower(u.cpsNroDeContrato) like lower(:busqueda)");
            query.setParameter("busqueda", "%" + empresaSupervisora + "%");
            List a=query.list();
            tx.commit();
            return a;
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
    public List<ContratoSupervisora> queryTD(int filtro) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query;
            session.beginTransaction();
            query = session.createQuery("FROM ContratoSupervisora  E WHERE upper(E.tinId)= :filtro1 and upper(E.cpsEstado) <> 0");
            query.setParameter("filtro1",  filtro);
            List list = query.list();
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
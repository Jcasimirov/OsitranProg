package com.ositran.daoimpl;

import com.ositran.dao.ContratoConcesionDAO;
import com.ositran.dao.EmpresaSupervisoraDAO;

import com.ositran.model.Contrato;

import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import java.sql.SQLException;
import com.ositran.util.HibernateUtil;
import com.ositran.model.EmpresaSupervisora;

@Repository
public class ContratoConcesionDAOImpl implements ContratoConcesionDAO { 
     
        List<Contrato> list = null;    


    public ContratoConcesionDAOImpl() {
        super();
    }
    
    @Override
    public List<Contrato> query() throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        list= session.createQuery("select o from Contrato o").list();            
        System.out.println("LISTA = "+list);
        session.getTransaction().commit();
        session.close();
        return list;
    }

        @Override
        public String insert(Contrato contrato) throws SQLException{
            String result=null;
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            try {
                session.beginTransaction();
                session.persist(contrato);
                session.getTransaction().commit();
                
           } catch (Exception e) {
                session.getTransaction().rollback();
                result=e.getMessage();
            }
            session.close();
            return result;
        }
        
        @Override
        public String delete(Integer id) throws SQLException{
            String result=null;
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            try {
                session.beginTransaction();
                Contrato contrato=(Contrato)session.get(Contrato.class, id);
                session.delete(contrato);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                result=e.getMessage();
            }
            session.close();
            return result;
        }
        
    @Override
    public String update(Contrato contrato) throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(contrato);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            System.out.println(result);
        }
        session.close();
        return result;
    }
        
        @Override
        public Contrato get(Integer id) throws SQLException{
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            session.beginTransaction();
            Contrato contrato=(Contrato)session.get(Contrato.class, id);
            session.getTransaction().commit();
            session.close();
            return contrato;
        }

}

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

import java.util.Date;

@Repository
public class ContratoConcesionDAOImpl implements ContratoConcesionDAO { 
     
        List<Contrato> list = null;    


    public ContratoConcesionDAOImpl() {
        super();
    }
    
   
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
        
    @Override
    public int ValidarContratoConcesion(int concesion, int tipoinfra) throws SQLException{
        
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM Contrato c WHERE c.csiId like :busqueda1 and c.tinId like :busqueda2");
        query.setParameter("busqueda1",concesion);
        query.setParameter("busqueda2",tipoinfra);
        list= query.list();
        session.getTransaction().commit();
        session.close();
        return list.size();       
    }
    
    @Override
    public List<Contrato> buscarContratos(int tinfraestructura, int concesion, int modalidadConcesion, Date fechaInicio, Date fechaFin) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();    
        Query query;
        if(fechaInicio == null && fechaFin == null){
            query=session.createQuery("FROM Contrato c WHERE c.tinId like :busqueda1 and c.csiId like :busqueda2 and c.mcoId like :busqueda3");
            query.setParameter("busqueda1",tinfraestructura);
            query.setParameter("busqueda2",concesion);
            query.setParameter("busqueda3",modalidadConcesion);
        
        }else if((fechaInicio == null && fechaFin == null) && tinfraestructura == 0){
            query=session.createQuery("FROM Contrato c WHERE c.mcoId like :busqueda");
            query.setParameter("busqueda",modalidadConcesion);
        
        }else if((fechaInicio == null && fechaFin == null) && modalidadConcesion == 0){
            query=session.createQuery("FROM Contrato c WHERE c.tinId like :busqueda1 and c.csiId like :busqueda2 ");
            query.setParameter("busqueda1",tinfraestructura);
            query.setParameter("busqueda2",concesion);
            
        }else if((fechaInicio == null && fechaFin == null) && modalidadConcesion == 0 && concesion == 0){
            query=session.createQuery("FROM Contrato c WHERE c.tinId like :busqueda");
            query.setParameter("busqueda",tinfraestructura);
            
        }else {            
            query=session.createQuery("FROM Contrato c WHERE c.tinId like :busqueda1 and c.csiId like :busqueda2 and c.mcoId like :busqueda3 and c.conFechaSuscripcion >= busqueda4 and c.conFechaSuscripcion <= busqueda5");
            query.setParameter("busqueda1",tinfraestructura);
            query.setParameter("busqueda2",concesion);
            query.setParameter("busqueda3",modalidadConcesion);
            query.setParameter("busqueda4",fechaInicio);
            query.setParameter("busqueda5",fechaFin);
            
        }
        list= query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

}

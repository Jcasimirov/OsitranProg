package com.ositran.daoimpl;


import com.ositran.dao.ModalidadConcesionDAO;
import com.ositran.model.ModalidadConcesion;
import com.ositran.util.HibernateUtil;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

@Repository
public class ModalidadConcesionDAOImpl implements ModalidadConcesionDAO {
    
        List<ModalidadConcesion> list = null;
        
    public ModalidadConcesionDAOImpl() {
        super();
    }
    
    @Override
    public List<ModalidadConcesion> query() throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

        List<ModalidadConcesion> list= session.createQuery("From ModalidadConcesion o where o.mcoEstado<> 0").list();            
        System.out.println("LISTA = "+list);

        session.close();
        return list;
    }
    
    @Override
    public int  ValidarNombre(String atributo) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM ModalidadConcesion m WHERE upper(m.mcoNombre) like  upper(:busqueda) and mcoEstado<> 0");
        query.setParameter("busqueda",atributo);
        list= query.list();
        session.getTransaction().commit();
        session.close();
        return list.size();
    }
    
    @Override
    public int  ValidarNombreMod(String atributo, String NombreMod) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM ModalidadConcesion m WHERE upper(m.mcoNombre) like  upper(:busqueda) and mcoEstado<> 0");
        query.setParameter("busqueda",atributo);
        list= query.list();
        list= query.list();
        for (int i = 0 ; i<list.size();i++){
            if (list.get(i).getMcoNombre().equals(NombreMod)){
                list.remove(i);
            }
        }
        session.getTransaction().commit();
        session.close();
        return list.size();
    }
    
    @Override
    public List<ModalidadConcesion> FiltrarModalidad(String atributo) throws SQLException{
        
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM ModalidadConcesion m WHERE (upper(m.mcoNombre) like  upper(:busqueda) or upper(m.mcoDescripcion) like  upper(:busqueda)) and mcoEstado<> 0");
        query.setParameter("busqueda","%"+atributo+"%");
        list= query.list();
        session.getTransaction().commit();
        session.close();
        return list;
        
    }

        @Override
        public String insert(ModalidadConcesion modalidadConcesion) throws SQLException{
            String result=null;
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            try {
                session.beginTransaction();
                session.persist(modalidadConcesion);
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
                ModalidadConcesion modalidadConcesion=(ModalidadConcesion)session.get(ModalidadConcesion.class, id);
                session.delete(modalidadConcesion);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                result=e.getMessage();
            }
            session.close();
            return result;
        }
        
    @Override
    public String update(ModalidadConcesion modalidadConcesion) throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(modalidadConcesion);
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
        public ModalidadConcesion get(Integer id) throws SQLException{
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            session.beginTransaction();
            ModalidadConcesion modalidadConcesion=(ModalidadConcesion)session.get(ModalidadConcesion.class, id);
            session.getTransaction().commit();
            session.close();
            return modalidadConcesion;
        }
    public boolean validarCodigoEnUso(Integer mcoId) throws Exception{
        boolean valido=false;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query=null;  
            query =session.createQuery("Select count(o.mcoId) From Contrato o where o.conEstado = 1 and o.mcoId=:mcoId");
            query.setParameter("mcoId",mcoId);
            Long contador=(Long)query.uniqueResult();
            valido=(contador>0)?false:true;  
            if(valido){
            query =session.createQuery("Select count(o.mcoId) From ContratoRespSup o where o.mcoId=:mcoId");
            query.setParameter("mcoId",mcoId);
            Long contador2=(Long)query.uniqueResult();
            valido=(contador2>0)?false:true; 
            }
            if(valido){
            query =session.createQuery("Select count(o.mcoId) From InvAvnDerivada o where o.iasEstado=1 and o.mcoId=:mcoId");
            query.setParameter("mcoId",new BigDecimal(""+mcoId));
            Long contador2=(Long)query.uniqueResult();
            valido=(contador2>0)?false:true; 
            }
            if(valido){
            query =session.createQuery("Select count(o.mcoId) From ContratoAlerta o where o.calEstado=1 and o.mcoId=:mcoId");
            query.setParameter("mcoId",mcoId);
            Long contador2=(Long)query.uniqueResult();
            valido=(contador2>0)?false:true; 
            }
            if(valido){
            query =session.createQuery("Select count(o.mcoId) From ValorizacionInversionAvance o where o.mcoId=:mcoId");
            query.setParameter("mcoId",mcoId);
            Long contador2=(Long)query.uniqueResult();
            valido=(contador2>0)?false:true; 
            }
            if(valido){
            query =session.createQuery("Select count(o.mcoId) From InvAvn o where o.mcoId=:mcoId");
            query.setParameter("mcoId",mcoId);
            Long contador2=(Long)query.uniqueResult();
            valido=(contador2>0)?false:true; 
            }
            tx.commit();
            return valido;
        } catch (Exception e) {
            e.printStackTrace();
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}

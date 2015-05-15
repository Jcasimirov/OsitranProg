package com.ositran.daoimpl;

import com.ositran.dao.InfraestructuraDAO;
import com.ositran.model.Infraestructura;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

@Repository
public class InfraestructuraDAOImpl implements InfraestructuraDAO{

    


    @Override
    public List<Infraestructura> query1(int codigoC) {
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        Query query;
        query = session.createQuery("From Infraestructura i WHERE i.infEstado=1 and i.csiId = :busqueda1");
        query.setParameter("busqueda1",codigoC);
        List<Infraestructura> list = query.list();
        session.getTransaction().commit();
        return list; 
    }
    
    @Override
    public List<Infraestructura> query2(int codigoC) {
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        Query query;
        query = session.createQuery("From Infraestructura i WHERE i.infEstado=1 and i.csiId = :busqueda1");
        query.setParameter("busqueda1",codigoC);
        List<Infraestructura> list = query.list();
        session.getTransaction().commit();
        return list; 
    }




    @Override
    public List<Infraestructura> query() {
        System.out.println("DAO");
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        List list = session.createQuery("select o from Infraestructura o WHERE o.infEstado=1").list();
        
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(Infraestructura infraestructura) {
        String result=null;
        System.out.println("DaoInfra");
           Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
           try {
               session.beginTransaction();
               session.save(infraestructura);
               session.getTransaction().commit();
          } catch (Exception e) {  
               e.printStackTrace();  
               session.getTransaction().rollback();
               result=e.getMessage();
           }
           return result;
    }

    @Override
    public String delete(Integer id) {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(Infraestructura infraestructura) {
        
            System.out.println(infraestructura.getInfId());
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(infraestructura);
            session.getTransaction().commit();
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    
    @Override
    public Infraestructura get2(Integer id) {
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        Infraestructura infraestructura = (Infraestructura) session.get(Infraestructura.class, id);
        session.getTransaction().commit();
        return infraestructura;
    }
    
    @Override
    public Infraestructura get(int codifoInfraestructura, int codigoConcesion,
                               int tipoInfraestructura) throws SQLException {
        
        System.out.println("VALORES QUE LLEGAN AL DAO");
        System.out.println("codigoInfra:"+codifoInfraestructura);
            System.out.println("codigoConcesion:"+codigoConcesion);
            System.out.println("tipoInfra:"+tipoInfraestructura);
        Infraestructura infra=new Infraestructura();
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        Query query;
            query=session.createQuery("FROM Infraestructura  E WHERE E.infId=:codifoInfraestructura and E.csiId=:codigoConcesion and E.tinId=:tipoInfraestructura");
            query.setParameter("codifoInfraestructura",codifoInfraestructura );
            query.setParameter("codigoConcesion",codigoConcesion );
            query.setParameter("tipoInfraestructura",tipoInfraestructura );
            infra=(Infraestructura)query.uniqueResult();
        session.getTransaction().commit();
        return infra;
        }
    
    
    /*     @Override
    public Infraestructura eliminarInfraestructura(Integer id) {
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        Infraestructura infraestructura = (Infraestructura) session.get(Infraestructura.class, id);
        session.getTransaction().commit();
        return infraestructura;
    }
     */
        
    @Override
    public List<Infraestructura> getInfraestructurasContrato(int codigoContrato) {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        
        Query query;
        query = session.createSQLQuery("select i.* from T_INFRAESTRUCTURA i " + 
                                        "INNER JOIN t_contrato ct " + 
                                        "ON i.CSI_ID = ct.CSI_ID " + 
                                        "AND i.TIN_ID = ct.TIN_ID " + 
                                        "WHERE i.INF_ESTADO <> 0 " + 
                                        "AND ct.CON_ID = :busqueda1").addEntity(Infraestructura.class);
        query.setParameter("busqueda1",codigoContrato);
        List<Infraestructura> list = query.list();
        

        return list; 
    }
    @Override
    public List<Infraestructura> getInfraestructurasInversion(int codigoConcesion) throws Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        
        Query query;
        query = session.createSQLQuery("select distinct i.* from t_contrato_inversion t " + 
                                        "inner join  T_INFRAESTRUCTURA i " + 
                                        "on t.TIN_ID = i.TIN_ID " + 
                                        "and t.CSI_ID = i.CSI_ID " + 
                                        "and t.INF_ID = i.INF_ID " + 
                                        "where i.CSI_ID = :busqueda1 " + 
                                        "and t.INV_ESTADO=1 " + 
                                        "and i.INF_ESTADO=1 ").addEntity(Infraestructura.class);
        query.setParameter("busqueda1",codigoConcesion);
        List<Infraestructura> list = query.list();
        

        return list; 
    }
}

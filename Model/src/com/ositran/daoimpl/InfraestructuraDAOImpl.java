package com.ositran.daoimpl;

import com.ositran.dao.InfraestructuraDAO;
import com.ositran.model.Infraestructura;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.util.HibernateUtil;

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
        session.close();
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
        session.close();
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
    public InfraestructuraTipo get(Integer id) {
        // TODO Implement this method
        return null;
    }
    
    @Override
    public Infraestructura get2(Integer id) {
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        Infraestructura infraestructura = (Infraestructura) session.get(Infraestructura.class, id);
        session.getTransaction().commit();
        return infraestructura;
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
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        
        Query query;
        query = session.createSQLQuery("select i.* from T_INFRAESTRUCTURA i\n" + 
                                        "INNER JOIN t_contrato ct \n" + 
                                        "ON i.CSI_ID = ct.CSI_ID \n" + 
                                        "AND i.TIN_ID = ct.TIN_ID \n" + 
                                        "WHERE i.INF_ESTADO <> 0 \n" + 
                                        "AND ct.CON_ID = :busqueda1").addEntity(Infraestructura.class);
        query.setParameter("busqueda1",codigoContrato);
        List<Infraestructura> list = query.list();
        
        session.close();
        return list; 
    }


  
}

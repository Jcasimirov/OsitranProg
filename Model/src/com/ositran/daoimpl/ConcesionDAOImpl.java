package com.ositran.daoimpl;

import com.ositran.dao.ConcesionDAO;
import com.ositran.model.Concesion;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;

import org.springframework.stereotype.Repository;

@Repository
public class ConcesionDAOImpl implements ConcesionDAO {
   
   
    @Override
    public List<Concesion> query() throws SQLException{
        System.out.println("DAO");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List list = session.createQuery("From Concesion o where o.csiEstado <> 0 and o.csiId <> 0 order by CSI_ID DESC ").list();
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
    public String insert(Concesion concesion) throws SQLException{
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.persist(concesion);
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
    public int idConcesion(Concesion concesion) throws SQLException{
        int result = 0;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(concesion);
            result=concesion.getCsiId();
            tx.commit();
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
	} finally {
            session.close();
	}
        return result;
    }
    
    @Override
    public String delete(Integer id) throws SQLException{
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Concesion concesion = (Concesion) session.get(Concesion.class, id);
            session.delete(concesion);
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
    public String update(Concesion concesion) throws SQLException{    
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(concesion);
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
    public String update2(Concesion concesion) throws SQLException{
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(concesion);
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
    public Concesion get(Integer id) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Concesion concesion = (Concesion) session.get(Concesion.class, id);
            tx.commit();
            return concesion;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
    //charles
    public List<Concesion> queryfiltro(int codigo, String nombre) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query;
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            if(codigo < 1 ){
                query = session.createQuery("FROM Concesion c WHERE c.csiEstado <> 0 and lower(c.csiNombre) like lower(:busqueda2)");
            }else{
                query = session.createQuery("FROM Concesion c WHERE c.csiEstado <> 0 and c.tinId like :busqueda1 and lower(c.csiNombre) like lower(:busqueda2)");
              
                query.setInteger("busqueda1",codigo);
            }        
            query.setString("busqueda2","%"+nombre+"%");
            List<Concesion> list = query.list();
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
    
    // Iosusky
    public List<Concesion> filtrarConcesion(int tipoInfraestructura) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query=null;  
            query = session.createQuery("FROM Concesion c WHERE c.csiEstado <> 0 and c.tinId <> 0 and c.tinId = :busqueda ");
            query.setParameter("busqueda",tipoInfraestructura);
            List<Concesion> list=query.list();
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

    public List<Concesion> listarConcesiones() throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List<Concesion> list = session.createQuery("select o from Concesion o where o.csiEstado <> 0 order by o.csiId").list();
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
    
    public List<Concesion> listarConcesionesxIdConcesion(int idConcesion) throws Exception{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query=null;  
            query =session.createQuery("From Concesion o where o.csiEstado <> 0 and o.csiId=:idConcesion order by o.csiId");
            query.setParameter("idConcesion",idConcesion);
            List lista=query.list();
            tx.commit();
            return (List<Concesion>)lista;
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
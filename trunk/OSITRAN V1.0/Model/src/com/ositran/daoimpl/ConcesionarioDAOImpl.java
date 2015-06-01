package com.ositran.daoimpl;

import com.ositran.dao.ConcesionarioDAO;
import com.ositran.model.Concesionario;
import com.ositran.util.Entity;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ConcesionarioDAOImpl implements ConcesionarioDAO {
    Concesionario concesionario;
    public ConcesionarioDAOImpl() {
        super();
    }

    @Override
    public int getCanNombres(String nombre) throws SQLException, Exception {
        int cantidad = 0;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        Query query;
        List list;
        try {
            tx=session.beginTransaction();
            query = session.createQuery("FROM Concesionario  E WHERE  E.cncNombre like :nombre and E.cncEstado <> 0");
            query.setParameter("nombre", nombre);
            list = query.list();
            cantidad = list.size();
            tx.commit();
            return cantidad;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }


   
    public int getCanRuc(String nombre) throws SQLException, Exception {
        int cantidad = 0;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        Query query;
        List list;
        try {
            tx=session.beginTransaction();
            query = session.createQuery("FROM Concesionario  E WHERE  E.cncNroDocumento like :nombre and E.cncEstado <> 0");
            query.setParameter("nombre", nombre);
            list = query.list();
            cantidad = list.size();
            tx.commit();
            return cantidad;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
    
    public int getCanSiglas(String nombre) throws SQLException, Exception {
        int cantidad = 0;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        Query query;
        List list;
        try {
            tx=session.beginTransaction();
            query = session.createQuery("FROM Concesionario  E WHERE  E.cncSiglas like :nombre and E.cncEstado <> 0");
            query.setParameter("nombre", nombre);
            list = query.list();
            cantidad = list.size();
            tx.commit();
            return cantidad;
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
    public List<Concesionario> query() throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List list = session.createQuery("From Concesionario o where o.cncEstado <> 0 ORDER BY o.cncFechaAlta DESC").list();
            tx.commit();
            return  list;
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
    public List<Concesionario> queryF(String filtro) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        Query query;
        try {
            tx=session.beginTransaction();
            query = session.createQuery("FROM Concesionario  E WHERE  ( upper(E.cncNombre) like :filtro1 or upper(E.cncSiglas) like:filtro1 or upper(E.cncDescripcion) like:filtro1) and E.cncEstado <> 0");
            query.setParameter("filtro1", "%" + filtro + "%");
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

    @Override
    public List<Concesionario> queryTD(int filtro) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query;
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            query = session.createQuery("FROM Concesionario  E WHERE upper(E.tdoId)= :filtro1  and E.cncEstado <> 0");
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
    
    
    
    @Override
    public String insert(Concesionario concesionario) throws SQLException, Exception {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(concesionario);
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
    public String update(Concesionario concesionario) throws SQLException, Exception {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            this.concesionario = get(concesionario.getCncId());
            System.out.println("1");
            this.concesionario = (Concesionario)Entity.updateChanges(this.concesionario, concesionario);
            System.out.println("1");
            session.update(this.concesionario);
            System.out.println("1");
            session.flush();
            System.out.println("1");
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
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
    public Concesionario get(Integer id) throws SQLException, Exception {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            concesionario = (Concesionario) session.get(Concesionario.class, id);
            tx.commit();
            return concesionario;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }
    
    //Ivan
    public List<Concesionario> BusquedaConcesionario(String nombre, String Siglas, int tipodoc, String nrodoc)  throws SQLException ,Exception{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Query query;
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            if(tipodoc == 0){
                query = session.createQuery("FROM Concesionario c WHERE c.cncEstado <> 0 and lower(c.cncNombre) like lower(:busqueda1) and lower(c.cncDescripcion) like lower(:busqueda2)");
                query.setParameter("busqueda1","%"+nombre+"%");
                query.setParameter("busqueda2","%"+Siglas+"%");
            }else{
                query = session.createQuery("FROM Concesionario c WHERE c.cncEstado <> 0 and lower(c.cncNombre) like lower(:busqueda1) and lower(c.cncDescripcion) like lower(:busqueda2) and c.tdoId like :busqueda3 and c.cncNroDocumento like :busqueda4");
                query.setParameter("busqueda1","%"+nombre+"%");
                query.setParameter("busqueda2","%"+Siglas+"%");
                query.setParameter("busqueda3",tipodoc);
                query.setParameter("busqueda4",nrodoc);
            }
            List<Concesionario> list = query.list();
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
    public boolean validarCodigoEnUso(Integer id) throws Exception{
        boolean valido=false;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query query=null;  
            query =session.createQuery("Select count(o.cncId) From Contrato o where o.conEstado = 1 and o.cncId=:id");
            query.setParameter("id",id);
            Long contador=(Long)query.uniqueResult();
            valido=(contador>0)?false:true;            
            tx.commit();
            return valido;
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
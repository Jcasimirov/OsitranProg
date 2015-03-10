package com.ositran.daoimpl;
import com.ositran.dao.InversionDescripcionDAO;
import com.ositran.model.InversionTipoDescripcion;
import com.ositran.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InversionDescripcionDAOImpl implements InversionDescripcionDAO{
    InversionTipoDescripcion inversionTipoDescripcion;

    @Override
    public List<InversionTipoDescripcion> query()  throws SQLException ,Exception{
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
        List list=session.createQuery("select o from InversionTipoDescripcion o").list();
        session.getTransaction().commit();
        return list;
    }
    
    @Override
    public int getCanNombres(String nombre) throws SQLException, Exception {
        int cantidad=0;
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        Query query;
        List list;
        query=session.createQuery("FROM InversionTipoDescripcion  E WHERE  E.itdNombre like :nombre");
        query.setParameter("nombre",nombre );
        list= query.list();   
        cantidad=list.size();
        return cantidad;
    }
    @Override
    public String insert(InversionTipoDescripcion inversionTipoDes)  throws SQLException ,Exception{
        
        String result=null;
           Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
           try {
               session.beginTransaction();
               session.save(inversionTipoDes);
               session.getTransaction().commit();
          } catch (Exception e) {
               
               e.printStackTrace();
                   
               session.getTransaction().rollback();
               result=e.getMessage();
           }
           return result;
    }

    @Override
    public String delete(Integer id) throws SQLException ,Exception {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        try {
            session.beginTransaction();
            inversionTipoDescripcion=(InversionTipoDescripcion)session.get(InversionTipoDescripcion.class, id);
            session.delete(inversionTipoDescripcion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(InversionTipoDescripcion inversionTipoDes) throws SQLException ,Exception {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.update(inversionTipoDes);
            session.getTransaction().commit();
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public InversionTipoDescripcion get(Integer id) throws SQLException ,Exception {
       
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();
       inversionTipoDescripcion = (InversionTipoDescripcion) session.get(InversionTipoDescripcion.class, id);
         session.getTransaction().commit();
        return inversionTipoDescripcion;
    }

    @Override
    public List<InversionTipoDescripcion> query1(String buscar) throws SQLException ,Exception {
        
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        session.beginTransaction();     
        query=session.createQuery("FROM InversionTipoDescripcion  E WHERE upper(E.itdNombre) like  :busqueda");  
        query.setParameter("busqueda","%"+buscar+"%");
        /* query =
            session.createQuery("FROM InversionTipoDescripcion  E WHERE E.itdNombre like  :busqueda  or E.itdId like :busqueda or E.itdDescripcion like :busqueda");
        query.setParameter("busqueda", "%" + buscar + "%"); */
        List list= query.list();
        session.getTransaction().commit();
        return list;
        
    }


    public void setInversionTipoDescripcion(InversionTipoDescripcion inversionTipoDescripcion) {
        this.inversionTipoDescripcion = inversionTipoDescripcion;
    }

    public InversionTipoDescripcion getInversionTipoDescripcion() {
        return inversionTipoDescripcion;
    }
}
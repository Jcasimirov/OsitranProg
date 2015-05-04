package com.ositran.daoimpl;

import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.ositran.dao.UsuarioDAO;
import com.ositran.model.Usuario;
import com.ositran.util.HibernateUtil;
import java.sql.SQLException;
import org.hibernate.Query;


@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

   Usuario usuario;

    @Override
    public String insert(Usuario usuario) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.save(usuario);
            session.getTransaction().commit();
        } 
        catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException{
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            Usuario usuario = (Usuario) session.get(Usuario.class, id);
            session.delete(usuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Usuario usuario)throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(usuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }
    

    @Override
    public Usuario get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Usuario usuario = (Usuario) session.get(Usuario.class, id);
        session.getTransaction().commit();
        return usuario;
    }

    @Override
    public List query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
         List list = session.createQuery("From Usuario o order by o.usuId asc").list();
        System.out.println(list.size());
        session.close();
        return list;
    }

    @Override
    public List<Usuario> UserSearch(String nomUserSearch) throws SQLException {
            Query query;
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            query =session.createQuery("FROM Usuario u WHERE lower(u.usuAlias) like lower(:busqueda) or lower(u.usuNombre) like lower(:busqueda) order by USU_ID asc");
            query.setParameter("busqueda", "%" + nomUserSearch + "%");
            return query.list();
        }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }


    @Override
    public List<Usuario> queryTD(int filtro) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().getCurrentSession();
        Query query;
        session.beginTransaction();
        query = session.createQuery("FROM Usuario  E WHERE upper(E.usuEsexterno)= :filtro1 and upper(E.usuEstado) <> 0");
        query.setParameter("filtro1",  filtro);
        List list = query.list();
        session.getTransaction().commit();
        return list;
    }
}

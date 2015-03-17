package com.ositran.daoimpl;

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
        session.beginTransaction();
        List list = session.createQuery("select o from Usuario o order by USU_ID asc").list();
        return list;
    }

    @Override
    public List<Usuario> UserSearch(String searchUsuario, String searchNombre, int nomTipoSearch) throws SQLException {
        
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            session.beginTransaction();
            Query query;
            if( nomTipoSearch<1  ){
                query=session.createQuery("FROM Usuario u WHERE lower(u.usuAlias) like lower(:busqueda1) and lower(u.usuNombre) like lower(:busqueda2) order by USU_ID asc");
                    query.setParameter("busqueda1", "%" + searchUsuario + "%");
                    query.setParameter("busqueda2", "%" + searchNombre + "%");
                }
            else if( nomTipoSearch>0 ){
                query=session.createQuery("FROM Usuario u WHERE lower(u.usuEsexterno) like lower(:busqueda3)order by USU_ID asc");
                query.setParameter("busqueda3",nomTipoSearch);
                }
            else{
            query = session.createQuery("FROM Usuario u WHERE lower(u.usuAlias) like lower(:busqueda1) and lower(u.usuNombre) like lower(:busqueda2)and lower(u.usuEsexterno) like lower(:busqueda3) order by USU_ID asc" );
            query.setParameter("busqueda1", "%" + searchUsuario + "%");
            query.setParameter("busqueda2", "%" + searchNombre + "%");
            query.setParameter("busqueda3",nomTipoSearch);
            }
            return query.list();
        }


    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }


}

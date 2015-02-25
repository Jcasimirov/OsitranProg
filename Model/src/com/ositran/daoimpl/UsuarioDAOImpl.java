package com.ositran.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.ositran.dao.UsuarioDAO;
import com.ositran.model.Usuario;
import javax.sql.DataSource;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public String insert(Usuario usuario) {
        String result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(usuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) {
        String result = null;
        Session session = sessionFactory.openSession();
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
    public String update(Usuario usuario) {
        String result = null;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(usuario);
            session.getTransaction().commit();
            logger.info("Usuario updated successfully, Usuario Details=" + usuario);
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public Usuario get(Integer id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Usuario usuario = (Usuario) session.get(Usuario.class, id);
        session.getTransaction().commit();
        return usuario;
    }

    @Override
    public List query() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List list = session.createQuery("select o from Usuario o").list();
        System.out.println("LISTA = " + list);
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List<Usuario> AllSearch(String searchUsuario) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM Usuario U WHERE lower(U.usuUsuario) like lower(:busqueda)");
        query.setParameter("busqueda","%"+searchUsuario+"%");
        List<Usuario> list= query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}

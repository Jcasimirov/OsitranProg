package com.ositran.daoimpl;

import com.ositran.dao.EmpresaSupervisoraDAO;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ositran.dao.InfraestructuraTipoDAO;
import com.ositran.dao.ModalidadConcesionDAO;
import com.ositran.model.EmpresaSupervisora;
import com.ositran.model.Event;
import com.ositran.model.Igv;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.model.ModalidadConcesion;
import com.ositran.model.hibernate.HibernateUtil;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.cfg.Configuration;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.xml.XmlBeanFactory;

import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class ModalidadConcesionDAOImpl implements ModalidadConcesionDAO {
    
        private JdbcTemplate jdbcTemplate;
        
        public void setDataSource(DataSource ds){
            this.jdbcTemplate=new JdbcTemplate(ds);
        }
	
	private static final Logger logger = LoggerFactory.getLogger(ModalidadConcesionDAOImpl.class);
        
        
        private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        
        List<ModalidadConcesion> list = null;
        

        
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
        
    public ModalidadConcesionDAOImpl() {
        super();
    }
    
    @Override
    public List<ModalidadConcesion> query() throws SQLException{
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        list= session.createQuery("select o from ModalidadConcesion o where o.mcoEstado<> 2").list();            
        System.out.println("LISTA = "+list);
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    @Override
    public int  ValidarNombre(String atributo) throws SQLException{
        Session session = sessionFactory.openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM ModalidadConcesion m WHERE upper(m.mcoNombre) like  upper(:busqueda) and mcoEstado<> 2");
        query.setParameter("busqueda",atributo);
        list= query.list();
        session.getTransaction().commit();
        session.close();
        return list.size();
    }
    
    @Override
    public int  ValidarNombreMod(String atributo, String NombreMod) throws SQLException{
        Session session = sessionFactory.openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM ModalidadConcesion m WHERE upper(m.mcoNombre) like  upper(:busqueda) and mcoEstado<> 2");
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
        
        Session session = sessionFactory.openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM ModalidadConcesion m WHERE upper(m.mcoNombre) like  upper(:busqueda) and mcoEstado<> 2");
        query.setParameter("busqueda","%"+atributo+"%");
        list= query.list();
        session.getTransaction().commit();
        session.close();
        return list;
        
    }

        @Override
        public String insert(ModalidadConcesion modalidadConcesion) throws SQLException{
            String result=null;
            Session session = sessionFactory.openSession();
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
            //Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Session session = sessionFactory.openSession();
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
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(modalidadConcesion);
            session.getTransaction().commit();
            logger.info("ModalidadConcesion updated successfully, ModalidadConcesion Details="+modalidadConcesion);
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
            //Session session=HibernateUtil.getSessionFactory().getCurrentSession();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            ModalidadConcesion modalidadConcesion=(ModalidadConcesion)session.get(ModalidadConcesion.class, id);
            session.getTransaction().commit();
            session.close();
            return modalidadConcesion;
        }

}

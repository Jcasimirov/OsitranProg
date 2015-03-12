package com.ositran.daoimpl;

import com.ositran.dao.EmpresaSupervisoraDAO;

import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import java.sql.SQLException;
import com.ositran.util.HibernateUtil;
import com.ositran.model.EmpresaSupervisora;

@Repository
public class EmpresaSupervisoraDAOImpl implements EmpresaSupervisoraDAO { 
     
        List<EmpresaSupervisora> list = null;    


    public EmpresaSupervisoraDAOImpl() {
        super();
    }
    
    @Override
    public List<EmpresaSupervisora> query() throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        list= session.createQuery("select o from EmpresaSupervisora o where o.supEstado<> 2").list();            
        System.out.println("LISTA = "+list);
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
    @Override
    public List<EmpresaSupervisora> FiltrarEmpSup(String nombre, String ruc) throws SQLException {
        
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();    
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM EmpresaSupervisora  E WHERE upper(E.supNombre) like  upper(:busqueda) and E.supNroDocumento like :busqueda2 and supEstado<> 2");
        query.setParameter("busqueda","%"+nombre+"%");
        query.setParameter("busqueda2","%"+ruc+"%");
        list= query.list();
        session.getTransaction().commit();
        session.close();
        return list;
        
    }
    
    @Override
    public int  ValidarNombre(String atributo) throws SQLException {
        
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM EmpresaSupervisora  E WHERE upper(E.supNombre) like  upper(:busqueda) and supEstado<> 2");
        query.setParameter("busqueda",atributo);
        list= query.list();
        session.getTransaction().commit();
        session.close();
        return list.size();        
    }
    
    @Override
    public int  ValidarRuc(String atributo,int documento) throws SQLException {
        
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM EmpresaSupervisora  E WHERE upper(E.supNroDocumento) like  upper(:busqueda) and E.tdoId like :busqueda2 and supEstado<> 2");
        query.setParameter("busqueda",atributo);
        query.setParameter("busqueda2",documento);
        list= query.list();
        session.getTransaction().commit();
        session.close();
        return list.size();        
    }
    
    @Override
    public int ValidarNombreMod(String atributo, String NombreMod) throws SQLException {
        
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM EmpresaSupervisora  E WHERE upper(E.supNombre) like  upper(:busqueda)  and supEstado<> 2");
        query.setParameter("busqueda",atributo);        
        list= query.list();
        for (int i = 0 ; i<list.size();i++){
            if (list.get(i).getSupNombre().equals(NombreMod)){
                list.remove(i);
            }
        }
        session.getTransaction().commit();
        session.close();
        return list.size();        
    }
    
    @Override
    public int ValidarRucMod(String atributo, String NombreRuc, int documento) throws SQLException {
        
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();    
        Query query;     
        query=session.createQuery("FROM EmpresaSupervisora  E WHERE upper(E.supNroDocumento) like  upper(:busqueda) and E.tdoId like :busqueda2 and supEstado<> 2");
        query.setParameter("busqueda",atributo);
        query.setParameter("busqueda2",documento);
        list= query.list();
        for (int i = 0 ; i<list.size();i++){
            if (list.get(i).getSupNroDocumento().equals(NombreRuc)){
                list.remove(i);
            }
        }
        session.getTransaction().commit();
        session.close();
        return list.size();        
    }


        @Override
        public String insert(EmpresaSupervisora empresaSupervisora) throws SQLException{
            String result=null;
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            try {
                session.beginTransaction();
                session.persist(empresaSupervisora);
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
                EmpresaSupervisora empresaSupervisora=(EmpresaSupervisora)session.get(EmpresaSupervisora.class, id);
                session.delete(empresaSupervisora);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                result=e.getMessage();
            }
            session.close();
            return result;
        }
        
    @Override
    public String update(EmpresaSupervisora empresaSupervisora) throws SQLException{
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(empresaSupervisora);
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
        public EmpresaSupervisora get(Integer id) throws SQLException{
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            session.beginTransaction();
            EmpresaSupervisora empresaSupervisora=(EmpresaSupervisora)session.get(EmpresaSupervisora.class, id);
            session.getTransaction().commit();
            session.close();
            return empresaSupervisora;
        }

}

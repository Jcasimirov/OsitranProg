package com.ositran.daoimpl;


import com.ositran.dao.InvTipoRevisionDAO;
import com.ositran.model.InvTipoRevision;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import java.sql.SQLException;
import com.ositran.util.HibernateUtil;


@Repository
public class InvTipoRevisionDAOImpl implements InvTipoRevisionDAO { 
       


    public InvTipoRevisionDAOImpl() {
        super();
    }
    
   
        @Override
        public List<InvTipoRevision> ListarAprobaciones() throws SQLException{
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            session.beginTransaction();
            List<InvTipoRevision> list= session.createQuery("select o from InvTipoRevision o").list();            
            System.out.println("LISTA = "+list);
            session.getTransaction().commit();
            session.close();
            return list;
        }
        
}

package com.ositran.daoimpl;

import com.ositran.dao.DatosStdDAO;
import com.ositran.dao.EmpresaSupervisoraDAO;

import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import java.sql.SQLException;
import com.ositran.util.HibernateUtil;
import com.ositran.model.ViewTdInternos;

@Repository
public class DatosStdDAOImpl implements DatosStdDAO { 
       


    public DatosStdDAOImpl() {
        super();
    }
    
   
        @Override
        public ViewTdInternos BuscaStd(Integer año, String nro) throws SQLException{
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            ViewTdInternos vista = null;
            try {
            session.beginTransaction();
            Query query;  
            
                query = session.createQuery("FROM ViewTdInternos v WHERE v.anyo like :busqueda1 and v.nroRegistro like :busqueda2");
                query.setParameter("busqueda1",año);
                query.setParameter("busqueda2",nro);
            List sResult = query.list();
            if (sResult.size() > 0) {
            vista  = (ViewTdInternos)sResult.get(0);
            session.getTransaction().commit();
            }       
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
            return vista;
        }

}

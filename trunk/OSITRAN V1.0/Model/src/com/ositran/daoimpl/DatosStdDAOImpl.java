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
        public ViewTdInternos BuscaStd(Integer a�o, String nro) throws SQLException{
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            ViewTdInternos vista = new ViewTdInternos();
            try {
            session.beginTransaction();
                System.out.println("go1");
            Query query;  
                System.out.println("go2");
                query = session.createQuery("FROM ViewTdInternos v WHERE v.anyo like :busqueda1 and v.nroRegistro like :busqueda2");
                query.setParameter("busqueda1",a�o);
                System.out.println("go3");
                query.setParameter("busqueda2",nro);
                System.out.println("go4");
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

package com.ositran.daoimpl;

import com.ositran.dao.InvDAO;
import com.ositran.model.Inv;
import com.ositran.model.InvReajuste;
import com.ositran.model.InvReconocimiento;
import com.ositran.model.ValorizacionInversionAvance;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class InvDAOImpl implements InvDAO {
    public InvDAOImpl() {
        super();
    }

    @Override
    public List<Inv> query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list=session.createQuery("from Inv cc where cc.invEstado != 0").list();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public String insert(Inv inv) throws SQLException {
        String result=null;
        System.out.println("## INI INSERT INV");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(inv);
            session.getTransaction().commit();
            System.out.println("## Insert OK");
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            System.out.println("## Insert rollback");
        }
        System.out.println("## FIN INSERT INV");
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        String result=null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            Inv inv=(Inv)session.get(Inv.class, id);
            session.delete(inv);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Inv inv) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(inv);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public Inv get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

        Inv inv = (Inv) session.get(Inv.class, id);
        session.close();
        return inv;
    }
    
    @Override
    public List<Inv> getInvsAvance(Integer tiaNumero) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Query query; 
        query = session.createQuery("FROM Inv cc where cc.invEstado <> 0 and cc.tiaNumero = :busqueda1 order by invId DESC");
        query.setParameter("busqueda1",tiaNumero);            
        List<Inv> list = query.list();
        session.getTransaction().commit();
        return list;        
                          
    }  
    
    @Override
    public String insertDeclaracion(Inv inv, List<InvReconocimiento> listInvReconocimiento,List<InvReajuste> listInvReajuste) throws SQLException{
                
        String result=null;
        System.out.println("## INI INSERT DECLARACION");
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();            
            session.persist(inv);
            System.out.println("insert INV OK");
            
            for(InvReconocimiento invReconocimiento:listInvReconocimiento){
                session.persist(invReconocimiento);
            }
            System.out.println("insert RECONOCIMIENTO OK");
            
            for(InvReajuste invReajuste:listInvReajuste){
                session.persist(invReajuste);
            }
            System.out.println("insert REAJUSTE OK");
                        
            ValorizacionInversionAvance valorizacionInversionAvance = (ValorizacionInversionAvance) session.get(ValorizacionInversionAvance.class, inv.getTiaNumero());
            valorizacionInversionAvance.setIaeId(4);
            session.update(valorizacionInversionAvance);
            System.out.println("update AVANCE_INV OK");
            session.getTransaction().commit();
            System.out.println("## Insert DECLARACION OK");
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            System.out.println("## Insert DECLARACION ROLLBACK");;
        }
        System.out.println("## FIN INSERT INV");
        return result;
    }  
    
    public Inv obtenerInversion(Integer invId, Integer tiaNumero) throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();

        Query query; 
        query = session.createQuery("FROM Inv cc where cc.invEstado <> 0 and cc.invId = :idinversion and cc.tiaNumero = :tianumero  order by invId DESC");
        query.setParameter("idinversion",invId);     
        query.setParameter("tianumero",tiaNumero);            
        Inv inv = (Inv)query.uniqueResult();
        session.close();
        return inv;        
              
        
        
    }   
}

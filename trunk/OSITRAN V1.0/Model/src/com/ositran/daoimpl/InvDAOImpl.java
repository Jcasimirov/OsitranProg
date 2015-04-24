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
            System.out.println("inv.getInvEstado(): " + inv.getInvEstado());
            System.out.println("inv.getInvEstadoReconocimiento(): " + inv.getInvEstadoReconocimiento());
            System.out.println("inv.getInvFechaEmisionDocFomalizacion(): " + inv.getInvFechaEmisionDocFomalizacion());
            System.out.println("inv.getInvFechaEmisionInforme(): " + inv.getInvFechaEmisionInforme());
            System.out.println("inv.getInvFechaEmisionOficio(): " + inv.getInvFechaEmisionOficio());
            System.out.println("inv.getInvId(): " + inv.getInvId());
            System.out.println("inv.getInvMontoTipoCambio(): " + inv.getInvMontoTipoCambio());
            System.out.println("inv.getInvMontoTotalAprobado(): " + inv.getInvMontoTotalAprobado());
            System.out.println("inv.getInvMontoTotalReajuste(): " + inv.getInvMontoTotalReajuste());
            System.out.println("inv.getInvNota(): " + inv.getInvNota());
            System.out.println("inv.getInvNroDocFormalizacion(): " + inv.getInvNroDocFormalizacion());
            System.out.println("inv.getInvNumeroInforme(): " + inv.getInvNumeroInforme());
            System.out.println("inv.getInvNumeroOficio(): " + inv.getInvNumeroOficio());
            System.out.println("inv.getInvObservaciones(): " + inv.getInvObservaciones());
            System.out.println("inv.getInvRegSalidaInforme(): " + inv.getInvRegSalidaInforme());
            System.out.println("inv.getInvRegSalidaOficio(): " + inv.getInvRegSalidaOficio());
            System.out.println("inv.getMonId(): " + inv.getMonId());
            System.out.println("inv.getTiaNumero(): " + inv.getTiaNumero());
            
            session.beginTransaction();            
            session.persist(inv);
            System.out.println("insert INV OK");
            
            System.out.println("--------------------");
            System.out.println("------INI invReconocimiento ------");
            for(InvReconocimiento invReconocimiento:listInvReconocimiento){
                System.out.println("---- FOR -----");
                System.out.println("invReconocimiento.getCsiId(): " + invReconocimiento.getCsiId() );
                System.out.println("invReconocimiento.getIadId(): " + invReconocimiento.getIadId() );
                System.out.println("invReconocimiento.getInfId(): " + invReconocimiento.getInfId() );
                System.out.println("invReconocimiento.getIreEstado(): " + invReconocimiento.getIreEstado() );
                System.out.println("invReconocimiento.getIreFechaRegistro: " + invReconocimiento.getIreFechaRegistro() );
                System.out.println("invReconocimiento.getIreId(): " + invReconocimiento.getIreId() );
                System.out.println("invReconocimiento.getIvrMontoAprobado(): " + invReconocimiento.getIvrMontoAprobado() );
                System.out.println("invReconocimiento.getIvrMontoPresentado(): " + invReconocimiento.getIvrMontoPresentado() );
                System.out.println("invReconocimiento.getMonId(): " + invReconocimiento.getMonId() );
                System.out.println("invReconocimiento.getTiaNumero(): " + invReconocimiento.getTiaNumero() );
                System.out.println("invReconocimiento.getTinId(): " + invReconocimiento.getTinId() );
                session.persist(invReconocimiento);
            }
            System.out.println("--------------------");
            System.out.println("insert RECONOCIMIENTO OK");
            
            System.out.println("--------------------");
            System.out.println("------INI invReajuste ------");
            for(InvReajuste invReajuste:listInvReajuste){
                System.out.println("---- FOR -----");
                System.out.println("invReajuste.getCsiId(): " + invReajuste.getCsiId() );
                System.out.println("invReajuste.getIadId(): " + invReajuste.getIadId() );
                System.out.println("invReajuste.getInfId(): " + invReajuste.getInfId() );
                System.out.println("invReajuste.getIrjId(): " + invReajuste.getIrjId() );
                System.out.println("invReajuste.getIrjMontoAprobado(): " + invReajuste.getIrjMontoAprobado() );
                System.out.println("invReajuste.getIrjMontoReajuste(): " + invReajuste.getIrjMontoReajuste() );
                System.out.println("invReajuste.getMonId(): " + invReajuste.getMonId() );
                System.out.println("invReajuste.getTiaNumero(): " + invReajuste.getTiaNumero() );
                System.out.println("invReajuste.getTinId(): " + invReajuste.getTinId() );
                session.persist(invReajuste);
            }
            System.out.println("--------------------");
            System.out.println("insert REAJUSTE OK");
                        
            ValorizacionInversionAvance valorizacionInversionAvance = (ValorizacionInversionAvance) session.get(ValorizacionInversionAvance.class, inv.getTiaNumero());
            valorizacionInversionAvance.setIaeId(4);
            System.out.println("valorizacionInversionAvance.getConId(): " + valorizacionInversionAvance.getConId() );
            System.out.println("valorizacionInversionAvance.getCsiId(): " + valorizacionInversionAvance.getCsiId() );
            System.out.println("valorizacionInversionAvance.getIaeId(): " + valorizacionInversionAvance.getIaeId() );
            System.out.println("valorizacionInversionAvance.getInvId(): " + valorizacionInversionAvance.getInvId() );
            System.out.println("valorizacionInversionAvance.getCsiId(): " + valorizacionInversionAvance.getCsiId() );
            System.out.println("valorizacionInversionAvance.getCsiId(): " + valorizacionInversionAvance.getCsiId() );
            System.out.println("valorizacionInversionAvance.getCsiId(): " + valorizacionInversionAvance.getCsiId() );
            System.out.println("valorizacionInversionAvance.getCsiId(): " + valorizacionInversionAvance.getCsiId() );
            System.out.println("valorizacionInversionAvance.getCsiId(): " + valorizacionInversionAvance.getCsiId() );
            System.out.println("valorizacionInversionAvance.getCsiId(): " + valorizacionInversionAvance.getCsiId() );
            System.out.println("valorizacionInversionAvance.getCsiId(): " + valorizacionInversionAvance.getCsiId() );
            System.out.println("valorizacionInversionAvance.getCsiId(): " + valorizacionInversionAvance.getCsiId() );
            
            session.update(valorizacionInversionAvance);
            System.out.println("update AVANCE_INV OK");
            session.getTransaction().commit();
            System.out.println("## Insert DECLARACION OK");
            
        } catch (Exception e) {
            session.getTransaction().rollback();
            result=e.getMessage();
            e.printStackTrace();
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

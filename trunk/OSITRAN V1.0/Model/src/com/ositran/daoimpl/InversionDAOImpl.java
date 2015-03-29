package com.ositran.daoimpl;

import com.ositran.dao.InversionDAO;
import com.ositran.model.Infraestructura;
import com.ositran.model.Inversion;

import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class InversionDAOImpl implements InversionDAO {
    public InversionDAOImpl() {
        super();
    }

    @Override
    public List<Inversion> query1(Infraestructura infraestructura,int codigoContrato) throws SQLException {
        System.out.println("llego al DAO");
        int codigoInfraestructura=infraestructura.getInfId();
        int codigoTipoInfra=infraestructura.getTinId();
        int codigoConcesion=infraestructura.getCsiId();
    
        
        Query query;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        query =session.createQuery("FROM Inversion  E WHERE upper(E.infId) = :filtro1 and upper(E.tinId) = :filtro2 and upper(E.csiId)= :filtro3 and upper(E.conId) =:filtro4");
        query.setParameter("filtro1",codigoInfraestructura);
        query.setParameter("filtro2",codigoTipoInfra);
        query.setParameter("filtro3",codigoConcesion);
        query.setParameter("filtro4",codigoContrato);
       System.out.println("tanaño de la listra");
        System.out.println( query.list().size());
        return query.list();
    }
    
    @Override
    public List<Inversion> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(Inversion inversion) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(Inversion inversion) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public Inversion get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

  
}

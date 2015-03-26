package com.ositran.daoimpl;

import com.ositran.dao.ConceptoInversionDAO;
import com.ositran.model.ConceptoInversion;
import com.ositran.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;

public class ConceptoInversionDAOImpl implements ConceptoInversionDAO {
    //ConceptoInversion conceptoInversion;

    public List<ConceptoInversion> query() throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List<ConceptoInversion> list = session.createQuery("select o from ConceptoInversion o").list();
        session.getTransaction().commit();
        session.close();        
        return list;
    }

}

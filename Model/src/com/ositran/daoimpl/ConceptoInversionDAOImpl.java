package com.ositran.daoimpl;

import com.ositran.dao.ConceptoInversionDAO;
import com.ositran.model.ConceptoInversion;
import com.ositran.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ConceptoInversionDAOImpl implements ConceptoInversionDAO {
    //ConceptoInversion conceptoInversion;

    public List<ConceptoInversion> query() throws SQLException{
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List<ConceptoInversion> list = session.createQuery("select o from ConceptoInversion o").list();
            tx.commit();
            return list;
        } catch (Exception e) {
            if (tx!=null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }

}

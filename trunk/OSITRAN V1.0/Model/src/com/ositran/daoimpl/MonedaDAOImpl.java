import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import com.ositran.dao.MonedaDAO;
import com.ositran.daoimpl.MenDAOImpl;
import com.ositran.model.Moneda;
import com.ositran.util.HibernateUtil;
import java.sql.SQLException;
import org.hibernate.Query;

public class MonedaDAOImpl implements MonedaDAO{
       

    Moneda moneda;
    
    public MonedaDAOImpl() {
        super();
    }
    @Override
    public String insert(Moneda moneda) throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(moneda);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException{
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            Moneda moneda = (Moneda) session.get(Moneda.class, id);
            session.delete(moneda);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }

    @Override
    public String update(Moneda moneda)throws SQLException {
        String result = null;
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        try {
            session.beginTransaction();
            session.update(moneda);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = e.getMessage();
        }
        return result;
    }
    

    @Override
    public Moneda get(Integer id) throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        Moneda moneda = (Moneda) session.get(Moneda.class, id);
        session.getTransaction().commit();
        return moneda;
    }

    @Override
    public List query() throws SQLException {
        Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
        session.beginTransaction();
        List list = session.createQuery("select o from Moneda o order by MON_ID asc").list();
        return list;
    }

    @Override
    public List<Moneda> MonedaSearch(String searchMoneda, String searchAbreviatura) throws SQLException {
        
            Session session = HibernateUtil.getSessionAnnotationFactory().openSession();
            session.beginTransaction();
            Query query;
            if(searchMoneda == null && searchMoneda.isEmpty() && searchAbreviatura!= null && !searchAbreviatura.isEmpty()){
                query=session.createQuery("FROM Moneda u WHERE lower(u.monNombre) like lower(:busqueda1) and lower(u.monAbreviatura) like lower(:busqueda2) order by MON_ID asc");                    
                    query.setParameter("busqueda2", "%" + searchAbreviatura + "%");
                }
            else if( searchMoneda != null && !searchMoneda.isEmpty() && searchAbreviatura == null && searchAbreviatura.isEmpty()){
                query=session.createQuery("FROM Moneda u WHERE lower(u.monNombre) like lower(:busqueda1)  order by MON_ID asc");
                        query.setParameter("busqueda1", "%" + searchMoneda + "%");
                }
            else if (searchMoneda != null && !searchMoneda.isEmpty() && searchAbreviatura != null && !searchAbreviatura.isEmpty()){
                query=session.createQuery("FROM Moneda u WHERE  and lower(u.monAbreviatura) like lower(:busqueda2) order by MON_ID asc");                    
                    query.setParameter("busqueda2", "%" + searchAbreviatura + "%");
                query.setParameter("busqueda1", "%" + searchMoneda + "%");                
            }else{
                    return null;
                }
            return query.list();
        }
}

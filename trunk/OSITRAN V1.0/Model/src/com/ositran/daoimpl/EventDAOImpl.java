package com.ositran.daoimpl;

import com.ositran.model.Event;
import com.ositran.dao.EventDAO;
import com.ositran.exception.EventException;
import com.ositran.exception.EventNotFoundException;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class EventDAOImpl extends HibernateDaoSupport implements EventDAO {
    
    public EventDAOImpl() {
        super();
    }
    private HibernateTemplate hibernateTemplate;
    
   // @Autowired
    private SessionFactory sessionFactory;// = new Configuration().configure().buildSessionFactory();

    @Autowired(required=true)
    private EventDAO userDao;

    /*
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }*/


    public Event getEvent(final int id) {
        HibernateCallback callback = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return session.load(Event.class, id);

            }
        };
        return (Event) hibernateTemplate.execute(callback);

    }
    
    /*@Override
    public void actualizarEvent(Event event) throws EventException {
        event.setTitle("title");
        getHibernateTemplate().save(event);
    }

    @Override
    public void borrarEvent(Event event) throws EventException {
        event.setTitle("title");
        getHibernateTemplate().save(event);
    }*/

    ///@Transactional
    public void insertarEvent(Event event) throws EventException  {
        Session sesion=this.sessionFactory.getCurrentSession();
        sesion.persist(event);
        /*
        try{
            Session session=sessionFactory.openSession();
            Transaction tx=session.beginTransaction();
            session.persist(event);
            session.flush();
            session.getTransaction().commit();
            tx.commit();
            session.close();            
        }catch(HibernateException he){//DataAccessException
            //throws 
                new EventException(event.getId(), he.getCause());
        }
*/
        /*
        HibernateCallback callback = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.saveOrUpdate(event);
                return null;
            }
        };
        hibernateTemplate.execute(callback);*/
        //getHibernateTemplate().save(event);        
    }
    
    @Transactional
    public Event obtenerEvent(long idEvent) throws EventException{
        Event event=null;
        try{
            Session session=sessionFactory.openSession();
            event=(Event)session.get(Event.class, idEvent);
            session.close();
        }catch(HibernateException he){
            throw new EventException(idEvent, he.getCause());
        }
        if(event==null){
            System.out.println("null");
            //throws new EventNotFoundException(idEvent);
        }
        return event;
    }

    @Override
    public void buscarEvent(Event event) {
    }

    @Override
    public void modificarEvent(Event event) {
    }

    @Override
    public void eliminarEvent(Event event) {
    }
}

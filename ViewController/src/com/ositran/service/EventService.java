package com.ositran.service;

import com.ositran.exception.EventException;
import com.ositran.model.Event;

public interface EventService {
    public void insertarEvent(Event event) throws EventException;
    public Event obtenerEvent(long idEvent) throws EventException;
    public void buscarEvent(Event event) throws EventException;
    public void modificarEvent(Event event) throws EventException;
    public void eliminarEvent(Event event) throws EventException;
    
    /*
    public void actualizarEvent(Event event) throws EventException{
        try{
            hibernateTemplate.getHibernateTemplate().update(event);
        }catch(DataAccessException dae){
            throw new EventException(event.getId(), dae);
        }
    }
    public void borrarEvent(Event event) throws EventException{
        try{
            getHibernateTemplate().delete(event);
        }catch(DataAccessException dae){
            throw new EventException(event.getId(), dae);
        }
    }    
    */    
}

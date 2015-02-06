package com.ositran.serviceimpl;

import com.ositran.dao.EventDAO;
import com.ositran.exception.EventException;
import com.ositran.model.Event;
import com.ositran.service.EventService;

public class EventServiceImpl implements EventService{
    
    EventDAO eventDAO;
    
    public EventServiceImpl() {
        super();
    }

    @Override
    public void insertarEvent(Event event) throws EventException{
        eventDAO.insertarEvent(event);
    }

    @Override
    public Event obtenerEvent(long idEvent) throws EventException {
        return eventDAO.obtenerEvent(idEvent);
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

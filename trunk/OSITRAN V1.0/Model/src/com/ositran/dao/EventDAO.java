package com.ositran.dao;

import com.ositran.exception.EventException;
import com.ositran.model.Event;

public interface EventDAO {
    public void insertarEvent(Event event) throws EventException;
    public Event obtenerEvent(long idEvent) throws EventException;
    public void buscarEvent(Event event) throws EventException;
    public void modificarEvent(Event event) throws EventException;
    public void eliminarEvent(Event event) throws EventException;
}

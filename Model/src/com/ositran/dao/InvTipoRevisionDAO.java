package com.ositran.dao;

import com.ositran.model.InvTipoRevision;
import com.ositran.util.HibernateUtil;

import java.sql.SQLException;

import java.util.List;

import org.hibernate.Session;


public interface InvTipoRevisionDAO {       
    public List<InvTipoRevision> ListarAprobaciones() throws SQLException;         
}

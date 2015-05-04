package com.ositran.dao;

import com.ositran.model.InversionTipo;

import com.ositran.model.ValorizacionInversionAvance;

import java.sql.SQLException;

import java.util.List;

public interface ValorizacionInversionAvanceDAO {
    
    public List<ValorizacionInversionAvance> query()throws SQLException ,Exception;
    public List<ValorizacionInversionAvance> query1(int codigoContrato)throws SQLException ,Exception;
    public List<ValorizacionInversionAvance> queryDerivarInversion(int codigoContrato, int contratoCompromiso,int estado)throws SQLException ,Exception;
    public int insert(ValorizacionInversionAvance valorizacionInversionAvance)throws SQLException ,Exception;
    public String delete(Integer id)throws SQLException ,Exception;
    public String update(ValorizacionInversionAvance valorizacionInversionAvance)throws SQLException ,Exception;
    public ValorizacionInversionAvance get(Integer id)throws SQLException ,Exception;
}

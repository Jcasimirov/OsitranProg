package com.ositran.dao;

import com.ositran.model.InversionTipo;
import com.ositran.model.ValorizacionInversionAvance;

import com.ositran.model.ValorizacionInversionAvanceDetalle;

import java.sql.SQLException;

import java.util.List;

public interface ValorizacionInversionAvanceDetalleDAO {
    public List<ValorizacionInversionAvanceDetalle> query()throws SQLException ,Exception;
    public List<ValorizacionInversionAvanceDetalle> query1(int codigoValorizacion)throws SQLException ,Exception;
    public String insert(ValorizacionInversionAvanceDetalle valorizacionInversionAvanceDetalle)throws SQLException ,Exception;
    public String delete(Integer id)throws SQLException ,Exception;
    public String update(ValorizacionInversionAvanceDetalle valorizacionInversionAvanceDetalle)throws SQLException ,Exception;
    public ValorizacionInversionAvanceDetalle get(Integer id)throws SQLException ,Exception;
    public List<ValorizacionInversionAvanceDetalle> getInvAvanceDetallesInvAvance(Integer tiaNumero) throws SQLException, Exception ;
}

package com.ositran.dao;


import com.ositran.model.Inv;
import com.ositran.model.InvAvn;
import com.ositran.model.InvReajuste;
import com.ositran.model.InvReconocimiento;

import java.sql.SQLException;

import java.util.List;

public interface InvDAO {
    public List<Inv> query() throws SQLException;
    public String insert(Inv inv) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(Inv inv) throws SQLException;
    public Inv get(Integer id) throws SQLException;
    public List<Inv> getInvsAvance(Integer tiaNumero) throws SQLException;
    public String insertDeclaracion(InvAvn invAvn,Inv inv, List<InvReconocimiento> listInvReconocimiento,List<InvReajuste> listInvReajuste) throws SQLException;
    public Inv obtenerInversion(Integer tiaNumero) throws SQLException;
}

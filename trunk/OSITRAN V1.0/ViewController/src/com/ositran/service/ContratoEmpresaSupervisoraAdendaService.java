package com.ositran.service;

import com.ositran.vo.bean.ContratoSupervisoraAdendaVO;
import com.ositran.vo.bean.EmpresaSupervisoraVO;

import com.ositran.vo.bean.ValorizacionInversionAvanceDetalleVO;

import java.sql.SQLException;

import java.util.List;

public interface ContratoEmpresaSupervisoraAdendaService {
    
    public List<ContratoSupervisoraAdendaVO> query() throws SQLException;
    public String insert(ContratoSupervisoraAdendaVO contratoSupervisoraAdendaVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public List<ContratoSupervisoraAdendaVO> getContratoSupervisoraAdenda(Integer cpsNroDeContrato) throws SQLException ,Exception ;
}

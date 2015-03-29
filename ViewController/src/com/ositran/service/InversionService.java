package com.ositran.service;

import com.ositran.model.Infraestructura;
import com.ositran.vo.bean.InfraestructuraVO;
import com.ositran.vo.bean.InversionVO;

import java.sql.SQLException;

import java.util.List;

public interface InversionService {
    public List<InversionVO> query() throws SQLException;
    public List<InversionVO> query1(Infraestructura infraestructura,int codigoContrato) throws SQLException;
    public String insert(InversionVO inversionVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(InversionVO inversionVO) throws SQLException;
    public InversionVO get(Integer id) throws SQLException;
}

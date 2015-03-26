package com.ositran.service;

import com.ositran.vo.bean.ContratoPenalidadEstadoVO;

import java.sql.SQLException;

import java.util.List;

public interface ContratoPenalidadEstadoService {
    public List<ContratoPenalidadEstadoVO> query() throws SQLException;
    public String insert(ContratoPenalidadEstadoVO contratoPenalidadEstadoVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoPenalidadEstadoVO contratoPenalidadEstadoVO) throws SQLException;
    public ContratoPenalidadEstadoVO get(Integer id) throws SQLException;
}

package com.ositran.serviceimpl;

import com.ositran.service.ContratoPenalidadEstadoService;
import com.ositran.vo.bean.ContratoPenalidadEstadoVO;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoPenalidadEstadoServiceImpl implements ContratoPenalidadEstadoService {
    public ContratoPenalidadEstadoServiceImpl() {
        super();
    }

    @Override
    public List<ContratoPenalidadEstadoVO> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoPenalidadEstadoVO contratoPenalidadEstadoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoPenalidadEstadoVO contratoPenalidadEstadoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoPenalidadEstadoVO get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}

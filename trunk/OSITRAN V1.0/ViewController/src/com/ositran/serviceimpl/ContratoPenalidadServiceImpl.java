package com.ositran.serviceimpl;

import com.ositran.service.ContratoPenalidadService;
import com.ositran.vo.bean.ContratoPenalidadVO;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoPenalidadServiceImpl implements ContratoPenalidadService {
    public ContratoPenalidadServiceImpl() {
        super();
    }

    @Override
    public List<ContratoPenalidadVO> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoPenalidadVO contratoPenalidadVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoPenalidadVO contratoPenalidadVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoPenalidadVO get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}

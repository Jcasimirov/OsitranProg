package com.ositran.serviceimpl;

import com.ositran.service.ContratoPpoService;
import com.ositran.vo.bean.ContratoPpoVO;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoPpoServiceImpl implements ContratoPpoService {
    public ContratoPpoServiceImpl() {
        super();
    }

    @Override
    public List<ContratoPpoVO> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoPpoVO contratoPpoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoPpoVO contratoPpoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoPpoVO get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}

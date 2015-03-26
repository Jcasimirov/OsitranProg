package com.ositran.serviceimpl;

import com.ositran.service.ContrartoCompromisoService;
import com.ositran.vo.bean.ContratoCompromisoVO;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContrartoCompromisoServiceImpl implements ContrartoCompromisoService {
    public ContrartoCompromisoServiceImpl() {
        super();
    }

    @Override
    public List<ContratoCompromisoVO> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoCompromisoVO contratoCompromisoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoCompromisoVO contratoCompromisoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoCompromisoVO get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}

package com.ositran.serviceimpl;

import com.ositran.service.ContratoCaoService;
import com.ositran.vo.bean.ContratoCaoVO;

import java.sql.SQLException;

import java.util.Collections;
import java.util.List;

public class ContratoCaoServiceImpl implements ContratoCaoService {
    public ContratoCaoServiceImpl() {
        super();
    }

    @Override
    public List<ContratoCaoVO> query() throws SQLException {
        // TODO Implement this method
        return Collections.emptyList();
    }

    @Override
    public String insert(ContratoCaoVO contratoCaoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String delete(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public String update(ContratoCaoVO contratoCaoVO) throws SQLException {
        // TODO Implement this method
        return null;
    }

    @Override
    public ContratoCaoVO get(Integer id) throws SQLException {
        // TODO Implement this method
        return null;
    }
}

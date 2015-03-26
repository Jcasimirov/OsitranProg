package com.ositran.service;

import com.ositran.vo.bean.ContratoPpoVO;

import java.sql.SQLException;

import java.util.List;

public interface ContratoPpoService {
    public List<ContratoPpoVO> query() throws SQLException;
    public String insert(ContratoPpoVO contratoPpoVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoPpoVO contratoPpoVO) throws SQLException;
    public ContratoPpoVO get(Integer id) throws SQLException;
}

package com.ositran.service;

import com.ositran.vo.bean.PeriodoVO;

import java.sql.SQLException;

import java.util.List;

public interface PeriodoService {
    public List<PeriodoVO> query() throws SQLException;
    public String insert(PeriodoVO periodoVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(PeriodoVO periodoVO) throws SQLException;
    public PeriodoVO get(Integer id) throws SQLException;
}

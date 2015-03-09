package com.ositran.service;

import com.ositran.vo.bean.IgvVO;

import java.sql.SQLException;

import java.util.List;

public interface IgvService {
    public List<IgvVO> query() throws SQLException;
    public String insert(IgvVO igvVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(IgvVO igvVO) throws SQLException;
    public IgvVO get(Integer id) throws SQLException;
}

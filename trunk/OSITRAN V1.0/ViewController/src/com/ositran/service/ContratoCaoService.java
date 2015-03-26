package com.ositran.service;



import com.ositran.vo.bean.ContratoCaoVO;

import java.sql.SQLException;

import java.util.List;

public interface ContratoCaoService {
    public List<ContratoCaoVO> query() throws SQLException;
    public String insert(ContratoCaoVO contratoCaoVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoCaoVO contratoCaoVO) throws SQLException;
    public ContratoCaoVO get(Integer id) throws SQLException;
}

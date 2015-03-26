package com.ositran.service;

import com.ositran.vo.bean.ContratoPenalidadVO;

import java.sql.SQLException;
import java.util.List;

public interface ContratoPenalidadService {
    public List<ContratoPenalidadVO> query() throws SQLException;
    public String insert(ContratoPenalidadVO contratoPenalidadVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ContratoPenalidadVO contratoPenalidadVO) throws SQLException;
    public ContratoPenalidadVO get(Integer id) throws SQLException;
}

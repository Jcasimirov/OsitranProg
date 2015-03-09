package com.ositran.service;

import com.ositran.vo.bean.InfraestructuraVO;


import java.sql.SQLException;

import java.util.List;


public interface InfraestructuraService {
    public List<InfraestructuraVO> query()throws SQLException;
    public String insert(InfraestructuraVO infraestructuraVO)throws SQLException;
    public String delete(Integer id);
    public String update(InfraestructuraVO infraestructuraVO)throws SQLException;
    public InfraestructuraVO get2(Integer id)throws SQLException;
    public List<InfraestructuraVO> query1(Integer CodigoC)throws SQLException;
   
}

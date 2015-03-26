package com.ositran.service;

import com.ositran.vo.bean.AdendaTipoVO;

import java.sql.SQLException;

import java.util.List;

public interface AdendaTipoService {
    public List<AdendaTipoVO> query() throws SQLException;
    public String insert(AdendaTipoVO adendaTipoVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(AdendaTipoVO adendaTipoVO) throws SQLException;
    public AdendaTipoVO get(Integer id) throws SQLException;
}

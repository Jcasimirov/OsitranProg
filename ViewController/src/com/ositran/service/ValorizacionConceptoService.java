package com.ositran.service;

import com.ositran.model.InvReajuste;
import com.ositran.vo.bean.ValorizacionConceptoVO;

import java.sql.SQLException;

import java.util.List;

public interface ValorizacionConceptoService {
    public List<ValorizacionConceptoVO> query() throws SQLException;
    public String insert(ValorizacionConceptoVO valorizacionConceptoVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ValorizacionConceptoVO valorizacionConceptoVO) throws SQLException;
    public ValorizacionConceptoVO get(Integer id) throws SQLException;
}

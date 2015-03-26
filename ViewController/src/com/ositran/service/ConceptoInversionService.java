package com.ositran.service;

import com.ositran.vo.bean.ConceptoInversionVO;

import java.sql.SQLException;

import java.util.List;

public interface ConceptoInversionService {
    public List<ConceptoInversionVO> query() throws SQLException;
}

package com.ositran.service;

import com.ositran.vo.bean.InvAvnEstadoVO;

import java.sql.SQLException;

import java.util.List;

public interface InversionAvanceEstadoService {
    public List<InvAvnEstadoVO> query() throws SQLException ;
}

package com.ositran.service;

import com.ositran.model.InvReconocimiento;
import com.ositran.vo.bean.InvReconocimientoVO;

import java.sql.SQLException;

import java.util.List;

public interface InvReconocimientoService {
    public List<InvReconocimientoVO> query() throws SQLException;

    public String insert(InvReconocimientoVO invReconocimiento) throws SQLException;

    public String delete(Integer id) throws SQLException;

    public String update(InvReconocimientoVO invReconocimiento) throws SQLException;

    public InvReconocimiento get(Integer id) throws SQLException;

    public List<InvReconocimientoVO> getInvReconocimientosAvance(Integer invId) throws SQLException;
}

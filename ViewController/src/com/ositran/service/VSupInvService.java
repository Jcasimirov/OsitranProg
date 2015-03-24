package com.ositran.service;

import com.ositran.vo.bean.VSupInvVO;
import com.ositran.vo.bean.VEmpSupVO;

import java.sql.SQLException;

import java.util.List;

public interface VSupInvService {
    public List<VSupInvVO> buscarCoordinadorInSitu(int codTipoInfraestructura) throws SQLException;
}


package com.ositran.service;

import com.ositran.vo.bean.SupervisorInversionesVO;
import java.sql.SQLException;

import java.util.List;


public interface SupervisorInversionesService {
    public List<SupervisorInversionesVO> buscarCoordinadorInSitu(int codTipoInfraestructura) throws SQLException;
}
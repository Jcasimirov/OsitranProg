
package com.ositran.service;

import com.ositran.vo.bean.SupervisorInversionesVO;

import com.ositran.vo.bean.TipoInversionVO;

import java.sql.SQLException;

import java.util.List;


public interface SupervisorInversionesService {
    public List<SupervisorInversionesVO> buscarCoordinadorInSitu(int codTipoInfraestructura) throws SQLException;
    public List<SupervisorInversionesVO> buscarSupervisoresxInfraestructura(int codTipoInfraestructura) throws SQLException; 
    public SupervisorInversionesVO getSupervisorInversiones(int idsupinv)throws SQLException;
    
    
  
}
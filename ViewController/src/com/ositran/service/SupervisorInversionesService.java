
package com.ositran.service;

import com.ositran.model.SupervisorInversiones;
import com.ositran.vo.bean.SupervisorInversionesVO;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


public interface SupervisorInversionesService {
    public List<SupervisorInversionesVO> buscarCoordinadorInSitu(int codTipoInfraestructura) throws SQLException;
    public List<SupervisorInversionesVO> buscarSupervisoresxInfraestructura(int codTipoInfraestructura) throws SQLException; 
        
    
    
  
}
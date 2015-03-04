package com.ositran.service;

import com.ositran.model.Concesionario;

import com.ositran.vo.bean.ConcesionarioVO;

import java.sql.SQLException;

import java.util.List;

public interface ConcesionarioService {
    public List<ConcesionarioVO> query()  throws SQLException ,Exception;
    public String insert(ConcesionarioVO concesionarioVO)  throws SQLException ,Exception;
    public String delete(Integer id)  throws SQLException ,Exception;
    public String update(ConcesionarioVO concesionarioVO)  throws SQLException ,Exception;
    public ConcesionarioVO get(Integer id)  throws SQLException ,Exception;
    public List<ConcesionarioVO> queryF(String filtro)  throws SQLException ,Exception;
    public int getCanNombres(String nombre)  throws SQLException ,Exception;
  
}

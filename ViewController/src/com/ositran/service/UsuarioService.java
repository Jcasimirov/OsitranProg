package com.ositran.service;

import com.ositran.model.Usuario;
import com.ositran.vo.bean.ConcesionarioVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.UsuarioVO;

import java.sql.SQLException;

import java.util.List;

public interface UsuarioService {
    public List<UsuarioVO> query() throws SQLException;

    public String insert(UsuarioVO usuarioVO) throws SQLException;

    public String delete(Integer id) throws SQLException;

    public String update(UsuarioVO usuarioVO) throws SQLException;

    public UsuarioVO get(Integer id) throws SQLException;

    public List<UsuarioVO> UserSearch(String nomUserSearch) throws SQLException;
    
    public List<UsuarioVO> queryTD(int filtro)  throws SQLException;

}

package com.ositran.dao;

import com.ositran.model.Concesionario;
import com.ositran.model.InfraestructuraTipo;
import com.ositran.model.Usuario;

import java.sql.SQLException;

import java.util.List;

public interface UsuarioDAO {
    public List<Usuario> query() throws SQLException;

    public String insert(Usuario usuario) throws SQLException;

    public String delete(Integer id) throws SQLException;

    public String update(Usuario usuario) throws SQLException;

    public Usuario get(Integer id) throws SQLException;

    public List<Usuario> UserSearch(String nomUserSearch) throws SQLException;
    
    public List<Usuario> queryTD(int filtro) throws SQLException;

}

package com.ositran.dao;

import com.ositran.model.Usuario;

import java.math.BigDecimal;

import java.util.List;

public interface UsuarioDAO {
        public List<Usuario> query();
        public String insert(Usuario usuario);
        public String delete(Integer id);
        public String update(Usuario usuario);
        public Usuario get(Integer id);
}

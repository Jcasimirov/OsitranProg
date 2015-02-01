package com.ositran.dao;

import com.ositran.model.Usuario;

import java.math.BigDecimal;

import java.util.List;

public interface UsuarioDAO {
        public List<Usuario> query();
        public String insert(Usuario usuario);
        public String delete(BigDecimal id);
        public String update(Usuario usuario);
        public Usuario get(BigDecimal id);
        
        public void addUsuario(Usuario p);
        public void updateUsuario(Usuario p);
        public List<Usuario> listUsuarios();
        public Usuario getUsuarioById(BigDecimal id);
        public void removeUsuario(BigDecimal id);
        
}

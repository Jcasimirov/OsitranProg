package com.ositran.dao;

import com.ositran.model.Usuario;
import java.util.List;

public interface UsuarioDAO {
        public List<Usuario> query();
        public String insert(Usuario usuario);
        public String delete(Integer id);
        public String update(Usuario usuario);
        public Usuario get(Integer id);
        
        public void addUsuario(Usuario p);
        public void updateUsuario(Usuario p);
        public List<Usuario> listUsuarios();
        public Usuario getUsuarioById(int id);
        public void removeUsuario(int id);
        
}

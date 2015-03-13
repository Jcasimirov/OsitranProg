package com.ositran.dao;

import com.ositran.model.Rol;
import java.util.List;

public interface RolDAO {
        public List<Rol> query();
        public String insert(Rol rol);
        public String delete(Integer id);
        public String update(Rol rol);
        public Rol get(Integer id);
        public int getCodigo(Rol rol);
        
      
        
}

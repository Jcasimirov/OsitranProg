package com.ositran.dao;

import com.ositran.model.Men;

import java.util.List;

public interface MenDAO {
    
     public List<Men> query();
    public List<Men> query1(String filtro);
        public String insert(Men men);
        public String delete(Integer id);
        public String update(Men men);
        public Men get(Integer id);
        public String getNombre(Integer codigo);
        public int getPadre(Integer codigo);
}

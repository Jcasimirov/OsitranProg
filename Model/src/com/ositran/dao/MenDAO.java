package com.ositran.dao;

import com.ositran.model.Men;

import java.util.List;

public interface MenDAO {
    
     public List<Men> query();
        public String insert(Men men);
        public String delete(Integer id);
        public String update(Men men);
        public Men get(Integer id);
}

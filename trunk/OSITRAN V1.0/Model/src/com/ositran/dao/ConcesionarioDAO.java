package com.ositran.dao;

import com.ositran.model.Concesionario;
import java.util.List;

public interface ConcesionarioDAO {
        public List<Concesionario> query();
        public String insert(Concesionario concesionario);
        public String delete(Integer id);
        public String update(Concesionario concesionario);
        public Concesionario get(Integer id);
}

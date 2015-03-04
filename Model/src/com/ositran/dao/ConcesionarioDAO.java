package com.ositran.dao;

import com.ositran.model.Concesionario;
import java.sql.SQLException;
import java.util.List;

public interface ConcesionarioDAO {
        public List<Concesionario> query() throws SQLException ,Exception;
        public String insert(Concesionario concesionario)  throws SQLException ,Exception;
        public String delete(Integer id) throws SQLException ,Exception;
        public String update(Concesionario concesionario) throws SQLException ,Exception;
        public Concesionario get(Integer id) throws SQLException ,Exception;
        public List<Concesionario> queryF(String filtro) throws SQLException ,Exception;
        public int getCanNombres(String nombre)  throws SQLException ,Exception;

}

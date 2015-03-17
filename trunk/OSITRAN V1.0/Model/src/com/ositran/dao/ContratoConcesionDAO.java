package com.ositran.dao;

import com.ositran.model.Contrato;
import java.sql.SQLException;
import java.util.List;

public interface ContratoConcesionDAO {
        public List<Contrato> query() throws SQLException;
        public String insert(Contrato contrato) throws SQLException;
        public String delete(Integer id) throws SQLException;
        public String update(Contrato contrato) throws SQLException;
        public Contrato get(Integer id) throws SQLException;
}

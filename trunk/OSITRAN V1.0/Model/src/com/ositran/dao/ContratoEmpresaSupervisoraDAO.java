package com.ositran.dao;

import java.sql.SQLException;

import com.ositran.model.ContratoSupervisora;
import java.util.List;

public interface ContratoEmpresaSupervisoraDAO {
        public List<ContratoSupervisora> query() throws SQLException;
        public String insert(ContratoSupervisora contrato) throws SQLException;
        public String delete(Integer id) throws SQLException;
        public String update(ContratoSupervisora contrato) throws SQLException;
        public ContratoSupervisora get(Integer id) throws SQLException;
        public int ValidarContratoSupervisora(int concesion, int tipoinfra) throws SQLException;
}

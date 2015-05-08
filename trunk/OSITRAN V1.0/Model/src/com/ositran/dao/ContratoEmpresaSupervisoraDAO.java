package com.ositran.dao;

import java.sql.SQLException;

import com.ositran.model.ContratoSupervisora;
import com.ositran.model.Usuario;

import java.util.List;

public interface ContratoEmpresaSupervisoraDAO {
        public List<ContratoSupervisora> query() throws SQLException;
        public int insert(ContratoSupervisora contratoSupervisora) throws SQLException;
        public String delete(Integer id) throws SQLException;
        public String update(ContratoSupervisora contratoSupervisora) throws SQLException;
        public ContratoSupervisora get(Integer id) throws SQLException;
        public int ValidarContratoSupervisora(int concesion, int tipoinfra) throws SQLException;
        public List<ContratoSupervisora> filtrarContraEmpSup(String empresaSupervisora) throws SQLException;
        public List<ContratoSupervisora> queryTD(int filtro) throws SQLException;
}

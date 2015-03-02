package com.ositran.dao;

import com.ositran.model.EmpresaSupervisora;

import java.sql.SQLException;

import java.util.List;

public interface EmpresaSupervisoraDAO {
        public List<EmpresaSupervisora> query() throws SQLException;
        public String insert(EmpresaSupervisora empresaSupervisora) throws SQLException;
        public String delete(Integer id) throws SQLException;
        public String update(EmpresaSupervisora empresaSupervisora) throws SQLException;
        public EmpresaSupervisora get(Integer id) throws SQLException;
        public List<EmpresaSupervisora> FiltrarEmpSup(String atributo) throws SQLException;
}

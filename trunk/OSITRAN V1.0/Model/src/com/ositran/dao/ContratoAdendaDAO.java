package com.ositran.dao;


import com.ositran.model.ContratoAdenda;

import com.ositran.model.ContratoEntrega;

import java.sql.SQLException;

import java.util.List;

public interface ContratoAdendaDAO {
   
        public List<ContratoAdenda> query() throws SQLException;
        public String insert(ContratoAdenda contratoAdenda) throws SQLException;
        public String delete(Integer id) throws SQLException;
        public String update(ContratoAdenda contratoAdenda) throws SQLException;
        public ContratoAdenda get(Integer id) throws SQLException;
        public List<ContratoAdenda> getAdendasContrato(Integer conId) throws SQLException;

}

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
        public List<EmpresaSupervisora> FiltrarEmpSup(String nombre, String ruc) throws SQLException;
        public int  ValidarNombre(String atributo) throws SQLException;
        public int ValidarRucMod(String atributo, String NombreRuc,int documento) throws SQLException;
        public int  ValidarRuc(String atributo,int documento) throws SQLException;
        public int ValidarNombreMod(String atributo, String NombreMod) throws SQLException;
        public List<Object[]> BuscarEmpresaPorContrato (Integer contratoConcesion, Integer etapaContrato, String nombreEmpresa) throws SQLException;
}

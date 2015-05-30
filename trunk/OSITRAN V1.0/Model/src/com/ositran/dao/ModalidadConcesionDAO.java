package com.ositran.dao;

import com.ositran.model.ModalidadConcesion;

import java.sql.SQLException;

import java.util.List;

public interface ModalidadConcesionDAO {
        public List<ModalidadConcesion> query() throws SQLException;
        public String insert(ModalidadConcesion modalidadConcesion) throws SQLException;
        public String delete(Integer id) throws SQLException;
        public String update(ModalidadConcesion modalidadConcesion) throws SQLException;
        public ModalidadConcesion get(Integer id) throws SQLException;
        public List<ModalidadConcesion> FiltrarModalidad(String atributo) throws SQLException;
        public int  ValidarNombre(String atributo) throws SQLException;
        public int  ValidarNombreMod(String atributo, String NombreMod) throws SQLException;
        public boolean validarCodigoEnUso(Integer csiId) throws Exception;
        
}

package com.ositran.service;

import com.ositran.vo.bean.ModalidadConcesionVO;

import java.sql.SQLException;

import java.util.List;

public interface ModalidadConcesionService {
    public List<ModalidadConcesionVO> query() throws SQLException;
    public String insert(ModalidadConcesionVO modalidadConcesionVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ModalidadConcesionVO modalidadConcesionVO) throws SQLException;
    public ModalidadConcesionVO get(Integer id) throws SQLException;
    public List<ModalidadConcesionVO> FiltrarBusqueda(String atributo) throws SQLException;
    public int ValidaNombre(String atributo) throws SQLException;
    public int ValidaNombreMod(String atributo,String nombre) throws SQLException;
    public boolean validarCodigoEnUso(Integer csiId) throws Exception;
}

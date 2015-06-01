package com.ositran.service;

import com.ositran.vo.bean.ConcesionVO;

import java.sql.SQLException;

import java.util.List;

public interface ConcesionService {
    public List<ConcesionVO> query() throws SQLException;
    public String insert(ConcesionVO concesionVO) throws SQLException;
    public String delete(Integer id) throws SQLException;
    public String update(ConcesionVO concesionVO) throws SQLException;
    public String update2(ConcesionVO concesionVO) throws SQLException;
    public ConcesionVO get(Integer id) throws SQLException;
    public int idConcesion (ConcesionVO concesionVO) throws SQLException;
    public List<ConcesionVO> buscarconcesionfiltro(int codigo, String nombre) throws SQLException;
    //Iosusky
        public List<ConcesionVO> filtrarConcesion(int tipoInfraestructura) throws SQLException;
    public List<ConcesionVO> listarConcesionesxIdConcesion(int codigo) throws Exception;
    public boolean validarCodigoEnUso(Integer csiId,Integer tinId) throws Exception;
}

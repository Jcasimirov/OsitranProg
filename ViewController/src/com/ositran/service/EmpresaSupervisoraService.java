package com.ositran.service;


import com.ositran.vo.bean.EmpresaSupervisoraVO;
import com.ositran.vo.bean.InfraestructuraTipoVO;


import java.sql.SQLException;

import java.util.List;

public interface EmpresaSupervisoraService {
        public List<EmpresaSupervisoraVO> query() throws SQLException;
        public String insert(EmpresaSupervisoraVO empresaSupervisoraVO) throws SQLException;
        public String delete(Integer id) throws SQLException;
        public String update(EmpresaSupervisoraVO empresaSupervisoraVO) throws SQLException;
        public EmpresaSupervisoraVO get(Integer id) throws SQLException;
        public List<EmpresaSupervisoraVO> FiltrarEmpSup(String nombre, String ruc) throws SQLException;
        public int ValidaNombre(String atributo) throws SQLException;
        public int ValidaNombreMod(String atributo, String Nombre) throws SQLException;
        public int ValidaRuc(String atributo, int documento) throws SQLException;
        public int ValidarRucMod(String atributo, String Nombre, int documento) throws SQLException;
        public List<EmpresaSupervisoraVO> BuscarEmpresaPorContrato(Integer contratoConcesion, Integer etapaContrato, String nombreEmpresa) throws SQLException;
}
   
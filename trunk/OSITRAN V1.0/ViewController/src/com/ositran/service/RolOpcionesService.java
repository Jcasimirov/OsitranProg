package com.ositran.service;

import com.ositran.model.RolOpciones;
import com.ositran.vo.bean.RolOpcionesVO;

import java.util.List;

public interface RolOpcionesService {
    public List<RolOpcionesVO> query();
    public String insert(RolOpcionesVO rolOpcionesVO);
    public String insertOrUpdate(RolOpcionesVO rolOpcionesVO);
    public String delete(Integer id);
    public String update(RolOpciones rolOpciones);
    public RolOpcionesVO get(Integer id);
    public List<RolOpcionesVO> query1(Integer codigoRol);
    public void updateEstado(int codigoRol,int CodigoMen);
    
}

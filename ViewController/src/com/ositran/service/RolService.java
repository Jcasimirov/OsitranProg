package com.ositran.service;

import com.ositran.model.Rol;
import com.ositran.model.RolOpciones;
import com.ositran.model.Usuario;

import com.ositran.vo.bean.RolOpcionesVO;
import com.ositran.vo.bean.RolVO;

import java.util.List;

public interface RolService {
    public List<RolVO> query();
    public List<RolVO> query1(String filtro);
    public String insert(RolVO rolVO);
    public String delete(Integer id);
    public String update(RolVO rolVO);
    public RolVO get(Integer id);
    public int getCodigo(RolVO rolVO);
    
    

}
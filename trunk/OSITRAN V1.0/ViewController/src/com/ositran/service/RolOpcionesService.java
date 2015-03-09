package com.ositran.service;

import com.ositran.model.RolOpciones;
import com.ositran.vo.bean.RolOpcionesVO;

import java.util.List;

public interface RolOpcionesService {
    public List<RolOpcionesVO> query();
    public String insert(RolOpciones rolOpciones);
    public String delete(Integer id);
    public String update(RolOpciones rolOpciones);
    public RolOpciones get(Integer id);
}

package com.ositran.service;

import com.ositran.model.Rol;
import com.ositran.model.Usuario;

import com.ositran.vo.bean.RolVO;

import java.util.List;

public interface RolService {
    public List<RolVO> query();
    public String insert(Rol rol);
    public String delete(Integer id);
    public String update(Rol rol);
    public Rol get(Integer id);
}
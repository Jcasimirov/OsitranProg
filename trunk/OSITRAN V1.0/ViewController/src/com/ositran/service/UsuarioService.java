package com.ositran.service;

import com.ositran.vo.bean.InfraestructuraTipoVO;
import com.ositran.vo.bean.UsuarioVO;

import java.util.List;

public interface UsuarioService {
    public List<UsuarioVO> query();
    public String insert(UsuarioVO usuarioVO);
    public String delete(Integer id);
    public String update(UsuarioVO usuarioVO);
    public UsuarioVO get(Integer id);
    public List<UsuarioVO> AllSearch(String searchUsuario);
}
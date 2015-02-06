package com.ositran.serviceimpl;

import com.ositran.daoimpl.UsuarioDAOImpl;
import com.ositran.model.Usuario;
import com.ositran.service.UsuarioService;
import com.ositran.vo.bean.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

public class UsuarioServiceImpl implements UsuarioService{
    public UsuarioServiceImpl() {
        super();
    }
    
    private UsuarioDAOImpl usuarioDAOImpl;

    public void setUsuarioDAOImpl(UsuarioDAOImpl usuarioDAOImpl) {
        this.usuarioDAOImpl = usuarioDAOImpl;
    }

    @Override
    public List<UsuarioVO> query() {
        List<Usuario> list=usuarioDAOImpl.query();
        List<UsuarioVO> listVO=toListUsuariosVO(list);
        return listVO;
    }

    @Override
    public String insert(UsuarioVO usuarioVO) {
        Usuario usuario=toUsuario(usuarioVO);
        String result=usuarioDAOImpl.insert(usuario);
        return result;
    }

    @Override
    public String delete(Integer id) {
        String result=this.usuarioDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(UsuarioVO usuarioVO) {
        Usuario usuario=toUsuario(usuarioVO);
        String result=this.usuarioDAOImpl.update(usuario);
        return result;
    }

    @Override
    public UsuarioVO get(Integer id) {
        Usuario usuario=this.usuarioDAOImpl.get(id);
        UsuarioVO usuarioVO=toUsuarioVO(usuario);
        return usuarioVO;
    }
    
    //conversiones
    private List<UsuarioVO> toListUsuariosVO(List<Usuario> list){
        List<UsuarioVO> listVO=new ArrayList<UsuarioVO>();
        for(int i=0;i<list.size();i++){
            Usuario usuario=(Usuario)list.get(i);
            UsuarioVO usuarioVO=toUsuarioVO(usuario);
            listVO.add(usuarioVO);
        }
        return listVO;
    }
    private UsuarioVO toUsuarioVO(Usuario usuario){
        UsuarioVO usuarioVO=new UsuarioVO();
        usuarioVO.setUsuId(usuario.getUsuId());
        usuarioVO.setCrgId(usuario.getCrgId());
        usuarioVO.setRolId(usuario.getRolId());
        usuarioVO.setUsuContrasenya(usuario.getUsuContrasenya());
        usuarioVO.setUsuEsexterno(usuario.getUsuEsexterno());
        usuarioVO.setUsuEstado(usuario.getUsuEstado());
        usuarioVO.setUsuFechaAlta(usuario.getUsuFechaAlta());
        usuarioVO.setUsuFechaBaja(usuario.getUsuFechaBaja());
        usuarioVO.setUsuFechaCambio(usuario.getUsuFechaCambio());
        usuarioVO.setUsuNombre(usuario.getUsuNombre());
        usuarioVO.setUsuTerminal(usuario.getUsuTerminal());
        usuarioVO.setUsuUsuarioAlta(usuario.getUsuUsuarioAlta());
        usuarioVO.setUsuUsuarioBaja(usuario.getUsuUsuarioBaja());
        usuarioVO.setUsuUsuarioCambio(usuario.getUsuUsuarioCambio());
        return usuarioVO;
    }
    private Usuario toUsuario(UsuarioVO usuarioVO){
        Usuario usuario=new Usuario();
        usuario.setUsuId(usuarioVO.getUsuId());
        usuario.setCrgId(usuarioVO.getCrgId());
        usuario.setRolId(usuarioVO.getRolId());
        usuario.setUsuContrasenya(usuarioVO.getUsuContrasenya());
        usuario.setUsuEsexterno(usuarioVO.getUsuEsexterno());
        usuario.setUsuEstado(usuarioVO.getUsuEstado());
        usuario.setUsuFechaAlta(usuarioVO.getUsuFechaAlta());
        usuario.setUsuFechaBaja(usuarioVO.getUsuFechaBaja());
        usuario.setUsuFechaCambio(usuarioVO.getUsuFechaCambio());
        usuario.setUsuNombre(usuarioVO.getUsuNombre());
        usuario.setUsuTerminal(usuarioVO.getUsuTerminal());
        usuario.setUsuUsuarioAlta(usuarioVO.getUsuUsuarioAlta());
        usuario.setUsuUsuarioBaja(usuarioVO.getUsuUsuarioBaja());
        usuario.setUsuUsuarioCambio(usuarioVO.getUsuUsuarioCambio());
        return usuario;
        
    }
}

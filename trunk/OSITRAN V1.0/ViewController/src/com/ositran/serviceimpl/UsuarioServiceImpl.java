package com.ositran.serviceimpl;

import com.ositran.dao.UsuarioDAO;
import com.ositran.model.Usuario;
import com.ositran.service.UsuarioService;
import com.ositran.vo.bean.UsuarioVO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class UsuarioServiceImpl implements UsuarioService{
    UsuarioDAO usuarioDAOImpl;
   
    @Override
    public List<UsuarioVO> query() throws SQLException{
       
        List<Usuario> list = usuarioDAOImpl.query();
        

        List<UsuarioVO> listVO = toListUsuariosVO(list);
        

        return listVO;
    }

    @Override
    public String insert(UsuarioVO usuarioVO)throws SQLException {
        Usuario usuario = toUsuario(usuarioVO);
        String result = usuarioDAOImpl.insert(usuario);
        return result;
    }

    @Override
    public String delete(Integer id) throws SQLException{
        String result = this.usuarioDAOImpl.delete(id);
        return result;
    }

    @Override
    public String update(UsuarioVO usuarioVO)throws SQLException{
        Usuario usuario = toUsuario(usuarioVO);
        String result = this.usuarioDAOImpl.update(usuario);
        return result;
    }
    


    @Override
    public UsuarioVO get(Integer id) throws SQLException{
        Usuario usuario = this.usuarioDAOImpl.get(id);
        UsuarioVO usuarioVO = toUsuarioVO(usuario);
        return usuarioVO;
    }

    @Override
    public List<UsuarioVO> UserSearch(String nomUserSearch) throws SQLException{
        List<Usuario> list = usuarioDAOImpl.UserSearch(nomUserSearch);
        List<UsuarioVO> listVO = toListUsuariosVO(list);
        return listVO;
    }
    

    //conversiones
    private List<UsuarioVO> toListUsuariosVO(List<Usuario> list) {
        List<UsuarioVO> listVO = new ArrayList<UsuarioVO>();
        for (int i = 0; i < list.size(); i++) {
            Usuario usuario = (Usuario) list.get(i);
            UsuarioVO usuarioVO = toUsuarioVO(usuario);
            listVO.add(usuarioVO);
        }
        return listVO;
    }

    private UsuarioVO toUsuarioVO(Usuario usuario) {
        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO.setRolId(usuario.getRolId());
        usuarioVO.setUsuAlias(usuario.getUsuAlias());
        usuarioVO.setUsuContrasenya(usuario.getUsuContrasenya());
        usuarioVO.setUsuCorreo(usuario.getUsuCorreo());
        usuarioVO.setUsuDescripcion(usuario.getUsuDescripcion());
        usuarioVO.setUsuEsexterno(usuario.getUsuEsexterno());
        usuarioVO.setUsuEstado(usuario.getUsuEstado());
        usuarioVO.setUsuFechaAlta(usuario.getUsuFechaAlta());
        usuarioVO.setUsuFechaBaja(usuario.getUsuFechaBaja());
        usuarioVO.setUsuFechaCambio(usuario.getUsuFechaCambio());
        usuarioVO.setUsuId(usuario.getUsuId());
        usuarioVO.setUsuNombre(usuario.getUsuNombre());
        usuarioVO.setUsuTerminal(usuario.getUsuTerminal());
        usuarioVO.setUsuUsuarioAlta(usuario.getUsuUsuarioAlta());
        usuarioVO.setUsuUsuarioBaja(usuario.getUsuUsuarioBaja());
        usuarioVO.setUsuUsuarioCambio(usuario.getUsuUsuarioCambio());
        usuarioVO.setTinId(usuario.getTinId());
        return usuarioVO;
    }

    private Usuario toUsuario(UsuarioVO usuarioVO) {
        Usuario usuario = new Usuario();
        usuario.setRolId(usuarioVO.getRolId());
        usuario.setUsuAlias(usuarioVO.getUsuAlias());
        usuario.setUsuContrasenya(usuarioVO.getUsuContrasenya());
        usuario.setUsuCorreo(usuarioVO.getUsuCorreo());        
        usuario.setUsuDescripcion(usuarioVO.getUsuDescripcion());
        usuario.setUsuEsexterno(usuarioVO.getUsuEsexterno());
        usuario.setUsuEstado(usuarioVO.getUsuEstado()); 
        usuario.setUsuFechaAlta(usuarioVO.getUsuFechaAlta());
        usuario.setUsuFechaBaja(usuarioVO.getUsuFechaBaja());
        usuario.setUsuFechaCambio(usuarioVO.getUsuFechaCambio());
        usuario.setUsuId(usuarioVO.getUsuId());
        usuario.setUsuNombre(usuarioVO.getUsuNombre());
        usuario.setUsuTerminal(usuarioVO.getUsuTerminal());
        usuario.setUsuUsuarioAlta(usuarioVO.getUsuUsuarioAlta());
        usuario.setUsuUsuarioBaja(usuarioVO.getUsuUsuarioBaja());
        usuario.setUsuUsuarioCambio(usuarioVO.getUsuUsuarioCambio());
        usuario.setTinId(usuarioVO.getTinId());
        return usuario;
    }


    public void setUsuarioDAOImpl(UsuarioDAO usuarioDAOImpl) {
        this.usuarioDAOImpl = usuarioDAOImpl;
    }

    public UsuarioDAO getUsuarioDAOImpl() {
        return usuarioDAOImpl;
    }


    @Override
    public List<UsuarioVO> queryTD(int filtro) throws SQLException {
        List<Usuario> list=usuarioDAOImpl.queryTD(filtro);
        List<UsuarioVO> listVO=toListUsuariosVO(list);
        return listVO;
    }
}

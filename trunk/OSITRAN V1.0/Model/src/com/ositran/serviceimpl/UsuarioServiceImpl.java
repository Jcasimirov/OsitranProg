package com.ositran.serviceimpl;

import com.ositran.dao.UsuarioDAO;
import com.ositran.daoimpl.UsuarioDAOImpl;
import com.ositran.model.Usuario;
import com.ositran.service.UsuarioService;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioDAOImpl usuarioDAOImpl=new UsuarioDAOImpl();
        private UsuarioDAO usuarioDAO;

	public void setUsuarioDAOImpl(UsuarioDAOImpl usuarioDAOImpl) {
		this.usuarioDAO = usuarioDAOImpl;
	}


        @Override
        public List<Usuario> query() {
            /*Usuario u=new Usuario();
            u.setId(1);
            u.setNombre("nombre");
            u.setCountry("country");*/
            //List<Usuario> list=new ArrayList<Usuario>();//usuarioDAOImpl.query();
            List<Usuario> list=usuarioDAOImpl.query();
            ///list.add(u);
            return list;
        }
    
        @Override
        public String insert(Usuario usuario) {
            String result=usuarioDAOImpl.insert(usuario);
            return result;
        }
    
        @Override
        public String delete(Integer id) {
            String result=usuarioDAOImpl.delete(id);
            return result;
        }
    
        @Override
        public String update(Usuario usuario) {
            String result=usuarioDAOImpl.update(usuario);
            return result;
        }
    
        @Override
        public Usuario get(Integer id) {
            Usuario usuario=usuarioDAOImpl.get(id);
            return usuario;
        }
}

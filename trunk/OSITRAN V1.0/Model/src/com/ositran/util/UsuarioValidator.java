package com.ositran.util;

import com.ositran.model.Usuario;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UsuarioValidator implements Validator {
    public UsuarioValidator() {
        super();
    }

    @Override
    public boolean supports(Class<?> c) {
        return Usuario.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Usuario u=(Usuario)object;
        //Validando nombre
        String nombre=u.getUsuNombre();
        if(nombre==null){
            errors.rejectValue("nombre", "nombre.required1");
        }

    }
}
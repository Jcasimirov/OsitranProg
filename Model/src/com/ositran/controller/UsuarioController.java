package com.ositran.controller;

import com.ositran.model.Usuario;
import com.ositran.service.UsuarioService;
import com.ositran.serviceimpl.UsuarioServiceImpl;
import com.ositran.util.UsuarioValidator;

import java.math.BigDecimal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {
    private UsuarioServiceImpl usuarioServiceImpl;
    private UsuarioService usuarioService;
    
    public UsuarioController() {
        super();
    }
    
    public void setUsuarioServiceImpl(UsuarioServiceImpl usuarioServiceImpl){
        this.usuarioServiceImpl=usuarioServiceImpl;
    }
    /*
    @Autowired(required=true)
    @Qualifier(value="usuarioService")
    public void setUsuarioService(UsuarioService us){
            this.usuarioService = us;
    }
    
    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public String listUsuarios(Model model) {
            model.addAttribute("usuario", new Usuario());
            model.addAttribute("listUsuarios", this.usuarioService.listUsuarios());
            return "usuario";
    }
    */
    @RequestMapping(params="accion=qry")
    public ModelAndView query(){
        List<Usuario> list=usuarioServiceImpl.query();
        System.out.println("controller query");
        ModelAndView mav=new ModelAndView("usuarioQry");
        mav.addObject("list", list);
        return mav;
    }
    
    @RequestMapping(params="accion=ins1")
    public ModelAndView insert1(){
        ModelAndView mav=new ModelAndView("usuarioIns");
        Usuario u=new Usuario();
        mav.addObject("usuario", u);
        return mav;
    }
    
    @RequestMapping(params="accion=ins2")
    public ModelAndView insert2(@ModelAttribute Usuario usuario){
        String result=usuarioServiceImpl.insert(usuario);
        if(result==null){
            result="Solicitud atendida";
        }
        ModelAndView mav=new ModelAndView("mensaje");
        mav.addObject("msg", result);
        return mav;
    }                                                                                                                                                                                                                                                                                                                                                                                                           
    
    @RequestMapping(params="accion=del")
    public ModelAndView delete(HttpServletRequest request){
        String id=request.getParameter("id");
        String result=null;
        if(id!=null){
            result=usuarioServiceImpl.delete(BigDecimal.valueOf(Long.valueOf(id)));
        }
        if(result==null){
            result="Solicitud atendida";
        }
        ModelAndView mav=new ModelAndView("mensaje");
        mav.addObject("msg", result);
        return mav;
    }                                                                                                                                                                                                                                                                                                                                                                                                           
    
    @RequestMapping(params="accion=upd1")
    public ModelAndView update1(HttpServletRequest request){
        String id=request.getParameter("id");
        Usuario usuario=null;
        ModelAndView mav=null;
        if(id!=null){
            usuario=usuarioServiceImpl.get(BigDecimal.valueOf(Long.valueOf(id)));
        }
        if(usuario==null){
            mav=new ModelAndView("mensaje");
            mav.addObject("msg", "No se pudo obtener Usuario");
        }else{
            mav=new ModelAndView("usuarioUpd");
            mav.addObject("usuario", usuario);
        }
        return mav;
    }                                                                                                                                                                                                                                                                                                                                                                                                           

    @RequestMapping(params="accion=upd2")
    public ModelAndView update2(@ModelAttribute Usuario usuario){
        String result=usuarioServiceImpl.update(usuario);
        if(result==null){
            result="Solicitud atendida";
        }
        ModelAndView mav=new ModelAndView("mensaje");
        mav.addObject("msg", result);
        return mav;
    }                                                                                                                                                                                                                                                                                                                                                                                                           

    /*
    //For add and update person both
    @RequestMapping(value= "/usuario/add", method = RequestMethod.POST)
    public String addUsuario(@ModelAttribute("usuario") Usuario p){
            if(p.getId() == 0){
                    //new person, add it
                    this.usuarioService.addUsuario(p);
            }else{
                    //existing person, call update
                    this.usuarioService.updateUsuario(p);
            }
            return "redirect:/usuario";
    }
    
    @RequestMapping("/remove/{id}")
    public String removeUsuario(@PathVariable("id") int id){
            
    this.usuarioService.removeUsuario(id);
    return "redirect:/usuario";
    }
    
    @RequestMapping("/edit/{id}")
    public String editUsuario(@PathVariable("id") int id, Model model){
    model.addAttribute("usuario", this.usuarioService.getUsuarioById(id));
    model.addAttribute("listUsuarios", this.usuarioService.listUsuarios());
    return "usuario";
    }

    */
    /*
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView ingreso(){
        Usuario u=new Usuario();
        ModelAndView mav=new ModelAndView("index","usuario", u);
        return mav;
    }
    /*
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView result(@ModelAttribute Usuario u, BindingResult result){
        UsuarioValidator validator=new UsuarioValidator();
        validator.validate(u, result);
        if(result.hasErrors()){
            ModelAndView mav=new ModelAndView("index","usuario", u);
            return mav;
        }else{
            ModelAndView mav=new ModelAndView("result","usuario",u);
            return mav;
        }
    }*/
}
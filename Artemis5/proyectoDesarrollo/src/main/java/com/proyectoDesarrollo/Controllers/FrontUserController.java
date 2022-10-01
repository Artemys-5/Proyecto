package com.proyectoDesarrollo.Controllers;

import com.proyectoDesarrollo.Entities.Empresa;
import com.proyectoDesarrollo.Entities.Enum_RoleName;
import com.proyectoDesarrollo.Entities.Usuario;
import com.proyectoDesarrollo.Services.Response;
import com.proyectoDesarrollo.Services.ServiceUsuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FrontUserController {

    ServiceUsuario serv;

    public FrontUserController(ServiceUsuario serv){
        this.serv = serv;
    }


    @GetMapping("/usuarios")
    public String getUsuarios(Model model){
        ArrayList<Usuario> listaUsers = this.serv.selectAll();
        model.addAttribute("usuarios", listaUsers);
        return "/usuario/listausuarios";
    }

    @GetMapping("register/usuario")
    public String regUsuario(Model model){

        model.addAttribute("usuario", new Usuario());
        return "usuario/agregar-usuario";
    }

    @PostMapping("registro-usuario")
    public RedirectView postEmpresa(@ModelAttribute Usuario usuario, Model model){

        model.addAttribute(usuario);
        usuario.setPerfil(null);
        usuario.setRol(Enum_RoleName.ADMIN);
        Response response = this.serv.createUser(usuario);

        if(response.getCode()==200){
            return new RedirectView("/usuarios");
        }
        return new RedirectView("/inicio2");
    }

}

package com.proyectoDesarrollo.Controllers;

import com.proyectoDesarrollo.Entities.Usuario;
import com.proyectoDesarrollo.Services.Response;
import com.proyectoDesarrollo.Services.ServiceUsuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

    private ServiceUsuario servicio;

    public LoginController(ServiceUsuario servicio){
        this.servicio = servicio;
    }

    @GetMapping("login")
    public String login(){
        return "login/login";
    }

    @GetMapping("registrar")
    public String registroUsuario(){
        return "login/registro";
    }

    @GetMapping("loginerror")
    public String errorMessage(){
        return "login/errormsg";
    }

    @PostMapping("postlogin")
    public RedirectView postlogin(Usuario data){
        Response response = this.servicio.loginUsuario(data);
        if (response.getCode()==200){

            return new RedirectView("/inicio2");
        }
        else{

            return new RedirectView("/loginerror");
        }
    }



}

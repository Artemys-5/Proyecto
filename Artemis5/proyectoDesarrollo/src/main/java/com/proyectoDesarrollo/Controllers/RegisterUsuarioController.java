package com.proyectoDesarrollo.Controllers;

import com.proyectoDesarrollo.Services.ServiceUsuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterUsuarioController {
    private ServiceUsuario servicio;

    public RegisterUsuarioController(ServiceUsuario servicio){
        this.servicio = servicio;
    }


}

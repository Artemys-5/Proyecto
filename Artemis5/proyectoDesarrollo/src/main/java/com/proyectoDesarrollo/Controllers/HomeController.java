package com.proyectoDesarrollo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //Por lo visto cada get requiere un String como retorno

    @GetMapping("inicio")
    public String inicio(){
        return "home/inicio";
    }

    @GetMapping("inicio2")
    public String inicio_dos(){
        return "home/inicio2";
    }



}

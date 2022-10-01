package com.proyectoDesarrollo.Controllers;

import com.proyectoDesarrollo.Entities.Empresa;
import com.proyectoDesarrollo.Entities.Usuario;
import com.proyectoDesarrollo.Services.Response;
import com.proyectoDesarrollo.Services.ServiceEmpresa;
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
public class FrontEnterController {

    ServiceEmpresa serv;

    public FrontEnterController(ServiceEmpresa serv){
        this.serv = serv;
    }


    @GetMapping("/empresas")
    public String getEmpresas(Model model){
        ArrayList<Empresa> listaEmpresas = this.serv.selectAll();
        model.addAttribute("empresas", listaEmpresas);
        return "/empresa/listaempresas";
    }

    /*  ------ CLAVE ------
        Posee model ya que se realizarán tareas con un modelo en html para Thymeleaf
        Se añade una empresa al modelo, para ser manipulado en el html
     */
    @GetMapping("register/empresa")
    public String regEmpresa(Model model){

        model.addAttribute("empresa", new Empresa());

        return "empresa/agregar-empresa";
    }

    /*
    *   ------ CLAVE ------
    *   Se accede a este post por medio de la ruta especificada en el action del html relacionado
    *   se pone una anotacion de atributo de modelo que RECIBE una empresa. La que se creó en el
    *   los campos field del html
    *
    *   Se crea un modelo con el fin de acceder al servicio para realizar la funcion
    *   respectiva al repositorio.
    * */

    @PostMapping("registro-empresa")
    public RedirectView postEmpresa(@ModelAttribute Empresa empresa, Model model){

        model.addAttribute(empresa);
        Response response = this.serv.createEmpresa(empresa);

        if(response.getCode()==200){
            return new RedirectView("/empresas");
        }
        return new RedirectView("/inicio2");
    }

}

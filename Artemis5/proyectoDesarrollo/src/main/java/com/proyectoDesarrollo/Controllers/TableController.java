package com.proyectoDesarrollo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {

    @GetMapping("table")
    public String tables(){
        return "Tables/table";
    }

    @GetMapping("table2")
    public String tables2(){
        return "Tables/table2";
    }

    @GetMapping("tableprov")
    public String tableprov(){
        return "Tables/tableprov";
    }

}

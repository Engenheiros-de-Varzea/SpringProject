package com.edv.antenados.controller;

import com.edv.antenados.repository.Salarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/salarios")
public class SalarioController {

    @RequestMapping("/novo")
    public String novo() {
        return "/salario/CadastroServidor";
    }
    
    @Autowired
    private Salarios salarios;
    
    @RequestMapping
    public ModelAndView pesquisa() {
        ModelAndView mv = new ModelAndView("/salario/ListagemSalarios");
        mv.addObject("salarios", salarios.findAll());
        
        return mv;
    }
	
}

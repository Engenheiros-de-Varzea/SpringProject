package com.edv.antenados.controller;

import com.edv.antenados.model.Salario;
import com.edv.antenados.repository.Salarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping("/{id_servidor}")
    public ModelAndView visualizar(@PathVariable Integer id_servidor) {
        ModelAndView mv = new ModelAndView("/salario/ListagemSalarios");
        mv.addObject("salarios", salarios.findByServidor(id_servidor));
        
        return mv;
    }
	
}

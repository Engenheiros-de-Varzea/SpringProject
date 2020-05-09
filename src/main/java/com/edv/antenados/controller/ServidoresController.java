package com.edv.antenados.controller;

import com.edv.antenados.repository.Servidores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/servidores")
public class ServidoresController {

    @RequestMapping("/novo")
    public String novo() {
        return "/servidor/CadastroServidor";
    }
    
    @Autowired
    private Servidores servidores;
    
    @RequestMapping
    public ModelAndView pesquisa() {
        ModelAndView mv = new ModelAndView("/servidor/ListagemServidores");
        mv.addObject("servidores", servidores.findAll());
        
        return mv;
    }
	
}

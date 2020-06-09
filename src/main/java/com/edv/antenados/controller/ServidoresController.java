package com.edv.antenados.controller;

import com.edv.antenados.repository.Servidores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/servidores")
public class ServidoresController {
    
    @Autowired
    private Servidores servidores;
    
    @RequestMapping
    public ModelAndView amostragem(Pageable pageable) {
        ModelAndView mv = new ModelAndView("/servidor/ListagemServidores");
        
        mv.addObject("servidoresAll", servidores.findAll());
        mv.addObject("cargo", servidores.findAllCargo());
        mv.addObject("qntServInPage", pageable.getPageSize());
        mv.addObject("currentPage", pageable.getPageNumber());
        mv.addObject("servidores", servidores.findAll(pageable));
        
        return mv;
    }
	
    /*
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView pesquisa(@RequestParam("page") Integer page, @RequestParam("cargo") String cargo) {                
        ModelAndView mv = new ModelAndView("/servidor/ListagemServidores");
        //mv.addObject("cargo", servidores.findAllCargo());
        mv.addObject("servidores", servidores.findByCargo("advogado"));
        
        return mv;
    }
    */
}

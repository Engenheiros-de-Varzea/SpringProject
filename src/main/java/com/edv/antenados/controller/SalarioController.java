package com.edv.antenados.controller;

import com.edv.antenados.model.Salario;
import com.edv.antenados.repository.Salarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/salarios")
public class SalarioController {
    
    @Autowired
    private Salarios salarios;
    
    @RequestMapping
    public ModelAndView pesquisa(Pageable pageable) {
        ModelAndView mv = new ModelAndView("/salario/ListagemSalarios");
        mv.addObject("salarios", salarios.findAll(pageable));

        return mv;
    }

    @RequestMapping("/{id_servidor}")
    public ModelAndView visualizar(@PathVariable Integer id_servidor) {
        ModelAndView mv = new ModelAndView("/salario/ListagemSalarios");
        mv.addObject("salarios", salarios.findSalarioByServidor(id_servidor));
        
        return mv;
    }
    
}

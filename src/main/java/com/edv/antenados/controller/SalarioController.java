package com.edv.antenados.controller;

import com.edv.antenados.repository.Salarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/salarios")
public class SalarioController {
    
    @Autowired
    private Salarios salarios;
            
}

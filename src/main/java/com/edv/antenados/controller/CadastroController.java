/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edv.antenados.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author teste
 */
@Controller
public class CadastroController {
    
    @RequestMapping("/recomendacao")
    public String screenRecommendation() {
        return "/administrador/CadastroRecomendacao";
    }
    
}

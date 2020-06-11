package com.edv.antenados.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    
    @RequestMapping("/login")
    public String screenLogin(@AuthenticationPrincipal User user) {
        if(user != null){
            return "redirect:/servidores";
            //quando o usuario já está logado e tenta entrar na tela de login 
            //ele é redirecionado para outra tela, no caso para tela servidor
        }
        return "/administrador/LoginAdmin";
    }
    
}

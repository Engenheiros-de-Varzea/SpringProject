package com.edv.antenados.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrendsController {
    
    @RequestMapping("/trends")
    public String screenRecommendation() {
        return "/administrador/Trends";
    }
    
}

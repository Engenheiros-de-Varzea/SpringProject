package com.edv.antenados.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    
    @RequestMapping("/index")
    public String screenRecommendation() {
        return "/index/Index";
    }
    
    @RequestMapping("/") 
    public String home(){
        return "redirect:index"; 
    }
}

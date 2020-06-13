package com.edv.antenados.controller;

import com.edv.antenados.model.Servidor;
import com.edv.antenados.repository.Servidores;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/servidores")
public class ServidoresController {
    
    @Autowired
    private Servidores servidores;

    @RequestMapping
    public ModelAndView amostragem(Pageable pageable) {
        ModelAndView mv = new ModelAndView("/servidor/ListagemServidores");
        
        //List<Servidor> listServ = filtro("", "", "", servidores.findAll());
        
        mv.addObject("qntPage", (int) Math.ceil((double) servidores.qntServ() / (double) pageable.getPageSize()));
        mv.addObject("navPage", contNav(pageable.getPageNumber(), (int) Math.ceil((double) servidores.qntServ() / (double) pageable.getPageSize())));
        //mv.addObject("qntServ", listServ.size());
        mv.addObject("qntServ", servidores.qntServ());
        mv.addObject("cargo", servidores.findAllCargo());
        mv.addObject("regime", servidores.findAllRegime());
        mv.addObject("qntServInPage", pageable.getPageSize());
        mv.addObject("currentPage", pageable.getPageNumber());
        mv.addObject("servidores", servidores.findAll(pageable));
        
        //mv.addObject("servidores", listServ);
        
        return mv;
    }
    
    public List<Servidor> filtro(String nome, String cargo, String regime, List<Servidor> lista)
    {
        List<Servidor> filtro1 = new ArrayList<>();
        List<Servidor> filtro2 = new ArrayList<>();
        List<Servidor> filtro3 = new ArrayList<>();
        
        if (!nome.isEmpty())
        {
            for (Servidor serv:lista)
            {
                if (serv.getNome().contains(nome))
                {
                    filtro1.add(serv);
                }
            }
        }
        else
        {
            filtro1 = lista;
        }
        
        if (!cargo.isEmpty())
        {
            for (Servidor serv:filtro1)
            {
                if (serv.getCargo().equals(cargo))
                {
                    filtro2.add(serv);
                }
            }
        }
        else
        {
            filtro2 = filtro1;
        }
        
        if (!regime.isEmpty())
        {
            for (Servidor serv:filtro2)
            {
                if (serv.getCargo().equals(cargo))
                {
                    filtro3.add(serv);
                }
            }
        }
        else
        {
            filtro3 = filtro2;
        }
        
        return filtro3;
    }
     
    public int contNav (int currentPage, int lastPage)
    {
        int countPage;
        
        if (currentPage < 6)
        {
            countPage = 6;
        }
        else if (currentPage > (lastPage - 6))
        {
            countPage = lastPage - 5;
        }
        else
        {
            countPage = currentPage + 1;
        }
        
        return countPage;
    }
}

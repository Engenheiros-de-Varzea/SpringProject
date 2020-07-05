package com.edv.antenados.controller;

import com.edv.antenados.model.Servidor;
import com.edv.antenados.repository.Salarios;
import com.edv.antenados.repository.Servidores;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/servidores")
public class ServidoresController {
    
    @Autowired
    private Servidores servidores;

    @Autowired
    private Salarios salarios;
    
    @RequestMapping
    public ModelAndView amostragem(Pageable pageable) {
        ModelAndView mv = new ModelAndView("/servidor/ListagemServidores");
        
        mv.addObject("qntPage", (int) Math.ceil((double) servidores.qntServ() / (double) pageable.getPageSize()));
        mv.addObject("navPage", contNav(pageable.getPageNumber(), (int) Math.ceil((double) servidores.qntServ() / (double) pageable.getPageSize())));
        mv.addObject("qntServ", servidores.qntServ());
        mv.addObject("cargo", servidores.findAllCargo());
        mv.addObject("regime", servidores.findAllRegime());
        mv.addObject("qntServInPage", pageable.getPageSize());
        mv.addObject("currentPage", pageable.getPageNumber());
        
        Page<Servidor> servidores_encontrados = servidores.findAll(pageable);
        for(Servidor servidor : servidores_encontrados){
            servidor.setSalario(salarios.findSalarioByServidor(servidor.getId()));
        }
        mv.addObject("servidores", servidores_encontrados);
        
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
        
        if (currentPage < 4)
        {
            countPage = 4;
        }
        else if (currentPage > (lastPage - 4))
        {
            countPage = lastPage - 3;
        }
        else
        {
            countPage = currentPage + 1;
        }
        
        return countPage;
    }
}

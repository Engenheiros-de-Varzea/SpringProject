package com.edv.antenados.repository;

import com.edv.antenados.model.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Servidores extends JpaRepository<Servidor, Integer> {
    
}

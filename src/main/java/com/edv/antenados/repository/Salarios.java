package com.edv.antenados.repository;

import com.edv.antenados.model.Salario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Salarios extends JpaRepository<Salario, Integer> {
    
}

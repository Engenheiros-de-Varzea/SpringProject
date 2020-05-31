package com.edv.antenados.repository;

import com.edv.antenados.model.Salario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Salarios extends JpaRepository<Salario, Integer> {
    
    @Query(value = "SELECT * FROM salario s WHERE ID_SERVIDOR = ?1", nativeQuery = true)
    public List<Salario> findByServidor(Integer id_servidor);
    
}

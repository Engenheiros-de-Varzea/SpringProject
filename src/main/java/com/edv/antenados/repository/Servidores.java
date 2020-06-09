package com.edv.antenados.repository;

import com.edv.antenados.model.Salario;
import com.edv.antenados.model.Servidor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Servidores extends JpaRepository<Servidor, Integer> {
    // Listagem de cargos
    @Query(value = "SELECT DISTINCT cargo FROM servidor ORDER BY cargo ASC", nativeQuery = true)
    public List<Salario> findAllCargo();

    // Pesquisa por cargos
    @Query(value = "SELECT * FROM servidor WHERE CARGO = ?1", nativeQuery = true)
    public List<Salario> findByCargo(String cargo);
}

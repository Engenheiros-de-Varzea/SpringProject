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
    
    // Listagem de regimes
    @Query(value = "SELECT DISTINCT regime FROM servidor ORDER BY regime ASC", nativeQuery = true)
    public List<Salario> findAllRegime();

    // Pesquisa por cargos
    @Query(value = "SELECT * FROM servidor WHERE CARGO = ?1", nativeQuery = true)
    public List<Servidor> findByCargo(String cargo);
    
    // Pesquisa por regime
    @Query(value = "SELECT * FROM servidor WHERE REGIME = ?1", nativeQuery = true)
    public List<Servidor> findByRegime(String regime);
    
    // Quantidade de servidores cadastrados
    @Query(value = "SELECT COUNT('id') FROM servidor", nativeQuery = true)
    public int qntServ();
}

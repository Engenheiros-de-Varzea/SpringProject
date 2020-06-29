package com.edv.antenados.repository;

import com.edv.antenados.model.Salario;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Salarios extends JpaRepository<Salario, Integer> {
    
    @Query(value = "SELECT ID, ID_SERVIDOR, ID_LANCAMENTO, REFERENCIA, 'Salário Mensal' AS DESCRICAO, " +
                        "SUM(CASE WHEN ID_LANCAMENTO = 1 THEN VALOR ELSE 0 END) - " +
                        "SUM(CASE WHEN ID_LANCAMENTO = 2 THEN VALOR ELSE 0 END) VALOR, DT_INCLUSAO " +
                    "FROM SALARIO WHERE ID_SERVIDOR=?1 GROUP BY REFERENCIA", nativeQuery = true)
    public List<Salario> findSalarioByServidor(Integer id_servidor);
    
    @Query(value = "SELECT * FROM SALARIO WHERE ID_SERVIDOR=?1 AND REFERENCIA=?2", nativeQuery = true)
    public List<Salario> findAllByServidorAndReferencia(Integer id_servidor, Date referencia);
    
}

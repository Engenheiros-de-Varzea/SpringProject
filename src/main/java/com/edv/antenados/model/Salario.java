package com.edv.antenados.model;

import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "SALARIO")
public class Salario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer id_servidor;
    private Integer id_lancamento;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date referencia;
    private String descricao;
    private Double valor;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dt_inclusao;

    public Salario() {
        this.id = 0;
        this.id_servidor = 0;
        this.id_lancamento = 0;
        this.referencia = new Date();
        this.descricao = "";
        this.valor = 0.0;
        this.dt_inclusao = new Date();
    }
    
    public Salario(Integer id, Integer id_servidor, Integer id_lancamento, Date referencia, String descricao, Double valor, Date dt_inclusao) {
        this.id = id;
        this.id_servidor = id_servidor;
        this.id_lancamento = id_lancamento;
        this.referencia = referencia;
        this.descricao = descricao;
        this.valor = valor;
        this.dt_inclusao = dt_inclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_servidor() {
        return id_servidor;
    }

    public void setId_servidor(Integer id_servidor) {
        this.id_servidor = id_servidor;
    }

    public Integer getId_lancamento() {
        return id_lancamento;
    }

    public void setId_lancamento(Integer id_lancamento) {
        this.id_lancamento = id_lancamento;
    }

    public Date getReferencia() {
        return referencia;
    }

    public void setReferencia(Date referencia) {
        this.referencia = referencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDt_inclusao() {
        return dt_inclusao;
    }

    public void setDt_inclusao(Date dt_inclusao) {
        this.dt_inclusao = dt_inclusao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Salario other = (Salario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}

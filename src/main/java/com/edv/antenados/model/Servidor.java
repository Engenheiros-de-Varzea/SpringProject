package com.edv.antenados.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "SERVIDOR")
public class Servidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private Integer rgf;
    private String nome;
    private String cargo;
    private String regime;
    @OneToMany
    private List<Salario> salario;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dt_inclusao;

    public Servidor() {
        this.id = 0;
        this.rgf = 0;
        this.nome = "";
        this.cargo = "";
        this.regime = "";
        this.salario = new ArrayList<>();
        this.dt_inclusao = new Date();
    }
    
    public Servidor(Integer id, Integer rgf, String nome, String cargo, String regime, List<Salario> salario, Date dt_inclusao) {
        this.id = id;
        this.rgf = rgf;
        this.nome = nome;
        this.cargo = cargo;
        this.regime = regime;
        this.salario = salario;
        this.dt_inclusao = dt_inclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getRgf() {
        return rgf;
    }

    public void setRgf(Integer rgf) {
        this.rgf = rgf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public List<Salario> getSalario() {
        return salario;
    }
    
    public void setSalario(List<Salario> salario) {
        this.salario = salario;
    } 

    public Date getDt_inclusao() {
        return dt_inclusao;
    }

    public void setDt_inclusao(Date dt_inclusao) {
        this.dt_inclusao = dt_inclusao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Servidor other = (Servidor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}

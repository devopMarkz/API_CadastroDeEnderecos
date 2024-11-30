package com.bootcamp.api.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TB_UF")
public class Uf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_UF")
    private Long codigoUF;

    @Column(name = "SIGLA", unique = true, nullable = false)
    private String sigla;

    @Column(name = "NOME", unique = true, nullable = false)
    private String nome;

    @Column(name = "STATUS")
    private Integer status;

    @OneToMany(mappedBy = "uf")
    private Set<Municipio> municipios = new HashSet<>();

    public Uf() {
    }

    public Uf(Long codigoUF, String sigla, String nome, Integer status) {
        this.codigoUF = codigoUF;
        this.sigla = sigla;
        this.nome = nome;
        this.status = status;
    }

    public Long getCodigoUF() {
        return codigoUF;
    }

    public void setCodigoUF(Long codigoUF) {
        this.codigoUF = codigoUF;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Uf uf = (Uf) object;
        return Objects.equals(codigoUF, uf.codigoUF);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigoUF);
    }
}

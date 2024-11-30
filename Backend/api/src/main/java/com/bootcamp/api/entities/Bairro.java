package com.bootcamp.api.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "TB_BAIRRO")
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_BAIRRO")
    private Long codigoBairro;

    @ManyToOne
    @JoinColumn(name = "CODIGO_MUNICIPIO")
    private Municipio municipio;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "STATUS")
    private Integer status;

    public Bairro() {
    }

    public Bairro(Long codigoBairro, Municipio municipio, String nome, Integer status) {
        this.codigoBairro = codigoBairro;
        this.municipio = municipio;
        this.nome = nome;
        this.status = status;
    }

    public Long getCodigoBairro() {
        return codigoBairro;
    }

    public void setCodigoBairro(Long codigoBairro) {
        this.codigoBairro = codigoBairro;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
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
        Bairro bairro = (Bairro) object;
        return Objects.equals(codigoBairro, bairro.codigoBairro);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigoBairro);
    }
}

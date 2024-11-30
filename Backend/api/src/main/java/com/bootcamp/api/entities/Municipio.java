package com.bootcamp.api.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_MUNICIPIO")
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_MUNICIPIO")
    private Long codigoMunicipio;

    @ManyToOne
    @JoinColumn(name = "CODIGO_UF")
    private Uf uf;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "STATUS", nullable = false)
    private Integer status;

    @OneToMany(mappedBy = "municipio")
    private List<Bairro> bairros = new ArrayList<>();

    public Municipio() {
    }

    public Municipio(Long codigoMunicipio, Uf uf, String nome, Integer status) {
        this.codigoMunicipio = codigoMunicipio;
        this.uf = uf;
        this.nome = nome;
        this.status = status;
    }

    public Long getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(Long codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public Uf getUf() {
        return uf;
    }

    public void setUf(Uf uf) {
        this.uf = uf;
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

    public List<Bairro> getBairros() {
        return bairros;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Municipio municipio = (Municipio) object;
        return Objects.equals(codigoMunicipio, municipio.codigoMunicipio);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigoMunicipio);
    }
}

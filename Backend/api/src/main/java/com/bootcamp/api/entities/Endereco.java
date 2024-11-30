package com.bootcamp.api.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_ENDERECO")
    private Long codigoEndereco;

    @ManyToOne
    @JoinColumn(name = "CODIGO_PESSOA")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "CODIGO_BAIRRO")
    private Bairro bairro;

    @Column(name = "NOME_RUA")
    private String nomeRua;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;

    @Column(name = "CEP")
    private String cep;

    public Endereco() {
    }

    public Endereco(Long codigoEndereco, Pessoa pessoa, Bairro bairro, String nomeRua, Integer numero, String complemento, String cep) {
        this.codigoEndereco = codigoEndereco;
        this.pessoa = pessoa;
        this.bairro = bairro;
        this.nomeRua = nomeRua;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
    }

    public Long getCodigoEndereco() {
        return codigoEndereco;
    }

    public void setCodigoEndereco(Long codigoEndereco) {
        this.codigoEndereco = codigoEndereco;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Endereco endereco = (Endereco) object;
        return Objects.equals(codigoEndereco, endereco.codigoEndereco);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigoEndereco);
    }
}

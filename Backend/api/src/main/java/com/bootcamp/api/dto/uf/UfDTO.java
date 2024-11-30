package com.bootcamp.api.dto.uf;

import jakarta.validation.constraints.*;

public class UfDTO {

    @NotBlank(message = "O campo codigoUF não pode estar nulo ou vazio.")
    @Positive(message = "O campo codigoUF precisa conter um número positivo.")
    private Long codigoUF;

    @NotBlank(message = "O campo sigla não pode estar nulo ou vazio.")
    @Size(min = 2, max = 2)
    private String sigla;

    @NotBlank(message = "O campo nome não pode estar nulo ou vazio.")
    private String nome;

    @NotBlank(message = "O campo status não pode estar nulo ou ser vazio.")
    private Integer status;

    public UfDTO(Long codigoUF, String sigla, String nome, Integer status) {
        this.codigoUF = codigoUF;
        this.sigla = sigla;
        this.nome = nome;
        this.status = status;
    }

    public Long getCodigoUF() {
        return codigoUF;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public Integer getStatus() {
        return status;
    }
}

package com.bootcamp.api.dto.uf;

import jakarta.validation.constraints.*;

public class UfDTO {

    private Long codigoUF;

    @NotBlank(message = "O campo sigla não pode estar nulo ou vazio.")
    @Size(min = 2, max = 2, message = "O campo sigla deve conter 2 caracteres.")
    private String sigla;

    @NotBlank(message = "O campo nome não pode estar nulo ou vazio.")
    private String nome;

    @NotNull(message = "O campo status não pode estar nulo.")
    @Min(value = 1, message = "O valor mínimo do campo status deve ser 1.")
    @Max(value = 2, message = "O valor máximo do campo status deve ser 2.")
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

package com.bootcamp.api.dto.uf;

import jakarta.validation.constraints.*;

public class UfDTO {

    private Long codigoUF;

    @NotBlank(message = "O campo sigla não pode estar nulo ou vazio.")
    @Size(min = 2, max = 2, message = "O campo sigla deve conter 2 caracteres.")
    private String sigla;

    @NotBlank(message = "O campo nome não pode estar nulo ou vazio.")
    private String nome;

    @NotBlank(message = "O campo status não pode estar nulo.")
    private String status;

    public UfDTO(Long codigoUF, String sigla, String nome, String status) {
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

    public String getStatus() {
        return status;
    }
}

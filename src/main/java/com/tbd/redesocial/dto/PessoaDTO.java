package com.tbd.redesocial.dto;

import java.time.LocalDate;

public record PessoaDTO(String cpf, String nome, String email, String senha, LocalDate dataNascimento) {
}

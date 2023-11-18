package com.tbd.redesocial.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import com.tbd.redesocial.dto.PessoaDTO;

import lombok.Data;
import lombok.NoArgsConstructor;
@Node
@Data
@NoArgsConstructor
public class Pessoa {
    
    @Id
    @GeneratedValue
    private Long id;

    private String cpf;

    private String nome;

    private String email;

    private String senha;

    private LocalDate dataNascimento;
    
    @Relationship(type = "AMIZADE")
    private List<Pessoa> amizades;

    public Pessoa(PessoaDTO dto) {
        this.cpf = dto.cpf();
        this.nome = dto.nome();
        this.email = dto.email();
        this.senha = dto.senha();
        this.dataNascimento = dto.dataNascimento();
    }

}

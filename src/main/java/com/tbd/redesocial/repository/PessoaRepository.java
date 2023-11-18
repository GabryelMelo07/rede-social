package com.tbd.redesocial.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.tbd.redesocial.model.Pessoa;

public interface PessoaRepository extends Neo4jRepository<Pessoa, Long> {
    Pessoa findByNome(String nome);
}

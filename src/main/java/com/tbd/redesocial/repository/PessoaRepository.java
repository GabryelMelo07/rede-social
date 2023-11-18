package com.tbd.redesocial.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.tbd.redesocial.model.Pessoa;

public interface PessoaRepository extends Neo4jRepository<Pessoa, Long> {
    @Query("MATCH (pessoa:Pessoa)-[:AMIZADE]-(amigos:Pessoa) WHERE ID(pessoa) = $pessoaId RETURN DISTINCT amigos")
    List<Pessoa> listarAmigos(Long pessoaId);
}

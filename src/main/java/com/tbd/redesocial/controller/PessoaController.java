package com.tbd.redesocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tbd.redesocial.dto.PessoaDTO;
import com.tbd.redesocial.model.Pessoa;
import com.tbd.redesocial.service.interfaces.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll() {
        List<Pessoa> pessoas = pessoaService.getAll();
        return ResponseEntity.ok().body(pessoas);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getById(@PathVariable long id) {
        Pessoa pessoa = pessoaService.getById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody PessoaDTO dto) {
        Pessoa pessoa = pessoaService.save(dto);
        return ResponseEntity.ok().body(pessoa);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable long id, @RequestBody PessoaDTO dto) {
        Pessoa pessoa = pessoaService.update(id, dto);
        return ResponseEntity.ok().body(pessoa);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        boolean deletado = pessoaService.delete(id);
        HttpStatus status = deletado ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Boolean>(deletado, status);
    }

    @PostMapping("/{pessoaId}/adicionar-amigo")
    public ResponseEntity<Pessoa> addAmizade(@PathVariable long pessoaId, @RequestParam long novaAmizadeId) {
        Pessoa pessoa = pessoaService.addAmizade(pessoaId, novaAmizadeId);
        return ResponseEntity.ok().body(pessoa);
    }

    @DeleteMapping("/{pessoaId}/remover-amigo")
    public ResponseEntity<Pessoa> removeAmizade(@PathVariable long pessoaId, @RequestParam long novaAmizadeId) {
        Pessoa pessoa = pessoaService.removeAmizade(pessoaId, novaAmizadeId);
        return ResponseEntity.ok().body(pessoa);
    }

    @GetMapping("{pessoaId}/amigos")
    public ResponseEntity<List<Pessoa>> getAllAmizades(@PathVariable long pessoaId) {
        List<Pessoa> amigos = pessoaService.listarAmigos(pessoaId);
        return ResponseEntity.ok().body(amigos);
    }
    
}

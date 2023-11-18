package com.tbd.redesocial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbd.redesocial.dto.PessoaDTO;
import com.tbd.redesocial.model.Pessoa;
import com.tbd.redesocial.repository.PessoaRepository;
import com.tbd.redesocial.service.interfaces.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public List<Pessoa> getAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa getById(long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa inexistente."));
    }

    @Override
    public Pessoa save(PessoaDTO dto) {
        Pessoa p = new Pessoa(dto);
        return pessoaRepository.save(p);
    }

    @Override
    public Pessoa update(long id, PessoaDTO dto) {
        Pessoa pessoa = getById(id);
        pessoa.setCpf(dto.cpf());
        pessoa.setNome(dto.nome());
        pessoa.setEmail(dto.email());
        pessoa.setSenha(dto.senha());
        pessoa.setDataNascimento(dto.dataNascimento());
        return pessoaRepository.save(pessoa);
    }

    @Override
    public boolean delete(long id) {
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
            return true;
        } else {
            throw new RuntimeException("Pessoa inexistente.");
        }
    }

    @Override
    public Pessoa addAmizade(long pessoaId, long novaAmizadeId) {
        Pessoa pessoa = getById(pessoaId);
        Pessoa novaAmizade = getById(novaAmizadeId);
        pessoa.getAmizades().add(novaAmizade);
        novaAmizade.getAmizades().add(pessoa);
        pessoaRepository.save(pessoa);
        pessoaRepository.save(novaAmizade);
        return pessoa;
    }

    @Override
    public Pessoa removeAmizade(long pessoaId, long novaAmizadeId) {
        Pessoa pessoa = getById(pessoaId);
        Pessoa novaAmizade = getById(novaAmizadeId);
        pessoa.getAmizades().remove(novaAmizade);
        novaAmizade.getAmizades().remove(pessoa);
        pessoaRepository.save(pessoa);
        pessoaRepository.save(novaAmizade);
        return pessoa;
    }

}

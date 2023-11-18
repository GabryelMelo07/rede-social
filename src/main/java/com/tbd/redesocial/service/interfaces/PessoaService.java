package com.tbd.redesocial.service.interfaces;

import java.util.List;

import com.tbd.redesocial.dto.PessoaDTO;
import com.tbd.redesocial.model.Pessoa;

public interface PessoaService extends CrudService<Pessoa, PessoaDTO> {
    Pessoa addAmizade(long pessoaId, long novaAmizadeId);
    Pessoa removeAmizade(long pessoaId, long amizadeParaRemoverId);
    List<Pessoa> listarAmigos(long pessoaId);
}

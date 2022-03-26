package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.infraestructure.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha){
        return cozinhaRepository.adicionar(cozinha);
    }
    public Cozinha excluir(Long id) {
        try {
            cozinhaRepository.remover(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format("Não existe cozinha com código %d", id));
        }
        catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format("Não é possível excluir uma cozinha em uso: Cozinha -> %d", id));
        }
        return null;
    }
}

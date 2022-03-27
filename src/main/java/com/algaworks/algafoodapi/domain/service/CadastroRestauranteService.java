package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.infraestructure.repository.CozinhaRepository;
import com.algaworks.algafoodapi.infraestructure.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CadastroRestauranteService {

    @Autowired
    RestauranteRepository restauranteRepository;

    @Autowired
    CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante) {
        if(restaurante == null){
            throw new IllegalArgumentException("O restaurante não pode ser nulo");
        }
        if(cozinhaRepository.buscar(restaurante.getCozinha().getId()) == null){
            throw new EntidadeNaoEncontradaException("Cozinha não encontrada");
        }
        return restauranteRepository.adicionar(restaurante);
    }

    public void excluir(Long id) {
        try {
            restauranteRepository.remover(id);
            ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe restaurante com código %d", id));
        }
        catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format("Não é possível excluir. Restaurante em uso: Cozinha -> %d", id));
        }
    }
}

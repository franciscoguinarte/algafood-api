package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.infraestructure.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    RestauranteRepository restauranteRepository;

    public Restaurante salvar(Restaurante restaurante) {
        return restauranteRepository.adicionar(restaurante);
    }

    public void excluir(Long id) {
        try {
            restauranteRepository.remover(id);
            ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe restaurante com código %d", id));
        }
        catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format("Não é possível excluir. Restaurante em uso: Cozinha -> %d", id));
        }
    }
}

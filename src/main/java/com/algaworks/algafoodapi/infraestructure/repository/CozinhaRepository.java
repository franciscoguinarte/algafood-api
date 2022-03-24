package com.algaworks.algafoodapi.infraestructure.repository;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRepository {

    public List<Cozinha> listar();
    public Cozinha adicionar(Cozinha cozinha);
    public Cozinha buscar(Long id);
    public void remover(Long id);
}

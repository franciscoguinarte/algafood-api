package com.algaworks.algafoodapi.infraestructure.repository;

import com.algaworks.algafoodapi.domain.model.Cidade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository {

    public List<Cidade> listar();
    public Cidade adicionar(Cidade cidade);
    public Cidade buscar(Long id);
    public void remover(Long id);

}

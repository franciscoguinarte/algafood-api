package com.algaworks.algafoodapi.infraestructure.repository;

import com.algaworks.algafoodapi.domain.model.Restaurante;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestauranteRepository {

    public List<Restaurante> listar();
    public Restaurante buscar(Long id);
    public Restaurante adicionar(Restaurante restaurante);
    public void remover(Long id);
}

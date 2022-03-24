package com.algaworks.algafoodapi.infraestructure.repository;

import com.algaworks.algafoodapi.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    public List<Restaurante> listar();
    public Restaurante buscar(Long id);
    public Restaurante adicinar(Restaurante restaurante);
    public void remover(Long id);
}

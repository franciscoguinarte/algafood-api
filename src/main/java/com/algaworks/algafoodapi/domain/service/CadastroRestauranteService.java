package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.infraestructure.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    RestauranteRepository restauranteRepository;

    public Restaurante salvar(Restaurante restaurante) {
        return restauranteRepository.adicionar(restaurante);
    }
}

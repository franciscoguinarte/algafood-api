package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.infraestructure.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha){
        return cozinhaRepository.adicionar(cozinha);
    }
}

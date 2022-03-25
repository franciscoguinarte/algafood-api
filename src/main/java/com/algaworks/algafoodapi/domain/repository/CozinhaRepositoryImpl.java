package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.infraestructure.repository.CozinhaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cozinha> listar(){
        return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
    }

    @Transactional
    public Cozinha adicionar(Cozinha cozinha){
        return manager.merge(cozinha);
    }

    @Override
    public Cozinha buscar(Long id) {
        return manager.find(Cozinha.class,id);
    }

    @Transactional
    @Override
    public void remover(Long id) {
        Cozinha cozinha = manager.find(Cozinha.class,id);
        if( cozinha == null){
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(cozinha);
    }
}

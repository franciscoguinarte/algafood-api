package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.model.Estado;
import com.algaworks.algafoodapi.infraestructure.repository.EstadoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Estado> listar(){
        return manager.createQuery("from Estado", Estado.class).getResultList();
    }

    @Transactional
    public Estado adicionar(Estado estado){
        return manager.merge(estado);
    }

    @Override
    public Estado buscar(Long id) {
        return manager.find(Estado.class,id);
    }

    @Override
    public void remover(Long id) {
        Estado estado =  manager.find(Estado.class,id);
        manager.remove(estado);
    }


}

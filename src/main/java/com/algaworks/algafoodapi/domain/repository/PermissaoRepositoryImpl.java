package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.model.Permissao;
import com.algaworks.algafoodapi.infraestructure.repository.PermissaoRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PermissaoRepositoryImpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Permissao> listar() {
        return manager.createQuery("from Permissao", Permissao.class).getResultList();
    }

    @Override
    public Permissao buscar(Long id) {
        return manager.find(Permissao.class,id);
    }

    @Override
    @Transactional
    public void remover(Long id) {
        Permissao permissao = manager.find(Permissao.class,id);
        manager.remove(permissao);
    }

    @Transactional
    public Permissao adicionar(Permissao permissao) {
        return manager.merge(permissao);
    }
}

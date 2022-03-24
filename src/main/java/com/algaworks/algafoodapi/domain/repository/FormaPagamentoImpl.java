package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.model.FormaPagamento;
import com.algaworks.algafoodapi.infraestructure.repository.FormaPagamentoRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class FormaPagamentoImpl implements FormaPagamentoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<FormaPagamento> listar(){
        return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
    }

    @Transactional
    public FormaPagamento adicionar(FormaPagamento formaPagamento){
        return manager.merge(formaPagamento);
    }

    @Override
    public FormaPagamento buscar(Long id) {
        return manager.find(FormaPagamento.class,id);
    }

    @Override
    @Transactional
    public void remover(Long id) {
        FormaPagamento formaPagamento = manager.find(FormaPagamento.class,id);
        manager.remove(formaPagamento);
    }
}

package com.algaworks.algafoodapi.infraestructure.repository;

import com.algaworks.algafoodapi.domain.model.FormaPagamento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormaPagamentoRepository {

    public List<FormaPagamento> listar();
    public FormaPagamento buscar(Long id);
    public FormaPagamento adicionar(FormaPagamento formaPagamento);
    public void remover(Long id);
}

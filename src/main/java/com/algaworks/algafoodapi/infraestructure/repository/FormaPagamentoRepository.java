package com.algaworks.algafoodapi.infraestructure.repository;

import com.algaworks.algafoodapi.domain.model.FormaPagamento;

import java.util.List;

public interface FormaPagamentoRepository {

    public List<FormaPagamento> listar();
    public FormaPagamento buscar(Long id);
    public FormaPagamento adicionar(FormaPagamento formaPagamento);
    public void excluir(Long id);
}

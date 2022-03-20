package com.algaworks.algafoodapi.infraestructure.repository;

import com.algaworks.algafoodapi.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    public List<Permissao> listar();
    public Permissao buscar(Long id);
    public void excluir(Long id);
    public Permissao adicionar(Permissao permissao);

}

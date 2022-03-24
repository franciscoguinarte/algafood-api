package com.algaworks.algafoodapi.infraestructure.repository;

import com.algaworks.algafoodapi.domain.model.Permissao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoRepository {

    public List<Permissao> listar();
    public Permissao buscar(Long id);
    public Permissao adicionar(Permissao permissao);
    public void remover(Long id);

}

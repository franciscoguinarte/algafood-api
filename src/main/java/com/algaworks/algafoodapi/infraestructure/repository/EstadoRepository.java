package com.algaworks.algafoodapi.infraestructure.repository;

import com.algaworks.algafoodapi.domain.model.Estado;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository {

    public List<Estado> listar();
    public Estado buscar(Long id);
    public Estado adicionar(Estado estado);
    public void remover(Long id);

}

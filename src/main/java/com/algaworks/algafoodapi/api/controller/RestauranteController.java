package com.algaworks.algafoodapi.api.controller;

import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.infraestructure.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Restaurante restaurante = restauranteRepository.buscar(id);
        if (id == null ||  restaurante == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(restaurante);
    }

    @GetMapping
    public List<Restaurante> listar() {
        List<Restaurante> restaurantes = restauranteRepository.listar();
        return ResponseEntity.status(HttpStatus.OK).body(restaurantes).getBody();
    }
}

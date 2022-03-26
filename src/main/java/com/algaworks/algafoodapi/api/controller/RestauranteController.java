package com.algaworks.algafoodapi.api.controller;

import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.domain.service.CadastroRestauranteService;
import com.algaworks.algafoodapi.infraestructure.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroRestauranteService cadastroRestauranteService;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante adicionar(@RequestBody Restaurante restaurante) {
        return cadastroRestauranteService.salvar(restaurante);
    }

}

package com.algaworks.algafoodapi.jpa.restaurante;

import com.algaworks.algafoodapi.AlgafoodApiApplication;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepositoryImpl;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class BuscarRestaurantePorId {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepositoryImpl cadastroCozinha = applicationContext.getBean(CozinhaRepositoryImpl.class);

        Cozinha cozi = cadastroCozinha.buscar(1L);
        List<Cozinha> cozi2 = cadastroCozinha.listar();

        System.out.println(cozi.getNome());

        for(Cozinha cozinhas : cozi2){
            System.out.println(cozinhas.getNome());
        }
//        System.out.println(cozi.getNome());
    }
}

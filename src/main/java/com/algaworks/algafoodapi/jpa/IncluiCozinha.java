package com.algaworks.algafoodapi.jpa;

import com.algaworks.algafoodapi.AlgafoodApiApplication;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepositoryImpl;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class IncluiCozinha {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepositoryImpl cadastroCozinha = applicationContext.getBean(CozinhaRepositoryImpl.class);

        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("Africana");
        cadastroCozinha.adicionar(cozinha1);

        Cozinha cozinha2 = new Cozinha();
        cozinha2.setNome("Carlos");
        cadastroCozinha.adicionar(cozinha2);
    }
}

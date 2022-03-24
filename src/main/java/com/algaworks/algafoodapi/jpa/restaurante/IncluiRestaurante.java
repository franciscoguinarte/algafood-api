package com.algaworks.algafoodapi.jpa.restaurante;

import com.algaworks.algafoodapi.AlgafoodApiApplication;
import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepositoryImpl;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class IncluiRestaurante {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepositoryImpl restauranteRepository = applicationContext.getBean(RestauranteRepositoryImpl.class);

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNome("Abajur Restaurante");
        restaurante1.setTaxaFrete(BigDecimal.valueOf(123.444));
        restauranteRepository.adicinar(restaurante1);

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNome("Restaurante do Quilao");
        restaurante2.setTaxaFrete(BigDecimal.valueOf(2));
        restauranteRepository.adicinar(restaurante2);


    }
}

package com.algaworks.algafoodapi.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    //Muitas cidades possuem unico estado, ou seja
    //Para cada estado, eu posso ter um ou mais cidades
    @ManyToOne
    private Estado estado;
}

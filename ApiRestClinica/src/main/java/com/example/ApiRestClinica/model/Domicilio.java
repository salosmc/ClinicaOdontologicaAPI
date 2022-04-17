package com.example.ApiRestClinica.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity

public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //como se va a generar ese id
    private Long id;

    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

}

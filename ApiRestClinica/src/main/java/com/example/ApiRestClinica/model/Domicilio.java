package com.example.ApiRestClinica.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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

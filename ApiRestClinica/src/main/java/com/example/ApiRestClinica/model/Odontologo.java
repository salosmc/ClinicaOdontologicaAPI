package com.example.ApiRestClinica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/*Facilidades de lombok como los getters y setters*/
//@Data

@Getter
@Setter

/*Cosas de JPA para la BD*/
@Entity //declaramos que es una entidad
//@Table //y que va a ser una tabla en bd

public class Odontologo {
    @Id //define el id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //como se va a generar ese id
    //@Setter(AccessLevel.NONE)
    private Long id;

    private String nombre;
    private String apellido;
    private String matricula;

    @OneToMany(mappedBy = "odontologo",fetch= FetchType.EAGER)//
    //@JoinColumn(name = "fk_turnos_odontologo",referencedColumnName = "id")
    @JsonIgnore
    private Set<Turno> turnos;// = new ArrayList<Turno>();

    public Odontologo() {
    }

    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Odontologo(Long id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

}


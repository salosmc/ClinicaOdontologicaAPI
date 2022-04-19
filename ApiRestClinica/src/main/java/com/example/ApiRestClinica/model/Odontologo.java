package com.example.ApiRestClinica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

/*Facilidades de lombok como los getters y setters*/
//@Data

@Getter
@Setter
@NoArgsConstructor

@AllArgsConstructor //no puedo omitir el id como arg en el constructor

/*Cosas de JPA para la BD*/
@Entity //declaramos que es una entidad
//@Table //y que va a ser una tabla en bd

public class Odontologo {
    @Id //define el id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //como se va a generar ese id
    private Long id;

    private String nombre;
    private String apellido;
    private String matricula;

    @OneToMany(mappedBy = "odontologo")
    //@JoinColumn(name = "fk_turnos_odontologo",referencedColumnName = "id")
    @JsonIgnore
    private Set<Turno> turnos;// = new ArrayList<Turno>();

}


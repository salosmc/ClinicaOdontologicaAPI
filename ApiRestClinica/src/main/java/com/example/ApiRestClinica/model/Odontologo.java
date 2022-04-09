package com.example.ApiRestClinica.model;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;

/*Facilidades de lombok como los getters y setters*/
@Data
/*
@Getter
@Setter
@NoArgsConstructor
*/
//@AllArgsConstructor //no puedo omitir el id como arg en el constructor

/*Cosas de JPA para la BD*/
@Entity //declaramos que es una entidad
@Table //y que va a ser una tabla en bd

public class Odontologo {
    @Id //define el id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //como se va a generar ese id
    private Long id;

    private String nombre;
    private String apellido;
    private String matricula;

    //Creo el constructr a manopla por que no se como omitir el id
    public Odontologo() {
    }

    //por las dudas sobreescribo el setId, ya que no deberia poder setearlo
    //@Override

/*
    //Metodos útiles
    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Odontologo that = (Odontologo) o;
        return Objects.equals(id, that.id) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(matricula, that.matricula);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, matricula);
    }
*/
    //el @Data trae toda esta mierda
}


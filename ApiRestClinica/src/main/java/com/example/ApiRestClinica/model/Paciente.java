package com.example.ApiRestClinica.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity

public class Paciente {
    @Id //define el id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //como se va a generar ese id
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaAlta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_direccion", referencedColumnName = "id")
    private Domicilio domicilio;

}

package com.example.ApiRestClinica.dto;

import com.example.ApiRestClinica.model.Domicilio;
import com.example.ApiRestClinica.model.Turno;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PacienteDTO {

    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaAlta;
    private Domicilio domicilio;

    private Set<Turno> turnos;

}
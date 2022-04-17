package com.example.ApiRestClinica.dto;

import com.example.ApiRestClinica.model.Domicilio;
import lombok.*;

import java.time.LocalDate;

@Data

public class PacienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaAlta;
    private Domicilio domicilio;

}
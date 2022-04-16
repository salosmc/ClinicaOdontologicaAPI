package com.example.ApiRestClinica.dto;

import lombok.*;

@Getter
@Setter

public class PacienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String domicilio;

    public PacienteDTO() {
    }
}
package com.example.ApiRestClinica.dto;

import lombok.*;

@Getter
@Setter

public class OdontologoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    public OdontologoDTO() {
    }
}

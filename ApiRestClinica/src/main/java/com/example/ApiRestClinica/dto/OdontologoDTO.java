package com.example.ApiRestClinica.dto;

import com.example.ApiRestClinica.model.Turno;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OdontologoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    private Set<Turno> turnos;

}

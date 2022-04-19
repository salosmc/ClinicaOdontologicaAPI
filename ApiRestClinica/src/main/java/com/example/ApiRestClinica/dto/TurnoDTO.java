package com.example.ApiRestClinica.dto;

import com.example.ApiRestClinica.model.Odontologo;
import com.example.ApiRestClinica.model.Paciente;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class TurnoDTO {
    private Long id;
    private LocalDate fecha;
    private LocalTime hora;
    private Paciente paciente;
    private Odontologo odontologo;
}

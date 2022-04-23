package com.example.ApiRestClinica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor

@AllArgsConstructor //no puedo omitir el id como arg en el constructor

@Entity

public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private LocalDate fecha;
    private LocalTime hora;

    @ManyToOne(fetch= FetchType.EAGER)//(cascade = CascadeType.PERSIST)//Me permite evitar que elimien algun odontologo cuando eliminan algun turno
    @JoinColumn(name = "odontologo_id",referencedColumnName = "id")
    @JsonIgnore
    private Odontologo odontologo;

    @ManyToOne(fetch= FetchType.EAGER)//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "paciente_id",referencedColumnName = "id")
    @JsonIgnore
    private Paciente paciente;

}
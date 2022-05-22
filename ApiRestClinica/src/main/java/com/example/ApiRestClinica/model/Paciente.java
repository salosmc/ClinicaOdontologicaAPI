package com.example.ApiRestClinica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@AllArgsConstructor //no puedo omitir el id como arg en el constructor

@Entity

public class Paciente {
    @Id //define el id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //como se va a generar ese id
    //@Setter(AccessLevel.NONE)//evito que se pueda setear
    private Long id;

    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaAlta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_direccion", referencedColumnName = "id")
    @JsonIgnore
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente",fetch= FetchType.EAGER)
    //@JoinColumn(name = "fk_turnos_paciente", referencedColumnName = "id")
    @JsonIgnore
    private Set<Turno> turnos ;

}

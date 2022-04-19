package com.example.ApiRestClinica.mvc.service;

import com.example.ApiRestClinica.dto.TurnoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    private PacienteService pacienteService;

    @Test
    void findById() {
    }

    @Test
    void create() {
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setFecha(LocalDate.parse("2022-04-17"));
        turnoDTO.setHora(LocalTime.parse("19:04"));

        assertEquals(true,turnoService.create(turnoDTO)!=null);

    }

    @Test
    void deleteById() {
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
    }
}
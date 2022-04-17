package com.example.ApiRestClinica.mvc.service;

import com.example.ApiRestClinica.dto.PacienteDTO;
import com.example.ApiRestClinica.model.Domicilio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteServiceTest {
    @Autowired
    private PacienteService pacienteService;

    @Test
    void findById() {
    }

    @Test
    void create() {
        PacienteDTO pacienteDTO = new PacienteDTO();

        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("siempre viva");
        domicilio.setNumero("124");
        domicilio.setLocalidad("Sprinfid");
        domicilio.setProvincia("Fox");

        pacienteDTO.setNombre("Andrea");
        pacienteDTO.setApellido("Colodro");
        pacienteDTO.setDni("98543213");
        //pacienteDTO.setFechaAlta("2022-04-17");
        pacienteDTO.setDomicilio(domicilio);

        assertEquals(true,pacienteService.create(pacienteDTO)!=null);
    }

    @Test
    void deleteById() {
        pacienteService.deleteById(2L);
        assertEquals(false,pacienteService.findById(2L)!=null);
    }

    @Test
    void update() {
        PacienteDTO pacienteDTO = pacienteService.findById(1L);
        pacienteDTO.setNombre("Eli");
        assertEquals("Eli", pacienteService.update(pacienteDTO).getNombre());
    }

    @Test
    void findAll() {
        List<PacienteDTO> pacientesDTO = pacienteService.findAll();
        assertEquals(2, pacientesDTO.size());
    }
}
package com.example.ApiRestClinica.mvc.serviceTestsUnitarios;

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

    public PacienteDTO loadPacienteDTO(){
        PacienteDTO paciente = new PacienteDTO();

        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("calle 165A");
        domicilio.setNumero("5828");
        domicilio.setLocalidad("Berazategui");
        domicilio.setProvincia("Buenos Aires");

        paciente.setId(1L);
        paciente.setNombre("Facu");
        paciente.setApellido("Colodro");
        paciente.setDni("87654328");
        paciente.setFechaAlta(LocalDate.parse("2022-04-17"));
        paciente.setDomicilio(domicilio);

        return paciente;
    }

    @Test
    void create() {
        PacienteDTO paciente = loadPacienteDTO();
        assertTrue(pacienteService.create(paciente) != null);
    }

    @Test
    void findById() {
        Long id = loadPacienteDTO().getId();
        assertTrue(pacienteService.findById(id)!=null);
    }

    @Test
    void update() {
        PacienteDTO paciente = loadPacienteDTO();
        paciente.setNombre(" ");

        PacienteDTO resPaciente = pacienteService.update(paciente);
        assertEquals(paciente.getNombre(), resPaciente.getNombre());
    }

    @Test
    void findAll() {
        List<PacienteDTO> pacientes = pacienteService.findAll();
        assertFalse(pacientes.isEmpty());
    }

    @Test
    void deleteById() {
        Long id = loadPacienteDTO().getId();
        pacienteService.deleteById(id);
        assertFalse(pacienteService.findById(id)!=null);
    }

}
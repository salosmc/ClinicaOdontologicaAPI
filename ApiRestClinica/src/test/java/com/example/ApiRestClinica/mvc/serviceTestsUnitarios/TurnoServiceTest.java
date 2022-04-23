package com.example.ApiRestClinica.mvc.serviceTestsUnitarios;

import com.example.ApiRestClinica.dto.TurnoDTO;
import com.example.ApiRestClinica.model.Odontologo;
import com.example.ApiRestClinica.model.Paciente;
import com.example.ApiRestClinica.mvc.repository.IOdontologoRepository;
import com.example.ApiRestClinica.mvc.repository.IPacienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TurnoServiceTest {

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    private IPacienteRepository pacienteRepository;


    public TurnoDTO loadTurnoDTO(){
        TurnoDTO turno = new TurnoDTO();

        turno.setId(1L);
        turno.setFecha(LocalDate.parse("2022-04-17"));
        turno.setHora(LocalTime.parse("19:51"));

        Odontologo odontologo = odontologoRepository.save(new Odontologo());
        turno.setOdontologo(odontologo);

        Paciente paciente = pacienteRepository.save(new Paciente());
        turno.setPaciente(paciente);

        return turno;
    }

    @Test
    void create() {
        TurnoDTO turno = loadTurnoDTO();
        assertTrue(turnoService.create(turno)!=null);
    }

    @Test
    void findById() {
        Long id = loadTurnoDTO().getId();
        assertTrue(turnoService.findById(id)!=null);
    }

    @Test
    void update() {
        TurnoDTO turno = loadTurnoDTO();
        turno.setHora(LocalTime.parse("00:00"));

        TurnoDTO resTurno = turnoService.update(turno);
        assertEquals(turno.getHora(),resTurno.getHora());
    }

    @Test
    void findAll() {
        List<TurnoDTO> turnos = turnoService.findAll();
        assertFalse(turnos.isEmpty());
    }

    @Test
    void deleteById() {
        Long id = loadTurnoDTO().getId();
        turnoService.deleteById(id);
        assertFalse(turnoService.findById(id)!=null);
    }
}
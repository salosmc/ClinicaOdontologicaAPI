package com.example.ApiRestClinica.mvc.service;


import com.example.ApiRestClinica.dto.OdontologoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class OdontologoServiceTest {
    @Autowired
    private OdontologoService odontologoService;

    @Test
    void findById() {
        OdontologoDTO odontologoDTO = odontologoService.findById(1L);
        assertEquals(1L,odontologoDTO.getId());
    }

    @Test
    void create() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Jorge");
        odontologoDTO.setApellido("Roberto");
        odontologoDTO.setMatricula("456");

        assertEquals( true,odontologoService.create(odontologoDTO) != null);
    }

    @Test
    void deleteById() {
        odontologoService.deleteById(1L);
        assertEquals(false, odontologoService.findById(1L) != null );
    }

    @Test
    void update() {
        OdontologoDTO odontologoDTO = odontologoService.findById(2L);
        odontologoDTO.setMatricula("555");
        assertEquals(true, odontologoService.update(odontologoDTO) != null);
    }

    @Test
    void findAll() {
        assertEquals(true, odontologoService.findAll() != null);
    }
}
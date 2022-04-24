package com.example.ApiRestClinica.mvc.service;

import com.example.ApiRestClinica.dto.OdontologoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    public OdontologoDTO loadOdontologoDTO(){
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setId(1L);
        odontologoDTO.setNombre("Jorge");
        odontologoDTO.setApellido("Roberto");
        odontologoDTO.setMatricula("456");
        return odontologoDTO;
    }

    @Test
    void create() {
        OdontologoDTO odontologoDTO = odontologoService.create(loadOdontologoDTO());
        assertTrue(odontologoDTO != null);
    }

    @Test
    void findById() {
        Long id = loadOdontologoDTO().getId();
        assertTrue(odontologoService.findById(id)!=null);
    }

    @Test
    void update() {
        OdontologoDTO odontologo = loadOdontologoDTO();
        odontologo.setMatricula(" ");
        OdontologoDTO resOdontologo = odontologoService.update(odontologo);
        assertTrue(resOdontologo.getMatricula() != loadOdontologoDTO().getMatricula());
    }

    @Test
    void findAll() {
        List<OdontologoDTO> odontologos= odontologoService.findAll();
        assertFalse( odontologos.isEmpty());
    }

    @Test
    void deleteById() {
        Long id = loadOdontologoDTO().getId();
        odontologoService.deleteById(id);
        assertFalse(odontologoService.findById(id) != null );
    }

}
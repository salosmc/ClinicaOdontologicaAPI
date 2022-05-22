package com.example.ApiRestClinica.service;

import com.example.ApiRestClinica.dto.OdontologoDTO;
import com.example.ApiRestClinica.exceptions.ResourceNotFoundException;
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
    void create() throws ResourceNotFoundException {
        OdontologoDTO odontologoDTO = odontologoService.create(loadOdontologoDTO());
        assertTrue(odontologoDTO != null);
    }

    @Test
    void findById() throws ResourceNotFoundException {
        Long id = loadOdontologoDTO().getId();
        assertTrue(odontologoService.findById(id)!=null);
    }

    @Test
    void update() throws ResourceNotFoundException {
        OdontologoDTO odontologo = loadOdontologoDTO();
        odontologo.setMatricula(" ");
        OdontologoDTO resOdontologo = odontologoService.update(odontologo);
        assertTrue(resOdontologo.getMatricula() != loadOdontologoDTO().getMatricula());
    }

    @Test
    void findAll() throws ResourceNotFoundException {
        List<OdontologoDTO> odontologos= odontologoService.findAll();
        assertFalse( odontologos.isEmpty());
    }

    @Test
    void deleteById() throws ResourceNotFoundException {
        Long id = loadOdontologoDTO().getId();
        odontologoService.deleteById(id);
        assertFalse(odontologoService.findById(id) != null );
    }

}
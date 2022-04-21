package com.example.ApiRestClinica.mvc.service;

import com.example.ApiRestClinica.dto.OdontologoDTO;
import com.example.ApiRestClinica.model.Odontologo;
import com.example.ApiRestClinica.mvc.repository.IOdontologoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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
        OdontologoDTO resOdontologo = odontologoService.findById(id);
        assertEquals(1L,resOdontologo.getId());
    }

    @Test
    void update() {
        OdontologoDTO odontologo = loadOdontologoDTO();
        odontologo.setMatricula(" ");
        OdontologoDTO resOdontologo = odontologoService.update(odontologo);
        assertTrue(resOdontologo.getMatricula() != loadOdontologoDTO().getMatricula());
    }

    @Test
    void deleteById() {
        //Long id = loadOdontologoDTO().getId();
        odontologoService.deleteById(1L);
        assertFalse(odontologoService.findById(1L) != null );
    }

    @Test
    void findAll() {
/*
        MappingException exception = Assertions.assertThrows(MappingException.class, () -> {
            //Code under test

        });
        System.out.println(exception.getCause().getMessage());
        //Assertions.assertEquals("some message", exception.getMessage());
*/
        List<OdontologoDTO> odontologos= odontologoService.findAll();
        assertFalse( odontologos.isEmpty());


    }
}
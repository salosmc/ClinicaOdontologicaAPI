package com.example.ApiRestClinica.controller;

import com.example.ApiRestClinica.dto.PacienteDTO;
import com.example.ApiRestClinica.exceptions.ResourceNotFoundException;
import com.example.ApiRestClinica.service.PacienteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import java.util.List;


@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Pacientes", description = "Gestion de pacientes")
public class PacienteController {

    private static final Logger logger = Logger.getLogger(PacienteService.class);

    @Autowired
    private PacienteService pacienteService;

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable Long id) throws ResourceNotFoundException {

        logger.debug("Buscando paciente por id: "+id);
        PacienteDTO pacienteDTO = pacienteService.findById(id);

        logger.info("Paciente encontrado : "+pacienteDTO.toString());
        return ResponseEntity.ok(pacienteDTO);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<PacienteDTO>> findAll() throws ResourceNotFoundException{

        logger.debug("Buscando todos los pacientes.");
        List<PacienteDTO> pacientesDTO = pacienteService.findAll();

        logger.info("Pacientes encontrados.");
        return ResponseEntity.ok(pacientesDTO);
    }

    @CrossOrigin
    @GetMapping("/{nombre}/{apellido}/{dni}")
    public ResponseEntity<List<PacienteDTO>> findByAll(@PathVariable String nombre,@PathVariable String apellido,@PathVariable String dni) throws ResourceNotFoundException{

        logger.debug("Fintrando pacientes por nombre, apellido y dni : "+nombre+", "+apellido+", "+dni);
        List<PacienteDTO> pacientesDTO = pacienteService.findByAll(nombre, apellido, dni);

        logger.info("Pacientes filtrados.");
        return ResponseEntity.ok(pacientesDTO);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO pacienteDTO) throws ResourceNotFoundException{
        logger.debug("Guardando paciente : "+pacienteDTO.toString());
        PacienteDTO pacienteNewDTO = pacienteService.create(pacienteDTO);

        logger.info("paciente guardado : "+pacienteNewDTO.toString());
        return ResponseEntity.ok(pacienteNewDTO);
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<PacienteDTO> update(@RequestBody PacienteDTO pacienteDTO) throws ResourceNotFoundException{

        logger.debug("Actualizando paciente : "+pacienteDTO.toString());
        PacienteDTO pacienteNewDTO = pacienteService.create(pacienteDTO);

        logger.info("Paciente actualizado : "+pacienteNewDTO.toString());
        return ResponseEntity.ok(pacienteDTO);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws ResourceNotFoundException{

        logger.debug("Eliminando paciente : "+id);
        pacienteService.deleteById(id);

        logger.info("Paciente eliminado");
        return ResponseEntity.ok("Paciente eliminado");
    }

}

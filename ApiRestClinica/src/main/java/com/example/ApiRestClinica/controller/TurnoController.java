package com.example.ApiRestClinica.controller;

import com.example.ApiRestClinica.dto.TurnoDTO;
import com.example.ApiRestClinica.exceptions.ResourceNotFoundException;
import com.example.ApiRestClinica.service.OdontologoService;
import com.example.ApiRestClinica.service.TurnoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Turnos", description = "Gestion de turnos")
public class TurnoController {
    private static final Logger logger = Logger.getLogger(OdontologoService.class);

    @Autowired
    private TurnoService turnoService;

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> findById(@PathVariable Long id) throws ResourceNotFoundException {

        logger.debug("Buscando turno por id : "+id);
        TurnoDTO turnoDTO = turnoService.findById(id);

        logger.info("Turno encontrado : "+turnoDTO.toString());
        return ResponseEntity.ok(turnoDTO);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<TurnoDTO>> findAll() throws ResourceNotFoundException{
        logger.debug("Buscando todos los turnos.");
        List<TurnoDTO> turnosDTO = turnoService.findAll();

        logger.info("Turnos encontrados.");
        return ResponseEntity.ok(turnosDTO);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<TurnoDTO> create(@RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundException{
        logger.debug("Guardando turno : "+turnoDTO.toString());
        TurnoDTO newTurnoDTO = turnoService.create(turnoDTO);

        logger.info("Turno guardado : "+newTurnoDTO.toString());
        return ResponseEntity.ok(newTurnoDTO);
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<TurnoDTO> update(@RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundException{
        logger.debug("Actualizando turno : "+turnoDTO.toString());
        TurnoDTO newTurnoDTO = turnoService.create(turnoDTO);

        logger.info("Turno actualizado : "+newTurnoDTO.toString());
        return ResponseEntity.ok(newTurnoDTO);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws ResourceNotFoundException{

        logger.debug("Eliminando turno : "+id);
        turnoService.deleteById(id);

        logger.info("Turno eliminado.");
        return ResponseEntity.ok("Turno eliminado");
    }

}

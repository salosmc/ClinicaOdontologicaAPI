package com.example.ApiRestClinica.mvc.controller;

import com.example.ApiRestClinica.dto.OdontologoDTO;
import com.example.ApiRestClinica.exceptions.ResourceNotFoundException;
import com.example.ApiRestClinica.mvc.service.OdontologoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private static final Logger logger = Logger.getLogger(OdontologoService.class);

    @Autowired
    private OdontologoService odontologoService;

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> findById(@PathVariable Long id) throws ResourceNotFoundException{

        logger.debug("Buscando odontologo por id : "+id);
        OdontologoDTO odontologoDTO = odontologoService.findById(id);

        logger.info("Odontologo encontrado : "+odontologoDTO.toString());
        return ResponseEntity.ok(odontologoDTO);
    }

    @CrossOrigin
    @GetMapping("/{nombre}/{apellido}/{matricula}")
    public ResponseEntity<List<OdontologoDTO>> findByAll(@PathVariable String nombre,@PathVariable String apellido,@PathVariable String matricula)
    throws ResourceNotFoundException{

        logger.debug("Filtrando odontologos por nombre, apellido y matricula : "+nombre+", "+apellido+", "+matricula);
        List<OdontologoDTO> odontologosDTO = odontologoService.findByAll(nombre,apellido,matricula);

        logger.info("Odontologo encontrado.");
        return ResponseEntity.ok(odontologosDTO);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<OdontologoDTO>> findAll() throws ResourceNotFoundException{
        logger.debug("Buscando todos los odontologos");
        List<OdontologoDTO> odontologosDTO = odontologoService.findAll();

        logger.info("Odontologos encontrados");
        return ResponseEntity.ok(odontologosDTO);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<OdontologoDTO> create(@RequestBody OdontologoDTO odontologoDTO) throws ResourceNotFoundException{
        logger.debug("Guardando odontologo : "+odontologoDTO.toString());
        OdontologoDTO resOdontologDTO = odontologoService.create(odontologoDTO);

        logger.info("Odontologo guardado : "+resOdontologDTO.toString());
        return ResponseEntity.ok(resOdontologDTO);
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<OdontologoDTO> update(@RequestBody OdontologoDTO odontologoDTO) throws ResourceNotFoundException{

        logger.debug("Actualizando odontologo : "+odontologoDTO.toString());
        OdontologoDTO resOdontologDTO = odontologoService.update(odontologoDTO);

        logger.info("Odontologo actualizado : "+resOdontologDTO.toString());
        return ResponseEntity.ok(resOdontologDTO);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws ResourceNotFoundException {

        logger.debug("Eliminando odontologo : "+id);
        odontologoService.deleteById(id);

        logger.info("Odontologo eliminado");
        return ResponseEntity.ok("Odontologo eliminado");
    }

}

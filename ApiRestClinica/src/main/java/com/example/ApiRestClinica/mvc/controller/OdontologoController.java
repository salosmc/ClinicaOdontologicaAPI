package com.example.ApiRestClinica.mvc.controller;

import com.example.ApiRestClinica.dto.OdontologoDTO;
import com.example.ApiRestClinica.mvc.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;
    //Consultar!!! en PG esta Así
    /*
    @Autowired
    ICrudService odontologoService;
     */
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> findById(@PathVariable Long id){
        OdontologoDTO odontologoDTO = odontologoService.findById(id);
        //falta validar
        return ResponseEntity.ok(odontologoDTO);
    }

    @CrossOrigin
    @GetMapping("/{nombre}/{apellido}/{matricula}")
    public ResponseEntity<List<OdontologoDTO>> findByAll(@PathVariable String nombre,@PathVariable String apellido,@PathVariable String matricula){
        List<OdontologoDTO> odontologosDTO = odontologoService.findByAll(nombre,apellido,matricula);
        //falta validar
        return ResponseEntity.ok(odontologosDTO);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<OdontologoDTO>> findAll(){
        List<OdontologoDTO> odontologosDTO = odontologoService.findAll();
        //falta validar
        return ResponseEntity.ok(odontologosDTO);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<OdontologoDTO> create(@RequestBody OdontologoDTO odontologoDTO){
        OdontologoDTO resOdontologDTO = odontologoService.create(odontologoDTO);
        //falta validar
        return ResponseEntity.ok(resOdontologDTO);
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<OdontologoDTO> update(@RequestBody OdontologoDTO odontologoDTO){
        OdontologoDTO resOdontologDTO = odontologoService.update(odontologoDTO);
        //falta validar
        return ResponseEntity.ok(resOdontologDTO);
    }

    @CrossOrigin
    @DeleteMapping
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        odontologoService.deleteById(id);
        //falta validar
        return ResponseEntity.ok("Odontologo eliminado");
    }

}

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

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> findById(@PathVariable Long id){
        OdontologoDTO odontologoDTO = odontologoService.findById(id);
        //falta validar
        return ResponseEntity.ok(odontologoDTO);
    }

    @GetMapping
    public ResponseEntity<List<OdontologoDTO>> findAll(){
        List<OdontologoDTO> odontologosDTO = odontologoService.findAll();
        //falta validar
        return ResponseEntity.ok(odontologosDTO);
    }

    @PostMapping
    public ResponseEntity<OdontologoDTO> create(@RequestBody OdontologoDTO odontologoDTO){
        OdontologoDTO resOdontologDTO = odontologoService.create(odontologoDTO);
        //falta validar
        return ResponseEntity.ok(resOdontologDTO);
    }

    @PutMapping
    public ResponseEntity<OdontologoDTO> update(@RequestBody OdontologoDTO odontologoDTO){
        OdontologoDTO resOdontologDTO = odontologoService.update(odontologoDTO);
        //falta validar
        return ResponseEntity.ok(resOdontologDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        odontologoService.deleteById(id);
        //falta validar
        return ResponseEntity.ok("Odontologo eliminado");
    }

}

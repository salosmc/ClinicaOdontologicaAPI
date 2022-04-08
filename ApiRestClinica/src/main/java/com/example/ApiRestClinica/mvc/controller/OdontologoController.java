package com.example.ApiRestClinica.mvc.controller;

import com.example.ApiRestClinica.dto.OdontologoDTO;
import com.example.ApiRestClinica.mvc.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<OdontologoDTO> create(@RequestBody OdontologoDTO odontologoDTO){
        OdontologoDTO resOdontologDTO = odontologoService.create(odontologoDTO);
        //falta validar
        return ResponseEntity.ok(resOdontologDTO);
    }


}

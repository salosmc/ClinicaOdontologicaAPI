package com.example.ApiRestClinica.mvc.controller;

import com.example.ApiRestClinica.dto.TurnoDTO;
import com.example.ApiRestClinica.mvc.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> findById(@PathVariable Long id){
        TurnoDTO turnoDTO = turnoService.findById(id);
        return ResponseEntity.ok(turnoDTO);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<TurnoDTO>> findAll(){
        List<TurnoDTO> turnosDTO = turnoService.findAll();
        //falta validar
        return ResponseEntity.ok(turnosDTO);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<TurnoDTO> create(@RequestBody TurnoDTO turnoDTO){
        TurnoDTO newTurnoDTO = turnoService.create(turnoDTO);
        return ResponseEntity.ok(newTurnoDTO);
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<TurnoDTO> update(@RequestBody TurnoDTO turnoDTO){
        TurnoDTO newTurnoDTO = turnoService.create(turnoDTO);
        return ResponseEntity.ok(newTurnoDTO);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        turnoService.deleteById(id);
        //falta validar
        return ResponseEntity.ok("Turno eliminado");
    }

}

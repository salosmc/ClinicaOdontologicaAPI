package com.example.ApiRestClinica.mvc.controller;

import com.example.ApiRestClinica.dto.PacienteDTO;
import com.example.ApiRestClinica.mvc.serviceTestsUnitarios.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable Long id){
        PacienteDTO pacienteDTO = pacienteService.findById(id);
        return ResponseEntity.ok(pacienteDTO);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<PacienteDTO>> findAll(){
        List<PacienteDTO> pacientesDTO = pacienteService.findAll();
        //falta validar
        return ResponseEntity.ok(pacientesDTO);
    }


    @CrossOrigin
    @GetMapping("/{nombre}/{apellido}/{dni}")
    public ResponseEntity<List<PacienteDTO>> findByAll(@PathVariable String nombre,@PathVariable String apellido,@PathVariable String dni){
        List<PacienteDTO> pacientesDTO = pacienteService.findByAll(nombre, apellido, dni);
        //falta validar
        return ResponseEntity.ok(pacientesDTO);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<PacienteDTO> create(@RequestBody PacienteDTO pacienteDTO){
        PacienteDTO pacienteNewDTO = pacienteService.create(pacienteDTO);
        return ResponseEntity.ok(pacienteNewDTO);
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<PacienteDTO> update(@RequestBody PacienteDTO pacienteDTO){
        PacienteDTO pacienteNewDTO = pacienteService.create(pacienteDTO);
        return ResponseEntity.ok(pacienteDTO);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        pacienteService.deleteById(id);
        //falta validar
        return ResponseEntity.ok("Paciente eliminado");
    }

}

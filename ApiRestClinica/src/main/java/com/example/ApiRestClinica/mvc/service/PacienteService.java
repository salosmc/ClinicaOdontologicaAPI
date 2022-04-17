package com.example.ApiRestClinica.mvc.service;

import com.example.ApiRestClinica.dto.PacienteDTO;
import com.example.ApiRestClinica.model.Paciente;
import com.example.ApiRestClinica.mvc.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements ICrudService<PacienteDTO>{

    @Autowired//repository vamos a heredar todos lo metodos de RPA
    private IPacienteRepository pacienteRepository;

    @Autowired//mapper nos va a permitir pasar de la ENTIDAD a DTO y viceversa
    ObjectMapper mapper;

    @Override
    public PacienteDTO findById(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO= mapper.convertValue(paciente, PacienteDTO.class);
        return pacienteDTO;
    }

    public List<PacienteDTO> findByAll(String nombre,String apellido,String dni){

        List<Paciente> newPacientes = pacienteRepository.findByAll(nombre,apellido,dni);
        List<PacienteDTO> pacientesDTO = new ArrayList<>();
        for(Paciente p : newPacientes){
            pacientesDTO.add(mapper.convertValue(p,PacienteDTO.class));
        }
        return pacientesDTO;
    }

    @Override
    public PacienteDTO create(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        Paciente pacienteNew = pacienteRepository.save(paciente);
        PacienteDTO pacienteNewDTO = mapper.convertValue(pacienteNew, PacienteDTO.class);
        return pacienteNewDTO;
    }

    @Override
    public void deleteById(Long id) {
       pacienteRepository.deleteById(id);
    }

    @Override
    public PacienteDTO update(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        Paciente pacienteNew = pacienteRepository.save(paciente);
        PacienteDTO pacienteNewDTO = mapper.convertValue(pacienteNew, PacienteDTO.class);
        return pacienteNewDTO;
    }

    @Override
    public List<PacienteDTO> findAll() {
        List<Paciente> pacientes= pacienteRepository.findAll();
        List<PacienteDTO> pacientesDTO = new ArrayList<>();
        for(Paciente p : pacientes){
            pacientesDTO.add(mapper.convertValue(p, PacienteDTO.class));
        }
        return pacientesDTO;
    }
}

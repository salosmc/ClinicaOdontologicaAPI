package com.example.ApiRestClinica.service;

import com.example.ApiRestClinica.dto.PacienteDTO;
import com.example.ApiRestClinica.exceptions.ResourceNotFoundException;
import com.example.ApiRestClinica.model.Paciente;
import com.example.ApiRestClinica.repository.IPacienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements ICrudService<PacienteDTO>{

    @Autowired//repository vamos a heredar todos lo metodos de RPA
    private IPacienteRepository pacienteRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public PacienteDTO findById(Long id) throws ResourceNotFoundException {
        Optional<Paciente> paciente = pacienteRepository.findById(id);

        if(paciente == null)
            throw new ResourceNotFoundException("No existe paciente con el id :"+id);

        PacienteDTO pacienteDTO= mapper.map(paciente, PacienteDTO.class);
        return pacienteDTO;
    }

    public List<PacienteDTO> findByAll(String nombre,String apellido,String dni) throws ResourceNotFoundException{
        if(nombre.isEmpty()||apellido.isEmpty()||dni.isEmpty())
            throw new ResourceNotFoundException("Error al filtrar busqueda, datos invalidos");

        List<Paciente> newPacientes = pacienteRepository.findByAll(nombre,apellido,dni);

        if(newPacientes.isEmpty())
            throw  new ResourceNotFoundException("No se encontraron odontologos");

        List<PacienteDTO> pacientesDTO = new ArrayList<>();
        for(Paciente p : newPacientes){
            pacientesDTO.add(mapper.map(p,PacienteDTO.class));
        }
        return pacientesDTO;
    }

    @Override
    public PacienteDTO create(PacienteDTO pacienteDTO) throws ResourceNotFoundException {
        if(pacienteDTO==null)
            throw new ResourceNotFoundException("Error, paciente null");

        Paciente paciente = mapper.map(pacienteDTO, Paciente.class);
        Paciente pacienteNew = pacienteRepository.save(paciente);

        if(pacienteNew==null)
            throw new ResourceNotFoundException("Error al guardar paciente");

        PacienteDTO pacienteNewDTO = mapper.map(pacienteNew, PacienteDTO.class);
        return pacienteNewDTO;
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException{
        if(findById(id)==null)
            throw new ResourceNotFoundException("No existe un paciente con el id: "+id);

        pacienteRepository.deleteById(id);
    }

    @Override
    public PacienteDTO update(PacienteDTO pacienteDTO) throws ResourceNotFoundException {
        if(pacienteDTO==null)
            throw new ResourceNotFoundException("Error dato null");

        if(findById(pacienteDTO.getId())==null)
            throw new ResourceNotFoundException("El paciente no existe");

        Paciente paciente = mapper.map(pacienteDTO, Paciente.class);
        Paciente pacienteNew = pacienteRepository.save(paciente);

        if(pacienteNew==null)
            throw new ResourceNotFoundException("Error al actualizar paciente");

        PacienteDTO pacienteNewDTO = mapper.map(pacienteNew, PacienteDTO.class);
        return pacienteNewDTO;
    }

    @Override
    public List<PacienteDTO> findAll() throws ResourceNotFoundException {
        List<Paciente> pacientes= pacienteRepository.findAll();

        if(pacientes.isEmpty())
            throw new ResourceNotFoundException("La lista de pacientes esta vacia");

        List<PacienteDTO> pacientesDTO = new ArrayList<>();
        for(Paciente p : pacientes){
            pacientesDTO.add(mapper.map(p, PacienteDTO.class));
        }
        return pacientesDTO;
    }
}

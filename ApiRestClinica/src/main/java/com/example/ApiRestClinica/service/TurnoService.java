package com.example.ApiRestClinica.service;

import com.example.ApiRestClinica.dto.TurnoDTO;
import com.example.ApiRestClinica.exceptions.ResourceNotFoundException;
import com.example.ApiRestClinica.model.Turno;
import com.example.ApiRestClinica.repository.ITurnoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ICrudService<TurnoDTO>{

    @Autowired
    private ITurnoRepository turnoRepository;


    @Autowired
    ModelMapper mapper;

    @Override
    public TurnoDTO findById(Long id) throws ResourceNotFoundException {
        Optional<Turno> turno = turnoRepository.findById(id);

        if(turno == null)
            throw  new ResourceNotFoundException("No existe turno con el id : "+id);

        TurnoDTO turnoDTO = mapper.map(turno, TurnoDTO.class);
        return turnoDTO;
    }

    @Override
    public TurnoDTO create(TurnoDTO turnoDTO) throws ResourceNotFoundException {
        if(turnoDTO==null)
            throw new ResourceNotFoundException("Error, turno null");

        Turno turno = mapper.map(turnoDTO, Turno.class);

        Turno newTurno = turnoRepository.save(turno);
        if(newTurno == null)
            throw new ResourceNotFoundException("No se pudo guardar turno");

        return mapper.map(newTurno,TurnoDTO.class);
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException{
        if(findById(id)==null)
            throw new ResourceNotFoundException("No existe un turno con el id: "+id);

        turnoRepository.deleteById(id);
    }

    @Override
    public TurnoDTO update(TurnoDTO turnoDTO) throws ResourceNotFoundException {
        if(turnoDTO == null)
            throw new ResourceNotFoundException("Error turno null");

        if(findById(turnoDTO.getId())==null)
            throw new ResourceNotFoundException("El turno no existe");

        Turno turno = mapper.map(turnoDTO, Turno.class);
        Turno newTurno = turnoRepository.save(turno);
        if(newTurno==null)
            throw new ResourceNotFoundException("Error al actualizar turno");

        return mapper.map(newTurno,TurnoDTO.class);
    }

    @Override
    public List<TurnoDTO> findAll() throws ResourceNotFoundException {
        List<Turno> turnos =turnoRepository.findAll();
        if(turnos.isEmpty())
            throw new ResourceNotFoundException("La lista de turnos esta vacia");

        List<TurnoDTO> turnosDTO = new ArrayList<>();
        for(Turno t : turnos){
            turnosDTO.add(mapper.map(t, TurnoDTO.class));
        }

        return turnosDTO;
    }
}

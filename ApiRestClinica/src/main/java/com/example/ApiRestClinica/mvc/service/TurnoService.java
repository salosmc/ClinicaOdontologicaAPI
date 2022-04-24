package com.example.ApiRestClinica.mvc.service;

import com.example.ApiRestClinica.dto.TurnoDTO;
import com.example.ApiRestClinica.model.Turno;
import com.example.ApiRestClinica.mvc.repository.ITurnoRepository;
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

    /*
    @Autowired
    ObjectMapper mapper;
    */

    @Autowired
    ModelMapper mapper;

    @Override
    public TurnoDTO findById(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = mapper.map(turno, TurnoDTO.class);
        return turnoDTO;
    }

    @Override
    public TurnoDTO create(TurnoDTO turnoDTO) {
        Turno turno = mapper.map(turnoDTO, Turno.class);
        Turno newTurno = turnoRepository.save(turno);

        return mapper.map(newTurno,TurnoDTO.class);
    }

    @Override
    public void deleteById(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public TurnoDTO update(TurnoDTO turnoDTO) {
        Turno turno = mapper.map(turnoDTO, Turno.class);
        Turno newTurno = turnoRepository.save(turno);

        return mapper.map(newTurno,TurnoDTO.class);
    }

    @Override
    public List<TurnoDTO> findAll() {
        List<Turno> turnos =turnoRepository.findAll();
        List<TurnoDTO> turnosDTO = new ArrayList<>();
        for(Turno t : turnos){
            turnosDTO.add(mapper.map(t, TurnoDTO.class));
        }

        return turnosDTO;
    }
}

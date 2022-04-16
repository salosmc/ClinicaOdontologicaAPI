package com.example.ApiRestClinica.mvc.service;

import com.example.ApiRestClinica.dto.OdontologoDTO;
import com.example.ApiRestClinica.model.Odontologo;
import com.example.ApiRestClinica.mvc.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements ICrudService<OdontologoDTO> {

    @Autowired//repository vamos a heredar todos lo metodos de RPA
    private IOdontologoRepository odontologoRepository;

    @Autowired//mapper nos va a permitir pasar de la ENTIDAD a DTO y viceversa
    ObjectMapper mapper;

    @Override
    public OdontologoDTO findById(Long id) {
        //busco el odontologo por el id
        Optional<Odontologo> odontologo = odontologoRepository.findById(id); // findById returna un objeto del tipo Optional-> puede ser null
        //para return, tiene que ser del tipo DTO. tengo que mapearlo.
        OdontologoDTO odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
        return odontologoDTO;
    }

    public List<OdontologoDTO> findByAll(String nombre, String apellido, String matricula){

        List<Odontologo> odontologos = odontologoRepository.findByAll(nombre, apellido, matricula);
        List<OdontologoDTO> odontologosDTO = new ArrayList<>();
        for(Odontologo odontologo : odontologos){
            odontologosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }

    @Override
    public OdontologoDTO create(OdontologoDTO odontologoDTO) {
        //primero convierto DTO a una entidad
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        //y luego la guardo en la base de datos
        Odontologo resOdontologo = odontologoRepository.save(odontologo);
        //aca podriamos validar el return.
        //tenemos que returnar algo del tipo odontologoDTO
        OdontologoDTO resOdontologoDTO = mapper.convertValue(resOdontologo, OdontologoDTO.class);
        return resOdontologoDTO;
    }

    @Override
    public void deleteById(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public OdontologoDTO update(OdontologoDTO odontologoDTO) {
        //Como funciona save, si el id no existe lo guarda, si existe lo actualiza.
        //primero convierto DTO a una entidad
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        //y luego la guardo en la base de datos
        Odontologo resOdontologo = odontologoRepository.save(odontologo);
        //aca podriamos validar el return.
        //tenemos que returnar algo del tipo odontologoDTO
        OdontologoDTO resOdontologoDTO = mapper.convertValue(resOdontologo,OdontologoDTO.class);
        return resOdontologoDTO;
    }

    /*
    @Override
    public OdontologoDTO update(OdontologoDTO dentistDto) {
        Optional<Odontologo> optionalDentist = mapper.convertValue(dentistDto, Optional.class);
        if (optionalDentist.isPresent()) {
            Dentist dentist = mapper.convertValue(optionalDentist, Dentist.class);
            return mapper.convertValue(iDentistRepository.save(dentist), DentistDto.class);
        }
        return null;
    }
    */

    @Override
    public List<OdontologoDTO> findAll() {
        //Puedo usar List o Set. La unica diferencia es que Set prevee que tenga elementos repetidos.
        List<Odontologo> odontologos = odontologoRepository.findAll();
        List<OdontologoDTO> odontologosDTO = new ArrayList<>();
        for (Odontologo o : odontologos) {
            odontologosDTO.add(mapper.convertValue(o, OdontologoDTO.class));
        }
        return odontologosDTO;
    }
}

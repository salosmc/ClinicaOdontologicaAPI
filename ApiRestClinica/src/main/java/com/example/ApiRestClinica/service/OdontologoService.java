package com.example.ApiRestClinica.service;

import com.example.ApiRestClinica.dto.OdontologoDTO;
import com.example.ApiRestClinica.exceptions.ResourceNotFoundException;
import com.example.ApiRestClinica.model.Odontologo;
import com.example.ApiRestClinica.repository.IOdontologoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements ICrudService<OdontologoDTO> {

    @Autowired//repository vamos a heredar todos lo metodos de RPA
    private IOdontologoRepository odontologoRepository;

    @Autowired
    ModelMapper mapper;
    
    @Override
    public OdontologoDTO findById(Long id) throws ResourceNotFoundException {

        //busco el odontologo por el id
        Optional<Odontologo> odontologo = odontologoRepository.findById(id); // findById returna un objeto del tipo Optional-> puede ser null

        if(odontologo == null)
            throw new ResourceNotFoundException("No existe odontologo con el id : "+id);

        //para return, tiene que ser del tipo DTO. tengo que mapearlo.
        OdontologoDTO odontologoDTO = mapper.map(odontologo, OdontologoDTO.class);
        return odontologoDTO;
    }

    public List<OdontologoDTO> findByAll(String nombre, String apellido, String matricula) throws ResourceNotFoundException{
        if(nombre.isEmpty() || apellido.isEmpty() || matricula.isEmpty())
            throw new ResourceNotFoundException("Error al filtrar busqueda, datos invalidos");

        List<Odontologo> odontologos = odontologoRepository.findByAll(nombre, apellido, matricula);

        if(odontologos.isEmpty())
            throw new ResourceNotFoundException("No se encontraron odontologos");
        List<OdontologoDTO> odontologosDTO = new ArrayList<>();
        for(Odontologo odontologo : odontologos){
            odontologosDTO.add(mapper.map(odontologo, OdontologoDTO.class));
        }
        return odontologosDTO;
    }

    @Override
    public OdontologoDTO create(OdontologoDTO odontologoDTO) throws ResourceNotFoundException {
        if(odontologoDTO==null)
            throw new ResourceNotFoundException("Error, odontologo null");
        //primero convierto DTO a una entidad
        Odontologo odontologo = mapper.map(odontologoDTO, Odontologo.class);
        //y luego la guardo en la base de datos
        Odontologo resOdontologo = odontologoRepository.save(odontologo);
        if(resOdontologo == null)
            throw new ResourceNotFoundException("No se pudo guardar odontologo");
        //aca podriamos validar el return.
        //tenemos que returnar algo del tipo odontologoDTO
        OdontologoDTO resOdontologoDTO = mapper.map(resOdontologo, OdontologoDTO.class);
        return resOdontologoDTO;
    }

    @Override
    public void deleteById(Long id) throws ResourceNotFoundException {
        if(findById(id) == null)
            throw new ResourceNotFoundException("No existe un odontologo con el id: "+id);

        odontologoRepository.deleteById(id);
    }

    @Override
    public OdontologoDTO update(OdontologoDTO odontologoDTO) throws ResourceNotFoundException {
        if(odontologoDTO==null)
            throw new ResourceNotFoundException("Error odontologo null");

        if(findById(odontologoDTO.getId())==null)
            throw new ResourceNotFoundException("El odontologo no existe");
        //Como funciona save, si el id no existe lo guarda, si existe lo actualiza.
        //primero convierto DTO a una entidad
        Odontologo odontologo = mapper.map(odontologoDTO, Odontologo.class);
        //y luego la guardo en la base de datos
        Odontologo resOdontologo = odontologoRepository.save(odontologo);
        if(resOdontologo==null)
            throw new ResourceNotFoundException("Error al actualizar odontologo");
        //aca podriamos validar el return.
        //tenemos que returnar algo del tipo odontologoDTO
        OdontologoDTO resOdontologoDTO = mapper.map(resOdontologo,OdontologoDTO.class);
        return resOdontologoDTO;
    }

    @Override
    public List<OdontologoDTO> findAll() throws ResourceNotFoundException{
        //Puedo usar List o Set. La unica diferencia es que Set prevee que tenga elementos repetidos.
        List<Odontologo> odontologos = odontologoRepository.findAll();
        if(odontologos.isEmpty()){
            throw new ResourceNotFoundException("La lista de odontologos esta vacia");
        }

        List<OdontologoDTO> odontologosDTO = new ArrayList<>();
        for (Odontologo o : odontologos) {
            odontologosDTO.add(mapper.map(o, OdontologoDTO.class));
        }
        return odontologosDTO;
    }
}

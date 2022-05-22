package com.example.ApiRestClinica.service;

import com.example.ApiRestClinica.dto.OdontologoDTO;
import com.example.ApiRestClinica.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ICrudService<T> {

    T findById (Long id) throws ResourceNotFoundException;

    T create (T t) throws ResourceNotFoundException;
    void deleteById(Long id) throws ResourceNotFoundException;
    T update(T t) throws ResourceNotFoundException;
    List<T> findAll() throws ResourceNotFoundException;
}

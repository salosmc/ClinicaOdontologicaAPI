package com.example.ApiRestClinica.mvc.service;

import java.util.List;

public interface ICrudService<T> {
    T findById(Long id);
    T create(T t);
    void deleteById(Long id);
    T update(T t);
    List<T> findAll();
}

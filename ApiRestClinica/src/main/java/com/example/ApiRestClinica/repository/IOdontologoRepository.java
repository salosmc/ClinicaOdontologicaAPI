package com.example.ApiRestClinica.repository;

import com.example.ApiRestClinica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

    @Query("from Odontologo o where o.nombre like %:nombre% and o.apellido like %:apellido% and o.matricula like %:matricula%")
    List<Odontologo> findByAll(@Param("nombre") String nombre, @Param("apellido") String apellido, @Param("matricula") String matricula);

}

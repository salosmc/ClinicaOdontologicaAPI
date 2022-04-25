package com.example.ApiRestClinica.mvc.repository;


import com.example.ApiRestClinica.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);

    @Query("SELECT a FROM AppUser a WHERE a.email = ?1 OR a.username = ?1")
    Optional<AppUser> findByEmailOrUsername(String emailOrUsername);

}

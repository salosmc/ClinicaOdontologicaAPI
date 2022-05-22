package com.example.ApiRestClinica.config;


import com.example.ApiRestClinica.model.AppUser;
import com.example.ApiRestClinica.model.AppUserRole;
import com.example.ApiRestClinica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String password2 = passwordEncoder2.encode("password2");
        userRepository.save(new AppUser("Diego", "diego", "diego@digital.com", password, AppUserRole.ADMIN));
        userRepository.save(new AppUser("Paula", "paula", "paula@digital.com", password2, AppUserRole.USER));
    }
}

package com.example.ApiRestClinica.mvc.service.securityConfig;


import com.example.ApiRestClinica.mvc.service.securityConfig.jwt.JwtRequestFilter;
import com.example.ApiRestClinica.mvc.service.securityConfig.jwt.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

/*    @Autowired
    private AppUserService userService;
*/

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;


    @Override//Do not use configureGlobal, not @Autowired or circular reference ocurrs
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // configure AuthenticationManager so that it knows from where to load
        // user for matching credentials
        // Use BCryptPasswordEncoder
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {return new BCryptPasswordEncoder();}

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests().antMatchers(HttpMethod.GET,"/odontologos/**").hasAnyAuthority("ADMIN","USER")
                .and()
                .authorizeRequests().antMatchers( "/odontologos/**").hasAuthority("ADMIN")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET,"/pacientes/**").hasAnyAuthority("ADMIN","USER")
                .and()
                .authorizeRequests().antMatchers("/pacientes/**").hasAuthority("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/turnos/**").hasAnyAuthority("ADMIN","USER")
                .and()
                .authorizeRequests().antMatchers(
                        "/authenticate",
                        "/swagger-ui/**",
                        "/v3/api-docs/**"
                ).permitAll().anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }

}
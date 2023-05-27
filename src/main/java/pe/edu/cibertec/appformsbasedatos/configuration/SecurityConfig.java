package pe.edu.cibertec.appformsbasedatos.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import pe.edu.cibertec.appformsbasedatos.repository.UsuarioRepository;
import pe.edu.cibertec.appformsbasedatos.service.DetalleUsuarioService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    private final DetalleUsuarioService userDetailsService;


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/auth/login","/auth/register","/auth/guardarUsuario","/resources/**", "/static/**", "/styles/**", "/scripts/**", "/acces-denied")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //.addFilter(getAuthenticationFilter(authenticationManager))
                .formLogin().loginPage("/auth/login")
                .defaultSuccessUrl("/home")
                .usernameParameter("nomusuario")
                .passwordParameter("password")
                .and()
                .authenticationProvider(authenticationProvider());
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authenticationProvider;
    }


}

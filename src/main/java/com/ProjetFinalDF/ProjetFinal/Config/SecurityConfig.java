package com.ProjetFinalDF.ProjetFinal.Config;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

@Bean
public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    http
       .authorizeHttpRequests(requests -> requests
            .anyRequest().authenticated()
        )
        .formLogin(formLogin -> 
            formLogin
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/index", true)
                .failureUrl("/signIn.html?error=true")
        )
        .logout(logout -> 
            logout
                .logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID")
        )
        .csrf(csrf -> csrf.disable());
    return http.build();
}


}

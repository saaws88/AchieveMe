package com.nekot.achieveme.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.nekot.achieveme.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
  
  @Bean
  public BCryptPasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    return new UserDetailsServiceImpl();
  }

  @Bean
  public AuthenticationManager authenticationManager() {
    var authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(encoder());
    return new ProviderManager(authProvider);
  }

  @Bean
  protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.
        csrf(csrf -> {
          try {
            csrf
              .disable()
              .authorizeHttpRequests()
              .requestMatchers("/", "/main", "api/v1/**").permitAll()
              .anyRequest().authenticated();
          } catch (Exception e) {
            e = new Exception("Авторизуйтесь для просмотра страницы");
          }
        })
        .formLogin(login->login
            .loginPage("/login")
            .defaultSuccessUrl("/home")
            .permitAll())
        .logout(logout -> logout
              .permitAll()
              .logoutSuccessUrl("/"));
          
    return http.build();
  }


}

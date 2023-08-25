package com.example.BTL_INTERNET_GT.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().anyRequest().permitAll();
//                .requestMatchers(HttpMethod.OPTIONS,"/btl/*").permitAll()
//                .requestMatchers("/api/v1/auth/**").permitAll().requestMatchers("/swagger/**").permitAll()
//                .requestMatchers("/admin").hasAuthority("ROLE_ADMIN")
//                .requestMatchers("/user").hasAnyAuthority("ROLE_ADMIN","ROLE_USER")
//                .requestMatchers(CorsUtils :: isPreFlightRequest).permitAll()
//                .and()
//                .csrf().disable()
//                .cors(Customizer.withDefaults())
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

    }



}

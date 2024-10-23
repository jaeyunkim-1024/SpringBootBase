package com.sample.base.common.cofig;

import com.sample.base.common.constants.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsService userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailService) throws Exception {
        return http
                .getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .headers((headers)
                        -> headers.frameOptions(
                        HeadersConfigurer.FrameOptionsConfig::disable
                ))
                .formLogin((form) ->
                        form
                                .loginPage("/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .loginProcessingUrl("/api/user/login")
                                .defaultSuccessUrl("/api/user/loginSuccess",true)
                                .failureUrl("/api/user/loginFailure")

                )
                .logout((logout) ->
                            logout
                                    .logoutUrl("/api/user/logout")
                                    .logoutSuccessUrl("/")

                        )
                .userDetailsService(userDetailsService)
                .authorizeHttpRequests((req) ->
                        req
                                .requestMatchers(PathRequest.toH2Console()).permitAll()
                                .requestMatchers("/","/health-check","/swagger-ui/**","/api/user/join").permitAll()
                                .requestMatchers("/api/**").hasRole(Role.USER.getKey())
                                .anyRequest().authenticated()


                );

        return http.build();
    }
}

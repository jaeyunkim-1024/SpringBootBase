package com.sample.base.controller;

import com.sample.base.dto.LoginRequestDto;
import com.sample.base.dto.UserDto;
import com.sample.base.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(LoginRequestDto dto){
        return ResponseEntity
                .ok()
                .body(loginService.login(dto));
    }

    @PostMapping("/logout")
    public ResponseEntity logout(LoginRequestDto dto){
        return ResponseEntity
                .ok()
                .body(null);
    }
}
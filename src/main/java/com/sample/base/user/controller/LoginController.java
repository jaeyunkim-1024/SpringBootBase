package com.sample.base.user.controller;

import com.sample.base.user.dto.LoginRequestDto;
import com.sample.base.user.dto.UserDto;
import com.sample.base.user.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/loginSuccess")
    public ResponseEntity<UserDto> loginSuccess(){
        log.info("[kbug] 로그인 성공");
        UserDto userDto = UserDto.builder()
                .loginId(SecurityContextHolder.getContext().getAuthentication().getName())
                .build();
        loginService.loginRecord(userDto.getLoginId());
        return ResponseEntity
                .ok()
                .body(userDto);
    }

    @GetMapping("/loginFailure")
    public ResponseEntity<String> loginFailure(){
        log.info("[kbug] 로그인 실패");
        return ResponseEntity
                .ok()
                .body("Failed");
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestBody LoginRequestDto dto){
        return ResponseEntity
                .ok()
                .body(null);
    }
}

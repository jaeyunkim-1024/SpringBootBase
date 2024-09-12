package com.sample.base.controller;

import com.sample.base.dto.UserDto;
import com.sample.base.dto.UserJoinRequestDto;
import com.sample.base.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class JoinController {
    private final JoinService joinService;

    @PostMapping("/join")
    public ResponseEntity<UserDto> join(UserJoinRequestDto dto){
        return ResponseEntity
                .ok()
                .body(joinService.join(dto));
    }
}

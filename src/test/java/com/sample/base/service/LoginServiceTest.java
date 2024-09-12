package com.sample.base.service;

import com.sample.base.user.dto.LoginRequestDto;
import com.sample.base.user.dto.UserDto;
import com.sample.base.user.dto.UserJoinRequestDto;
import com.sample.base.user.service.JoinService;
import com.sample.base.user.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LoginServiceTest {
    @Autowired
    private LoginService loginService;

    @Autowired
    private JoinService joinService;

    final String loginId = "rlawodbs1024";
    final String password = "1234";

    @Test
    void login() {
        UserJoinRequestDto joinDto = UserJoinRequestDto.builder()
                .loginId(loginId)
                .password(password)
                .userName("김재윤")
                .build();
        joinService.join(joinDto);

        LoginRequestDto loginDto = LoginRequestDto.builder()
                .loginId(loginId)
                .password(password)
                .build();

        UserDto user = loginService.login(loginDto);
        assertEquals(loginId,user.getLoginId());
    }
}
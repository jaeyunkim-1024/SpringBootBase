package com.sample.base.service;

import com.sample.base.dto.LoginRequestDto;
import com.sample.base.dto.UserDto;
import com.sample.base.dto.UserJoinRequestDto;
import com.sample.base.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginServiceTest {
    @Autowired
    private LoginService loginService;

    @Autowired
    private JoinService joinService;

    @Test
    void login() {
        String loginId = "rlawodbs1024";
        String password = "1234";

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
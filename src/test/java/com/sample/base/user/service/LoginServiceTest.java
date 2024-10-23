package com.sample.base.user.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class LoginServiceTest {
    @Autowired
    private LoginService joinService;

    final String loginId = "rlawodbs1024";

    @Test
    @DisplayName("loadUserByUsername_테스트")
    void loadUserByUsernameTest() {
        UserDetails details = joinService.loadUserByUsername(loginId);
        assertEquals("rlawodbs1024", details.getUsername());
    }
}
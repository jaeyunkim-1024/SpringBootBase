package com.sample.base.user.service;

import com.sample.base.user.dto.UserDto;
import com.sample.base.user.dto.UserJoinRequestDto;
import com.sample.base.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JoinServiceTest {
    @Autowired
    private JoinService joinService;

    @Autowired
    private UserRepository userRepository;

    final String loginId = "rlawodbs1024";
    final String userName = "김재윤-JunitTest";

    @Test
    @DisplayName("회원 가입 테스트")
    void join() {
        UserJoinRequestDto dto = UserJoinRequestDto.builder()
                .loginId(loginId)
                .password("1234")
                .userName(userName)
                .build();

        UserDto result = joinService.join(dto);
        assertEquals(loginId,result.getLoginId());
        assertEquals(userName,result.getUserName());
    }

    @Test
    @DisplayName("회원 탈퇴 테스트")
    void withDraw() {
        UserJoinRequestDto dto = UserJoinRequestDto.builder()
                .loginId(loginId)
                .password("1234")
                .userName(userName)
                .build();

        UserDto result = joinService.join(dto);
        joinService.withDraw(dto);
        assertEquals(0,userRepository.count());
    }
}
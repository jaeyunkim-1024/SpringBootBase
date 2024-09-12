package com.sample.base.service;

import com.sample.base.dto.UserDto;
import com.sample.base.dto.UserJoinRequestDto;
import com.sample.base.repository.UserRepository;
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
    final String userName = "김재윤";

    @Test
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
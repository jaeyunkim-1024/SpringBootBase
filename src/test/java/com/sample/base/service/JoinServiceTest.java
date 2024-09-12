package com.sample.base.service;

import com.sample.base.dto.UserDto;
import com.sample.base.dto.UserJoinRequestDto;
import com.sample.base.entity.User;
import com.sample.base.repository.UserRepository;
import org.hibernate.mapping.Join;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JoinServiceTest {
    @Autowired
    private JoinService joinService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void join() {
        String loginId = "rlawodbs1024";
        String userName = "김재윤";

        UserJoinRequestDto dto = UserJoinRequestDto.builder()
                .loginId("rlawodbs1024")
                .password("1234")
                .userName("김재윤")
                .build();

        UserDto result = joinService.join(dto);
        assertEquals(loginId,result.getLoginId());
        assertEquals(userName,result.getUserName());
    }

    @Test
    void withDraw() {
        String loginId = "rlawodbs1024";
        String userName = "김재윤";

        UserJoinRequestDto dto = UserJoinRequestDto.builder()
                .loginId("rlawodbs1024")
                .password("1234")
                .userName("김재윤")
                .build();

        UserDto result = joinService.join(dto);
        joinService.withDraw(dto);
        assertEquals(0,userRepository.count());
    }
}
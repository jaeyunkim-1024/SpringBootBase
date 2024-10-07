package com.sample.base.user.service;

import com.sample.base.user.dto.LoginRequestDto;
import com.sample.base.user.dto.UserDto;
import com.sample.base.user.entity.LoginHistory;
import com.sample.base.user.entity.User;
import com.sample.base.user.repository.LoginHistoryRepository;
import com.sample.base.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final LoginHistoryRepository loginHistoryRepository;

    public UserDto login(LoginRequestDto dto){
        User login = User.fromDto(dto);
        User result = userRepository.findUserByLoginIdAndPassword(login.getLoginId(),login.getPassword());
        try{
            loginRecord(result.getUserSeq());
        } catch (Exception e){
            log.error("로그인 이력 남기는 도중 에러 발생 , {}",e.getMessage());
            e.getStackTrace();
        }
        return UserDto.fromEntity(result);
    }

    private void loginRecord(Long userSeq){
        LoginHistory loginHistory = LoginHistory.builder()
                .userSeq(userSeq)
                .build();
        loginHistoryRepository.save(loginHistory);
    }

    public void logout(){

    }
}

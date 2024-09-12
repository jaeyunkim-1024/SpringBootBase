package com.sample.base.service;

import com.sample.base.dto.LoginRequestDto;
import com.sample.base.dto.UserDto;
import com.sample.base.entity.User;
import com.sample.base.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public UserDto login(LoginRequestDto dto){
        User login = User.fromDto(dto);
        User result = userRepository.findUserByLoginIdAndPassword(login.getLoginId(),login.getPassword());
        return UserDto.fromEntity(result);
    }

    public void logout(){

    }
}

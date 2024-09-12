package com.sample.base.service;


import com.sample.base.dto.UserDto;
import com.sample.base.dto.UserJoinRequestDto;
import com.sample.base.entity.User;
import com.sample.base.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JoinService {
    @Autowired
    private UserRepository userRepository;

    public UserDto join(UserJoinRequestDto dto){
        User user = userRepository.findUserByLoginId(dto.getLoginId());
        if(user == null){
            User newUser = User.fromDto(dto);
            return UserDto.fromEntity(userRepository.save(newUser));
        }
        return UserDto.fromEntity(user);
    }

    public void withDraw(UserJoinRequestDto dto){
        User user = userRepository.findUserByLoginId(dto.getLoginId());
        if(user != null){
            userRepository.delete(user);
        }
    }
}

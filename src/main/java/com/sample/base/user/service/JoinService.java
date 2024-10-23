package com.sample.base.user.service;


import com.sample.base.user.dto.UserDto;
import com.sample.base.user.dto.UserJoinRequestDto;
import com.sample.base.user.entity.UserInfo;
import com.sample.base.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class JoinService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto join(UserJoinRequestDto dto){
        UserInfo userInfo = userRepository.findUserByLoginId(dto.getLoginId());
        if(userInfo == null){
            UserInfo newUserInfo = UserInfo.fromDto(dto,bCryptPasswordEncoder);
            return UserDto.fromEntity(userRepository.save(newUserInfo));
        }
        return UserDto.fromEntity(userInfo);
    }

    public void withDraw(UserJoinRequestDto dto){
        UserInfo userInfo = userRepository.findUserByLoginId(dto.getLoginId());
        if(userInfo != null){
            userRepository.delete(userInfo);
        }
    }
}

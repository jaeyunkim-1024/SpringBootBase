package com.sample.base.user.service;

import com.sample.base.common.constants.Role;
import com.sample.base.user.entity.LoginHistory;
import com.sample.base.user.entity.UserInfo;
import com.sample.base.user.repository.LoginHistoryRepository;
import com.sample.base.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {
    private final UserRepository userRepository;
    private final LoginHistoryRepository loginHistoryRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo result = userRepository.findUserByLoginId(username);
//        try{
//            loginRecord(result.getUserSeq());
//        } catch (Exception e){
//            log.error("로그인 이력 남기는 도중 에러 발생 , {}",e.getMessage());
//            e.getStackTrace();
//        }
        return User.builder()
                .username(result.getLoginId())
                .password(result.getPassword())
                .roles(Role.USER.getKey())
                .build();
    }

    public void loginRecord(String loginId){
        try{
            UserInfo result = userRepository.findUserByLoginId(loginId);
            LoginHistory loginHistory = LoginHistory.builder()
                    .userSeq(result.getUserSeq())
                    .build();
            loginHistoryRepository.save(loginHistory);
        }catch(Exception e){
            log.error("로그인 이력 남기는 도중 에러 발생 , {}",e.getMessage());
            log.error(e.getStackTrace().toString());
        }
    }
}

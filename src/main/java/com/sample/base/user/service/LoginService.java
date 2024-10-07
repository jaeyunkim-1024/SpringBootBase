package com.sample.base.user.service;

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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {
    private final UserRepository userRepository;
    private final LoginHistoryRepository loginHistoryRepository;
    private final PasswordEncoder passwordEncoder;

    private void loginRecord(Long userSeq){
        LoginHistory loginHistory = LoginHistory.builder()
                .userSeq(userSeq)
                .build();
        loginHistoryRepository.save(loginHistory);
    }

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        UserInfo result = userRepository.findUserByLoginId(loginId);
        try{
            loginRecord(result.getUserSeq());
        } catch (Exception e){
            log.error("로그인 이력 남기는 도중 에러 발생 , {}",e.getMessage());
            e.getStackTrace();
        }
        return User.builder()
                .username(result.getLoginId())
                .password(result.getPassword())
                .build();
    }
}

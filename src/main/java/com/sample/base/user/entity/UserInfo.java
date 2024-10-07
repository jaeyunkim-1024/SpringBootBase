package com.sample.base.user.entity;

import com.sample.base.user.dto.LoginRequestDto;
import com.sample.base.user.dto.UserJoinRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_INFO")
@Getter
public class UserInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "USER_SEQ")
    private Long userSeq;

    @Column(name = "LOGIN_ID")
    private String loginId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_NAME")
    private String userName;

    public static UserInfo fromDto(LoginRequestDto dto, PasswordEncoder encoder){
        return UserInfo.builder()
                .loginId(dto.getLoginId())
                .password(encoder.encode(dto.getPassword()))
                .userName(dto.getUserName())
                .build();
    }

    public static UserInfo fromDto(UserJoinRequestDto dto, PasswordEncoder encoder){
        return UserInfo.builder()
                .loginId(dto.getLoginId())
                .password(encoder.encode(dto.getPassword()))
                .userName(dto.getUserName())
                .build();
    }
}

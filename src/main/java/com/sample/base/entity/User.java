package com.sample.base.entity;

import com.sample.base.dto.LoginRequestDto;
import com.sample.base.dto.UserJoinRequestDto;
import com.sample.base.util.EncryptUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_INFO")
@Getter
public class User {
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

    public static User fromDto(LoginRequestDto dto){
        return User.builder()
                .loginId(dto.getLoginId())
                .password(EncryptUtil.sha256Encrypt(dto.getPassword()))
                .userName(dto.getUserName())
                .build();
    }

    public static User fromDto(UserJoinRequestDto dto){
        return User.builder()
                .loginId(dto.getLoginId())
                .password(EncryptUtil.sha256Encrypt(dto.getPassword()))
                .userName(dto.getUserName())
                .build();
    }
}

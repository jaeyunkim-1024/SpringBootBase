package com.sample.base.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class LoginRequestDto {
    @Schema(example = "rlawodbs1024", description = "로그인 아이디")
    private String loginId;
    private String password;
    private String userName;
    private Timestamp loginAt;
}

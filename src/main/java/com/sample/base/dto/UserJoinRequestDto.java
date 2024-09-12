package com.sample.base.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserJoinRequestDto {
    private String loginId;
    private String password;
    private String userName;
}

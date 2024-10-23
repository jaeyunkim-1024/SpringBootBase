package com.sample.base.user.dto;

import com.sample.base.user.entity.UserInfo;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String loginId;
    private String userName;

    public static UserDto fromEntity(UserInfo entity){
        return UserDto.builder()
                .loginId(entity.getLoginId())
                .userName(entity.getUserName())
                .build();
    }
}

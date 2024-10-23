package com.sample.base.common.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("User"),
    ADMIN("Admin");

    private final String key;
}

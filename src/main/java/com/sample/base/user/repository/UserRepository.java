package com.sample.base.user.repository;

import com.sample.base.user.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo,Long> {
    UserInfo findUserByLoginIdAndPassword(String loginId, String password);

    UserInfo findUserByLoginId(String loginId);
}

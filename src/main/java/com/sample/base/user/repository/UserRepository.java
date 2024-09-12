package com.sample.base.user.repository;

import com.sample.base.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByLoginIdAndPassword(String loginId, String password);

    User findUserByLoginId(String loginId);
}

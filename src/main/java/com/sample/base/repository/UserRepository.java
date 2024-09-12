package com.sample.base.repository;

import com.sample.base.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByLoginIdAndPassword(String loginId, String password);

    User findUserByLoginId(String loginId);
}

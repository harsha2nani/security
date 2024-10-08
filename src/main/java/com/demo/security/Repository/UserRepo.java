package com.demo.security.Repository;

import com.demo.security.Model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserInfo,Long> {

    Optional<UserInfo> findByName(String username);
}

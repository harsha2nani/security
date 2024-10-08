package com.demo.security.Service;

import com.demo.security.Model.UserInfo;
import com.demo.security.Repository.UserRepo;
import com.demo.security.Utills.SecurityUtills;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private SecurityUtills securityUtills;

    public UserInfo register(UserInfo userInfo){
        String pwd = securityUtills.passwordEncoder().encode(userInfo.getPassword());
        userInfo.setPassword(pwd);
        return userRepo.save(userInfo);
    }
}

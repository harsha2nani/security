package com.demo.security.Config;

import com.demo.security.Model.UserInfo;
import com.demo.security.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<UserInfo> userInfo = userRepo.findByName(username);
          return userInfo.map(UserInfoUserDetails::new)
                    .orElseThrow(()-> new UsernameNotFoundException("User Not Found Exception"));
    }
}

package com.demo.security.Controller;

import com.demo.security.DTO.UserDto;
import com.demo.security.Model.UserInfo;
import com.demo.security.Service.AuthService;
import com.demo.security.Service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     *
     * @param userInfo we get the request of the user who is registering
     * @return the user data which is saved to db.
     */
    @PostMapping("/register")
    public ResponseEntity<UserInfo> register(@RequestBody UserInfo userInfo){
        UserInfo userInfo1 = authService.register(userInfo);
        return new ResponseEntity<>(userInfo1, HttpStatus.OK);
    }

    @PostMapping("/login")
    public String authenticateAndValidateToken(@RequestBody UserDto userDto){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getName(),userDto.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(userDto.getName());
        }else{
            throw new UsernameNotFoundException("Invalid User");
        }


    }
}

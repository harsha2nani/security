package com.demo.security.Controller;

import com.demo.security.Model.UserInfo;
import com.demo.security.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

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
}

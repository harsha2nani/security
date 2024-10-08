package com.demo.security.Controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     *
     * @return This endpoint is Accessed by the User/Admin
     */
    @GetMapping(value = "/welcome")
    public ResponseEntity<String> user(){
        return ResponseEntity.status(200).body("Welcome to the Normal-User Page ....");
    }
}

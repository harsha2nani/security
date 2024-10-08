package com.demo.security.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    /**
     *
     * @return welcome message who is having the Admin Role.
     */
    @GetMapping(value = "/welcome")
    public ResponseEntity<String> welcome(){
        return ResponseEntity.status(200).body("Welcome to the Admin Page ....");
    }
}

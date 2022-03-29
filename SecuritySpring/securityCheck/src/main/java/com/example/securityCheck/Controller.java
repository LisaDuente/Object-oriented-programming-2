package com.example.securityCheck;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/home")
    public String home(){
        return "this is the start page";
    }

    @GetMapping("/admin")
    public String admin(){
        return "this is the admin page";
    }

    //this is a method that encrypts strings for the WebSecurityConfig
    public String encryptExampel(String plainText){
        String encryptedString = new BCryptPasswordEncoder().encode(plainText);
        return encryptedString;
    }
}

package com.italoalbano.crm.application.controller;

import com.italoalbano.crm.application.dto.LoginDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthenticationController {

    @RequestMapping(value = "/lol", method = RequestMethod.GET)
    public void auth() {
        System.out.println("Lol");
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<String> authenticate(@RequestBody LoginDTO loginDTO) {
        // Your authentication logic here
        // For example, you can validate the username and password against your user database or authentication provider

        // Replace this example logic with your actual authentication logic
        if ("exampleUser".equals(loginDTO.getUsername()) && "examplePassword".equals(loginDTO.getPassword())) {
            // Authentication successful
            System.out.println("Done");
            return new ResponseEntity<>("Authentication successful!", HttpStatus.OK);
        } else {
            // Authentication failed
            System.out.println("Not done");
            return new ResponseEntity<>("Authentication failed!", HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void authenticate() {
        System.out.println("Authenticated");
    }

}

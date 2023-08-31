package com.italoalbano.crm.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/")
public class MainController {

    @RequestMapping(value = "/lol", method = RequestMethod.GET)
    public void test() {
        System.out.println("Lol");
    }
}

package ru.demelnikov.fml.hhanalyser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @GetMapping("/hello")
    public String Welcoming() {
        return "hello_world";
    }
}

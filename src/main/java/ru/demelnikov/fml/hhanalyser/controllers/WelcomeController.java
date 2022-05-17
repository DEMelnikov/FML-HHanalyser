package ru.demelnikov.fml.hhanalyser.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/hello-world")
    public String Welcoming() {
        System.out.println("qwqeqwewqew");
        return "/WEB-INF/views/hello_world.html";
    }
}

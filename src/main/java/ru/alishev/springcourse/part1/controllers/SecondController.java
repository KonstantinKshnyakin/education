package ru.alishev.springcourse.part1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

    @GetMapping("/exit")
    public String exit() {
        return "part1/second/exit";
    }
}

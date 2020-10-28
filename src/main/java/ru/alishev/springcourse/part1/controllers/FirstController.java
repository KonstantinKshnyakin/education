package ru.alishev.springcourse.part1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
//        System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "part1/first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "part1/first/goodbye";
    }

    @GetMapping("/calculator")
    public String getCalculate(@RequestParam("a") int a,
                               @RequestParam("b") int b,
                               @RequestParam("action") String action,
                               Model model) {

        double result = switch (action) {
            case "multiplication" -> a * b;
            case "addition" -> a + b;
            case "subtraction" -> a - b;
            case "division" -> a / (double) b;
            default -> 0;
        };
        model.addAttribute("result", result);
        return "part1/first/calculator";
    }
}

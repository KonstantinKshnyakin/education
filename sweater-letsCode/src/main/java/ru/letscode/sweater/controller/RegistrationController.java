package ru.letscode.sweater.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.letscode.sweater.entyti.User;
import ru.letscode.sweater.services.UserService;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("registration")
    public String addUser(User user, Model model) {
        if (!userService.addUser(user)) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("activation/{code}")
    public String activate(@PathVariable String code, Model model) {
        boolean isActivated = userService.activateUser(code);
        if (isActivated) {
            model.addAttribute("message", "User successfully activated");
        } else {
            model.addAttribute("message", "Activation code is not found!");
        }
        return "login";
    }
}

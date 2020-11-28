package ru.letscode.sweater.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.letscode.sweater.entyti.Role;
import ru.letscode.sweater.entyti.User;
import ru.letscode.sweater.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String getUserList(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("{user}")
    public String userEditFrom(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user_edit";
    }

    @PostMapping
    public String userSave(@RequestParam("id") User user,
                           @RequestParam String username,
                           @RequestParam Map<String, String> from) {
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String role : from.keySet()) {
            if (roles.contains(role)){
                user.getRoles().add(Role.valueOf(role));
            }
        }
        userRepository.save(user);
        return "redirect:/user";
    }
}

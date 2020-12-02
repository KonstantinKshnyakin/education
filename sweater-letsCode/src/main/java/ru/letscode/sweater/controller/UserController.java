package ru.letscode.sweater.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.letscode.sweater.entyti.Role;
import ru.letscode.sweater.entyti.User;
import ru.letscode.sweater.services.UserService;

import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String getUserList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditFrom(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user_edit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(@RequestParam("id") User user,
                           @RequestParam String username,
                           @RequestParam Map<String, String> from) {
        userService.saveUser(user, username, from);
        return "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(@AuthenticationPrincipal User user,
                                @ModelAttribute User updateUser) {
        userService.updateUser(user, updateUser);
        return "redirect:/user/profile";
    }
}

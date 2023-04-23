package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.service.UserService;
import java.security.Principal;



@Controller
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(value = "/user")
    public String showUser(Model modelUser, Principal principal) {
        modelUser.addAttribute("userList", userService.findUserByName(principal.getName()));
        return "user";
    }
}
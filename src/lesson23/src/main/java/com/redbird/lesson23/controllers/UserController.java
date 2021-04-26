package com.redbird.lesson23.controllers;

import com.redbird.lesson23.models.Role;
import com.redbird.lesson23.models.User;
import com.redbird.lesson23.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User res = userService.findByUsername(user.getUsername());
        if (res != null) {
            model.put("message", "User exists!");
            return "registration";
        }
        userService.saveUser(user);
        return "redirect:/login";
    }


}

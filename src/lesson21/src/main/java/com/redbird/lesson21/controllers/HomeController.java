package com.redbird.lesson21.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Value("${student.name}")
    String name;
    @Value("${student.last_name}")
    String lastName;
    @Value("${student.group}")
    String group;
    @Value("${student.var}")
    String var;

    @GetMapping()
    public String home(Map<String, Object> model) {
        model.put("name", name);
        model.put("lastName", lastName);
        model.put("group", group);
        model.put("var", var);
        return "home";
    }
}

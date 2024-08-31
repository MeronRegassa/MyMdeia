package com.morinaga.christianportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
//    @RequestMapping(value = "/**/{path:[^.]*}")

    @RequestMapping(value = {"/{path:^(?!api$).*$}", "/**/{path:^(?!api$).*$}"})
    public String redirect() {
        // Forward to React's index.html
        return "forward:/";
    }
}


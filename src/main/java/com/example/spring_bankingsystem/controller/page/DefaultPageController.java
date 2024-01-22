package com.example.spring_bankingsystem.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class DefaultPageController {

    @GetMapping("/doc")
    public String getSwagger() {
        return "redirect:/swagger-ui/index.html";
    }

    @GetMapping({"", "/", "/index"})
    public String getIndex(){
        return "index";
    }

}
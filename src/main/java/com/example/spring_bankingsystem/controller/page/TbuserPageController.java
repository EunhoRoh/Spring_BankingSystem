package com.example.spring_bankingsystem.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tbuser")
@Controller
public class TbuserPageController {

    //{page}가 뭐지?
    @GetMapping("/{page}")
    public String create(@PathVariable("page") String page){
        return "/tbuser/" + page;
    }

}

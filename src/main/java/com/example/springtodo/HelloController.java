package com.example.springtodo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class HelloController {

    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }


}
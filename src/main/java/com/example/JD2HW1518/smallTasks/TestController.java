package com.example.JD2HW1518.smallTasks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test")
@Controller
public class TestController {
    @GetMapping
    @ResponseBody
    public String testMethod()  {
        return "test";
    }
}

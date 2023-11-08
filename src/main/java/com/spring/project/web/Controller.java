package com.spring.project.web;

import com.spring.project.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class Controller {

    private final DemoService demoService;

    public Controller(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping(value="/print")
    public String simplePrint(){
        return demoService.sayHello();
    }


}

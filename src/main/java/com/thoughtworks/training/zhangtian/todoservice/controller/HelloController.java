package com.thoughtworks.training.zhangtian.todoservice.controller;

import com.thoughtworks.training.zhangtian.todoservice.model.Person;
import com.thoughtworks.training.zhangtian.todoservice.service.HelloService;
import jdk.nashorn.internal.lookup.MethodHandleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping(method = RequestMethod.GET, path = "/hello/{name}")
    public String hello(@PathVariable String name,
                        Model model) {
        model.addAttribute("person", helloService.find(name));
        return "hello";
    }
}

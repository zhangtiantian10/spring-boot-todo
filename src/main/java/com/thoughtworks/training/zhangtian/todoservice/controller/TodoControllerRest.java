package com.thoughtworks.training.zhangtian.todoservice.controller;

import com.thoughtworks.training.zhangtian.todoservice.model.Todo;
import com.thoughtworks.training.zhangtian.todoservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class TodoControllerRest {
    @Autowired
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.GET, path = "/todos")
    public List<Todo> todoList() throws IOException {
        return todoService.get();
    }
}

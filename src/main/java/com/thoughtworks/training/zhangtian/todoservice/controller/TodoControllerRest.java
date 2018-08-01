package com.thoughtworks.training.zhangtian.todoservice.controller;

import com.thoughtworks.training.zhangtian.todoservice.model.Todo;
import com.thoughtworks.training.zhangtian.todoservice.service.TodoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
public class TodoControllerRest {
    @Autowired
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.GET, path = "/todos")
    public List<Todo> todoList() {
        return todoService.get();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/todos/{id}")
    public Todo getTodo(@PathVariable int id) throws NotFoundException {
        return todoService.findById(id);
    }
}

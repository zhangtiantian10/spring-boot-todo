package com.thoughtworks.training.zhangtian.todoservice.controller;

import com.thoughtworks.training.zhangtian.todoservice.model.Todo;
import com.thoughtworks.training.zhangtian.todoservice.service.TodoService;
import groovy.util.logging.Slf4j;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Slf4j
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

    @PostMapping("/todos")
    public Integer create(@RequestBody Todo todo) {
        return todoService.create(todo);
    }

    @PutMapping("/todos/{id}")
    public Integer update(@PathVariable Integer id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    public void delete(@PathVariable Integer id) {
        todoService.delete(id);
    }
}

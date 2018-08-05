package com.thoughtworks.training.zhangtian.todoservice.controller;

import com.thoughtworks.training.zhangtian.todoservice.model.Task;
import com.thoughtworks.training.zhangtian.todoservice.model.Todo;
import com.thoughtworks.training.zhangtian.todoservice.service.TaskService;
import com.thoughtworks.training.zhangtian.todoservice.service.TodoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    public Integer create(@RequestBody Task task) throws NotFoundException {

        return taskService.create(task);
    }

    @GetMapping("/tasks")
    public List<Task> getAll() {
        return taskService.getAll();
    }
}

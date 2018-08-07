package com.thoughtworks.training.zhangtian.todoservice.service;

import com.thoughtworks.training.zhangtian.todoservice.model.Task;
import com.thoughtworks.training.zhangtian.todoservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Integer create(Task task) {

        return taskRepository.save(task).getId();
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }
}

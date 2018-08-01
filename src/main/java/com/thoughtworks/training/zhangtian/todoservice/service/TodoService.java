package com.thoughtworks.training.zhangtian.todoservice.service;

import com.thoughtworks.training.zhangtian.todoservice.model.Todo;
import com.thoughtworks.training.zhangtian.todoservice.repository.TodoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> get() {
        return todoRepository.findAll();
    }

    public Todo findById(int id) throws NotFoundException {
        return Optional.ofNullable(todoRepository.findOne(id))
                .orElseThrow(() -> new NotFoundException("not found"));
    }

    public Integer create(Todo todo) {
        return todoRepository.save(todo).getId();
    }
}

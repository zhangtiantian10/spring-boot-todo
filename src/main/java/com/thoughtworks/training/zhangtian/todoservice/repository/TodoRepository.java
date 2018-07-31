package com.thoughtworks.training.zhangtian.todoservice.repository;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.zhangtian.todoservice.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepository {
    public List<Todo> list() {
        return ImmutableList.of(
                new Todo(1, "不用鼠标"),
                new Todo(2, "不用触摸板")
        );
    }
}

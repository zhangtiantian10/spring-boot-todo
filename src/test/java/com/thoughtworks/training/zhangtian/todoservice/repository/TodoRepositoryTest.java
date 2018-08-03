package com.thoughtworks.training.zhangtian.todoservice.repository;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.zhangtian.todoservice.model.Todo;
import com.thoughtworks.training.zhangtian.todoservice.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnTodoByUserId() {
        User user = new User(1, "jianpan", "12345", ImmutableList.of());
        userRepository.save(user);
        Todo todo = new Todo(1, "123456", false, new Date(), ImmutableList.of(), 1);
        todoRepository.save(todo);

        List<Todo> users = todoRepository.findAllByUserId(1);
        assertThat(users.size(), is(1));
        assertThat(users.get(0).getId(), is(todo.getId()));
        assertThat(users.get(0).getValue(), is(todo.getValue()));
    }
}
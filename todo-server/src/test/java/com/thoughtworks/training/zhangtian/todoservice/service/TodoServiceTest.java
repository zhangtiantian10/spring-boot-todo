package com.thoughtworks.training.zhangtian.todoservice.service;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.zhangtian.todoservice.model.Todo;
import com.thoughtworks.training.zhangtian.todoservice.repository.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @MockBean
    private TodoRepository todoRepository;

    @Test
    public void testGet() throws IOException {
        ImmutableList.of(
//                new Todo(1, "123", true, new Date()),
//                new Todo(2, "345", true, new Date())
        );
//        when(todoRepository.list()).thenReturn(todos);
//        assertThat(todoService.get(), is(todos));
//        verify(todoRepository, times(1)).list();
    }
}
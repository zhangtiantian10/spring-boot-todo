package com.thoughtworks.training.zhangtian.todoservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.zhangtian.todoservice.model.Todo;
import com.thoughtworks.training.zhangtian.todoservice.repository.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerRestTest {

    @MockBean
    private TodoRepository todoRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testTodoList() throws Exception {
        List<Todo> todos = ImmutableList.of(
//                new Todo(1, "123", true, new Date()),
//                new Todo(2, "345", true, new Date())
        );

//        when(todoRepository.list()).thenReturn(todos);
        MvcResult mvcResult = mockMvc
                .perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(todos.get(0).getId()))
                .andExpect(jsonPath("$[0].value").value(todos.get(0).getValue()))
                .andExpect(jsonPath("$[0].isComplete").value(todos.get(0).getIsComplete()))
                .andExpect(jsonPath("$[1].id").value(todos.get(1).getId()))
                .andExpect(jsonPath("$[1].value").value(todos.get(1).getValue()))
                .andExpect(jsonPath("$[1].isComplete").value(todos.get(1).getIsComplete()))
                .andReturn();

//        verify(todoRepository, times(1)).list();
    }
}
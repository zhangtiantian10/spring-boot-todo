package com.thoughtworks.training.zhangtian.todoservice.controller;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.zhangtian.todoservice.TokenGenerate;
import com.thoughtworks.training.zhangtian.todoservice.model.Todo;
import com.thoughtworks.training.zhangtian.todoservice.model.User;
import com.thoughtworks.training.zhangtian.todoservice.repository.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
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
    private TokenGenerate tokenGenerate;

    @Test
    public void testTodoList() throws Exception {
        List<Todo> todos = ImmutableList.of(
                new Todo(1, "123", true, new Date(), ImmutableList.of(), 1, false),
                new Todo(2, "345", true, new Date(), ImmutableList.of(), 1, false)
        );

        when(todoRepository.findAllByUserId(1)).thenReturn(todos);

        String token = tokenGenerate.getToken(new User(1, "zhang", "123456", null, false));
        MvcResult mvcResult = mockMvc
                .perform(get("/todos").header(HttpHeaders.AUTHORIZATION, token))
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
    }

    @Test
    public void shouldReturn401GetAllTodos() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(get("/todos"))
                .andExpect(status().isUnauthorized())
                .andReturn();
    }

    @Test
    public void shouldReturnTodosSetSecurityContext() throws Exception {
        List<Todo> todos = ImmutableList.of(
                new Todo(1, "123", true, new Date(), ImmutableList.of(), 1, false),
                new Todo(2, "345", true, new Date(), ImmutableList.of(), 1, false)
        );
        when(todoRepository.findAllByUserId(1)).thenReturn(todos);

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(1,
                        null,
                        Collections.emptyList())
        );

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
    }
}
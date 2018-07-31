package com.thoughtworks.training.zhangtian.todoservice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.zhangtian.todoservice.model.Todo;
import com.thoughtworks.training.zhangtian.todoservice.service.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoControllerRestTest {

    @Autowired
    private TodoControllerRest todoControllerRest;

    @MockBean
    private TodoService todoService;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testTodoList() throws Exception {
        List<Todo> todos = ImmutableList.of(
                new Todo(1, "123", true, new Date()),
                new Todo(2, "345", true, new Date())
        );

        when(todoService.get()).thenReturn(todos);
        MvcResult mvcResult = mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andReturn();

        String resultString = mvcResult.getResponse().getContentAsString();

        List<Todo> data =  objectMapper.readValue(resultString, new TypeReference<List<Todo>>(){});

        assertThat(data.size(), is(todos.size()));

        for (int i = 0; i < data.size(); i++) {
            assertThat(data.get(i).getId(), is(todos.get(i).getId()));
            assertThat(data.get(i).getValue(), is(todos.get(i).getValue()));
            assertThat(data.get(i).getDate(), is(todos.get(i).getDate()));
            assertThat(data.get(i).getIsComplete(), is(todos.get(i).getIsComplete()));
        }

        verify(todoService, times(1)).get();
    }
}
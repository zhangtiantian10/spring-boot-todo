package com.thoughtworks.training.zhangtian.todoservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.training.zhangtian.todoservice.model.Todo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ReadFile {
    public List<Todo> read(String dataString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Todo> data =  objectMapper.readValue(dataString, new TypeReference<List<Todo>>(){});
        return data;
    }
}

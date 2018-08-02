package com.thoughtworks.training.zhangtian.todoservice.repository;

import com.thoughtworks.training.zhangtian.todoservice.service.ReadFile;
import com.thoughtworks.training.zhangtian.todoservice.model.Todo;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByValue(String value);

    List<Todo> findAllByUserId(Integer userId);

//
//    @Value("classpath:static/todos.json")
//    private Resource todos;
//
//    @Autowired
//    private ReadFile readFile;
//    public List<Todo> list() throws IOException {
//        String todosData =  IOUtils.toString(todos.getInputStream(), Charset.forName("UTF-8"));
//
//        return readFile.read(todosData);
//    }
}

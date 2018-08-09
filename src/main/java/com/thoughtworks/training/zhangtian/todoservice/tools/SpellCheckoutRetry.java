package com.thoughtworks.training.zhangtian.todoservice.tools;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thoughtworks.training.zhangtian.todoservice.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpellCheckoutRetry {
    @Autowired
    private SpellChecker spellChecker;

    @HystrixCommand(fallbackMethod = "failure")
    public List<Todo> check(List<Todo> todos) {
        spellChecker.check(todos, Todo::getValue, Todo::setSuggestion);

        return todos;
    }

//    @Recover
    public List<Todo> failure(List<Todo> todos) {
        return todos;
    }
}

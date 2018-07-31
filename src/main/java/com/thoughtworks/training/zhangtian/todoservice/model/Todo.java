package com.thoughtworks.training.zhangtian.todoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {
    private int id;
    private String dec;
}

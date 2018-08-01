package com.thoughtworks.training.zhangtian.todoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "items")
public class Todo {
    @Id
    @GeneratedValue
    private Integer id;
    private String value;
    private Boolean isComplete;
    private Date date;
}

package com.thoughtworks.training.zhangtian.todoservice.repository;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.zhangtian.todoservice.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PersonRepository {
    public List<Person> list() {
        return ImmutableList.of(
                new Person("zhang", "xian"),
                new Person("zhangtian", "xian")
        );
    }
}

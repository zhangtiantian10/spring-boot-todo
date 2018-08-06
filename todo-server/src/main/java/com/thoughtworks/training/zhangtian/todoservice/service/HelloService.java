package com.thoughtworks.training.zhangtian.todoservice.service;

import com.thoughtworks.training.zhangtian.todoservice.model.Person;
import com.thoughtworks.training.zhangtian.todoservice.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {

    @Autowired
    private PersonRepository personRepository;

    public Person find(String name) {
        List<Person> persons = personRepository.list();
        return persons.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst()
                .get();
    }

    public List<Person> list() {
        return personRepository.list();
    }
}

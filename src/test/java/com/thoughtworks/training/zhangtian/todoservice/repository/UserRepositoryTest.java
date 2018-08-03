package com.thoughtworks.training.zhangtian.todoservice.repository;

import com.google.common.collect.ImmutableList;
import com.thoughtworks.training.zhangtian.todoservice.model.User;
import com.thoughtworks.training.zhangtian.todoservice.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnUserByName() {
        User jianpan = new User(1, "jianpan", "12345", ImmutableList.of());
        userRepository.save(jianpan);

        Optional<User> user = userRepository.findOneByName("jianpan");
        assertTrue(user.isPresent());
        assertThat(user.get().getName(), is("jianpan"));
    }
}
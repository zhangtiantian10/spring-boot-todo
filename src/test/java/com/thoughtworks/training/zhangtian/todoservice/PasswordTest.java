package com.thoughtworks.training.zhangtian.todoservice;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PasswordTest {
    @Test
    public void testPassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("zhang"));
        System.out.println(bCryptPasswordEncoder.encode("zhang"));
        System.out.println(bCryptPasswordEncoder.encode("zhang"));
        System.out.println(bCryptPasswordEncoder.encode("zhang"));
        System.out.println(bCryptPasswordEncoder.encode("zhang"));
//        assertTrue();
        assertFalse(bCryptPasswordEncoder.matches("zhangt", bCryptPasswordEncoder.encode("zhang")));
    }
}

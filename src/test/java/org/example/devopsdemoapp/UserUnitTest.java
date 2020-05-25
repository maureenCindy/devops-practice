package org.example.devopsdemoapp;

import org.example.devopsdemoapp.model.User;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author maureen on 25/5/2020
 */
public class UserUnitTest {

    @Test
    public void whenCalledGetNameThenCorrect() {
        User user = new User("Julie", "julie@domain.com");
        assertThat(user.getName()).isEqualTo("Julie");
    }

    @Test
    public void whenCalledGetEmailthenCorrect() {
        User user = new User("Julie", "julie@domain.com");
        assertThat(user.getEmail()).isEqualTo("julie@domain.com");
    }

    @Test
    public void whenCalledSetNameThenCorrect() {
        User user = new User("Julie", "julie@domain.com");
        user.setName("John");
        assertThat(user.getName()).isEqualTo("John");
    }

    @Test
    public void whenCalledSetEmailThenCorrect() {
        User user = new User("Julie", "julie@domain.com");
        user.setEmail("john@domain.com");
        assertThat(user.getEmail()).isEqualTo("john@domain.com");
    }

    @Test
    public void whenCalledToStringThenCorrect() {
        User user = new User("Julie", "julie@domain.com");
        assertThat(user.toString()).isEqualTo("User{id=0, name='Julie', email='julie@domain.com'}");
    }
}

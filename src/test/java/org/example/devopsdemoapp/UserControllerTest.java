
package org.example.devopsdemoapp;

import org.example.devopsdemoapp.controller.UserController;
import org.example.devopsdemoapp.dao.UserRepository;
import org.example.devopsdemoapp.model.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserControllerTest {

    private static UserController userController;
    private static UserRepository mockedUserRepository;
    private static BindingResult mockedBindingResult;
    private static Model mockedModel;

    @BeforeClass
    public static void setUpUserControllerInstance() {
        mockedUserRepository = mock(UserRepository.class);
        mockedBindingResult = mock(BindingResult.class);
        mockedModel = mock(Model.class);
        userController = new UserController(mockedUserRepository);
    }

    @Test
    public void whenCalledShowSignUpForm_thenCorrect() {
        User user = new User("John", "john@domain.com");
        assertThat(userController.showSignUpForm(user)).isEqualTo("add-user");
    }

    @Test
    public void whenCalledAddUserAndValidUser_thenCorrect() {
        User user = new User("John", "john@domain.com");
        when(mockedBindingResult.hasErrors()).thenReturn(false);
        assertThat(userController.addUser(user, mockedBindingResult, mockedModel)).isEqualTo("home");
    }

    @Test
    public void whenCalledAddUserAndInValidUser_thenCorrect() {
        User user = new User("John", "john@domain.com");
        when(mockedBindingResult.hasErrors()).thenReturn(true);
        assertThat(userController.addUser(user, mockedBindingResult, mockedModel)).isEqualTo("add-user");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCalledShowUpdateForm_thenIllegalArgumentException() {
        assertThat(userController.showUpdateForm(0, mockedModel)).isEqualTo("update-user");
    }

    @Test
    public void whenCalledUpdateUserAndValidUser_thenCorrect() {
        User user = new User("John", "john@domain.com");
        when(mockedBindingResult.hasErrors()).thenReturn(false);
        assertThat(userController.updateUser(1l, user, mockedBindingResult, mockedModel)).isEqualTo("home");
    }

    @Test
    public void whenCalledUpdateUserAndInValidUser_thenCorrect() {
        User user = new User("John", "john@domain.com");
        when(mockedBindingResult.hasErrors()).thenReturn(true);
        assertThat(userController.updateUser(1l, user, mockedBindingResult, mockedModel)).isEqualTo("update-user");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCalledDeleteUser_thenIllegalArgumentException() {
        assertThat(userController.deleteUser(1l, mockedModel)).isEqualTo("home");
    }

}
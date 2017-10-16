package com.hermes.training.spring.quotes.web;

import com.hermes.training.spring.quotes.data.user.User;
import com.hermes.training.spring.quotes.data.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserRepository mockedUserRepository;

    @Test
    public void shouldShowRegistration() throws Exception {
        UserController controller = new UserController(mockedUserRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/users/register"))
                .andExpect(view().name("register-user"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        UserController controller = new UserController(mockedUserRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(post("/users/register")
                .param("username", "jbauer")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("password", "24hours"))
                .andExpect(redirectedUrl("/users/jbauer"));
        verify(mockedUserRepository, atLeastOnce()).save(any(User.class));
    }
}

package web.quotes.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class RegisterControllerTest {

    @Test
    public void shouldShowRegistration() throws Exception {
        RegisterController controller = new RegisterController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/register"))
                .andExpect(view().name("registerForm"));
    }

}

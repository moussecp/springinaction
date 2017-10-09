package web.quotes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.quotes.data.User;
import web.quotes.data.UserRepository;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/users")
public class RegisterController {

    private UserRepository userRepository;

    @Autowired
    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = GET)
    public String showRegistrationForm() {
        return "registerForm";
    }


    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(
            @Valid User user,
            Errors errors) {
        if(errors.hasErrors()) {
            return "registerForm";
        }
        userRepository.save(user);
        return "redirect:/users/" + user.getUsername();
    }

    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile(
            @PathVariable String username,
            Model model) {
        User user = userRepository.find(username);
        model.addAttribute(user);
        return "profile";
    }
}

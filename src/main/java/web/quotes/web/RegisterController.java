package web.quotes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.quotes.data.User;
import web.quotes.data.UserRepository;

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
        return "register-user";
    }

//    @RequestMapping(method = POST)
//    public String processRegistration(
//            String firstName,
//            String lastName,
//            String email,
//            String username,
//            String password) {
//        User user = new User(firstName, lastName, email, username, password);
//        userRepository.save(user);
//        return "redirect:/users/" + user.getUsername();
//    }
    @RequestMapping(method = POST)
    public String processRegistration(User user) {
        userRepository.save(user);
        return "redirect:/users/" + user.getUsername();
    }

    @RequestMapping(value = "/{username}", method = GET)
    public String showUserProfile(
            @PathVariable String username,
            Model model) {
        User user = userRepository.find(username);
        model.addAttribute(user);
        return "profile";
    }
}

package com.hermes.training.spring.quotes.web;

import com.google.common.base.Strings;
import com.hermes.training.spring.quotes.data.user.User;
import com.hermes.training.spring.quotes.data.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // get users list
    @RequestMapping(method = RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    // find user for a given username search filter
    @RequestMapping(method = RequestMethod.POST)
    public String users(String username, Model model) {
        if (Strings.isNullOrEmpty(username)) {
            model.addAttribute("users", userRepository.findAll());
        } else {
            model.addAttribute("users", userRepository.findAllLike(username));
        }
        return "users";
    }

    // register a new user
    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm() {
        return "register-user";
    }

    // post new user fields
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

    // post new user object without exception handling
//    @RequestMapping(value = "/register", method = POST)
//    public String processRegistration(User user) {
//        userRepository.save(user);
//        return "redirect:/users/" + user.getUsername();
//    }

    // post new user object and redirect to users/profile with passed object instead of path parameters
    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(User user, RedirectAttributes model) {
        userRepository.save(user);
        model.addFlashAttribute(user); // add flash attribute to pass on objects through the redirect
        return "user-profile";
    }

    // post new user object with try/catch exception handling
//    @RequestMapping(value = "/register", method = POST)
//    public String processRegistration(User user, Model model) {
//        try {
//            userRepository.save(user);
//            return "redirect:/users/" + user.getUsername();
//        } catch (UserAlreadyExistsException e) {
//            model.addAttribute("error", e.getMessage());
//            return "error-duplicate";
//        }
//    }

    // using exception handler to catch duplicate exception
//    @ExceptionHandler(UserAlreadyExistsException.class)
//    public String handleExceptions() {
//        return "error-duplicate";
//    }

    // post new user object with validation
//    @RequestMapping(value = "/register", method = POST)
//    public String processRegistration(@Valid User user) {
//        userRepository.save(user);
//        return "redirect:/users/" + user.getUsername();
//    }

    // get a given user detail
    @RequestMapping(value = "/{username}", method = GET)
    public String showUserProfile(
            @PathVariable String username,
            Model model) {
        User user = userRepository.find(username);
        model.addAttribute(user);
        return "user-profile";
    }
}

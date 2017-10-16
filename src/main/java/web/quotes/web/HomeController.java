package web.quotes.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping({"/", "home", "/homepage"})
public class HomeController {

    @RequestMapping(method = GET)
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String autentificationName;
        if (authentication != null) {
            autentificationName = authentication.getName();
        } else {
            autentificationName = "N/A";
        }
        model.addAttribute("username", autentificationName);
        return "home";
    }
}
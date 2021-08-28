package online.myroute.controllers.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Main {
    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("test", null);
        return "main";
    }
}

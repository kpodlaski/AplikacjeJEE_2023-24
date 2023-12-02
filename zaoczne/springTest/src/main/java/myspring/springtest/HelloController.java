package myspring.springtest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {

    @GetMapping("/hello2")
    public String sayHellowithView(@RequestParam(value = "name", defaultValue = "World") String name, Model model) {
        model.addAttribute("name",name);
        return "greetings";
    }
}

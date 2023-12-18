package springtest.springstart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingsController {

    @GetMapping("/greetings")
    public String greet(@RequestParam(name="name", required = false, defaultValue = "Ohoho") String name,
                        Model model){
        model.addAttribute("name",name);
        return "greetings";
    }

    @GetMapping(value = {"/start/{id}", "/start2/{id}"})
    public String start(@PathVariable(name = "id", required = false) int id,  Model model){
        model.addAttribute("name",id);
        return "greetings";
    }

    @GetMapping("/names")
    public String names(Model model){
        List<Car> names = new ArrayList<>();
        names.add(new Car("Syrena","EL 1234A", 1978));
        names.add(new Car("Polonez","LA 1234A", 1996));
        names.add(new Car("Porche","EL 9999A", 2021));
        names.add(new Car("Toyota","KR 1234A", 2018));
        model.addAttribute("names",names);
        return "names";
    }
}

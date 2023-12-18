package springtest.springstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springtest.springstart.model.Stanowisko;

import java.util.List;

@Controller
public class StanowiskoController {
    @Autowired
    StanowiskoRepository stanowiskoRepository;

    @GetMapping("/stanowiska")
    public String showStanowiska(Model model){
        List<Stanowisko> stanowiska = (List<Stanowisko>) stanowiskoRepository.findAll();
        model.addAttribute("stanowiska", stanowiska);
        model.addAttribute("size",stanowiska.size());
        return "stanowiska";
    }
}

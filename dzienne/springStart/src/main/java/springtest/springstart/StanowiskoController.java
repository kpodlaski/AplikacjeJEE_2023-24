package springtest.springstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import springtest.springstart.model.Stanowisko;

import java.util.List;

@Controller
public class StanowiskoController {
    @Autowired
    StanowiskoRepository stanowiskoRepository;

    public void init_db(){
        Stanowisko st = new Stanowisko("Technik");
        stanowiskoRepository.save(st);
        st = new Stanowisko("Kierownik produkcji");
        stanowiskoRepository.save(st);
    }

    @GetMapping("/stanowiska")
    public String showStanowiska(Model model){
        List<Stanowisko> stanowiska = (List<Stanowisko>) stanowiskoRepository.findAll();
        if (stanowiska.size()<1){
            init_db();
            stanowiska = (List<Stanowisko>) stanowiskoRepository.findAll();
        }
        model.addAttribute("stanowiska", stanowiska);
        model.addAttribute("size",stanowiska.size());
        return "stanowiska";
    }

    @GetMapping(value={"/stanowisko", "/stanowisko/{id}"} )
    public String showStanowiska(@PathVariable(required = false) Integer id, @RequestParam(required = false) String nameStart, Model model){
        if (id != null){
            Stanowisko stanowisko = stanowiskoRepository.findById(id).get();
            model.addAttribute("stanowisko",stanowisko);
            return "stanowisko";
        }
        List<Stanowisko> stanowiska =
                (List<Stanowisko>) stanowiskoRepository.findStanowiskoByNazwaStartingWith(nameStart);
        model.addAttribute("stanowiska", stanowiska);
        model.addAttribute("size",stanowiska.size());
        return "stanowiska";
    }


}

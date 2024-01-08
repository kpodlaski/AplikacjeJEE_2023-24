package springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springtest.model.Stanowisko;

import java.util.List;

@RestController
public class StanowiskoController {
    @Autowired
    StanowiskoRepository stanowiskoRepository;

    @GetMapping("/init_prac_db")
    public String initDb(){
        Stanowisko st =new Stanowisko("Kierownik");
        stanowiskoRepository.save(st);
        st =new Stanowisko("Technik");
        stanowiskoRepository.save(st);
        return "ok";
    }
    @GetMapping(value="/stanowiska",
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Stanowisko> getAll(Model model){
        return (List<Stanowisko>) stanowiskoRepository.findAll();
    }

    @GetMapping(value="/stanowiska/{id}", consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Stanowisko findById(@PathVariable int id){
        Stanowisko st = stanowiskoRepository.findById(id).get();
        return st;
    }

    @PostMapping(value="/stanowiska", consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Stanowisko addStanowisko(@RequestBody Stanowisko st){
        stanowiskoRepository.save(st);
        return st;
    }

    @GetMapping(value="/stanowisko",
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Stanowisko> findById(@RequestParam String name){
        List<Stanowisko> st = stanowiskoRepository.findByNazwaStartingWith(name);
        return st;
    }

}

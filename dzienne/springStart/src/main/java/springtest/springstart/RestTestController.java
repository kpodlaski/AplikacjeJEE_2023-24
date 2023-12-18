package springtest.springstart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {

    @GetMapping(value = "/rest", produces={"application/json"})
    public Car getCar(){
        return new Car("Syrena", "WAW 1234X", 1972);
    }
}

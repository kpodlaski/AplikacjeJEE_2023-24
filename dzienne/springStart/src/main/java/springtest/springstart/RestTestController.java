package springtest.springstart;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {

    @GetMapping(value = "/rest", produces={"application/json"})
    public Car getCar(){
        return new Car("Syrena", "WAW 1234X", 1972);
    }

    @PostMapping(value="/rest", produces={"application/json"},
            consumes ={MediaType.APPLICATION_JSON_VALUE} )
    public Car insertNew(@RequestBody Car car) {
        //Update database :)
        return car;
    }

}

package springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @Autowired
    CustomerRepository customerRepsitory;

    @GetMapping ("/init_db")
    public String initDb(){
        customerRepsitory.save(new Customer("Jack", "Bauer"));
        customerRepsitory.save(new Customer("Chloe", "O'Brian"));
        customerRepsitory.save(new Customer("Kim", "Bauer"));
        customerRepsitory.save(new Customer("David", "Palmer"));
        customerRepsitory.save(new Customer("Michelle", "Dessler"));
        return "init_db";
    }

    @GetMapping("/customer")
    public String getAll(Model model){
        Customer customer = customerRepsitory.findById(1);
        model.addAttribute("cust",customer);
        return "customer_view";
    }
}

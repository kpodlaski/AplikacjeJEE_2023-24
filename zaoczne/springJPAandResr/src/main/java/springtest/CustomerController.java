package springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/customers")
    public String getAll(Model model){
        //Customer customer = customerRepsitory.findById(1);
        List<Customer> customers = (List<Customer>) customerRepsitory.findAll();
        model.addAttribute("customers",customers);
        return "customer_view";
    }

    @GetMapping("/customer/{id}")
    public String getCustomerById(@PathVariable int id,
                                  @RequestParam(value = "name", defaultValue = "")
                                  String name, Model model){
        List<Customer> customers = new ArrayList<>();
        if (name.length()>1){
            customers = customerRepsitory.findByLastName(name);
        }
        else {
            Customer customer = customerRepsitory.findById(id);
            customers.add(customer);
        }
//        List<Customer> customers = (List<Customer>) customerRepsitory.findAll();
        model.addAttribute("customers",customers);
        return "customer_view";
    }
}

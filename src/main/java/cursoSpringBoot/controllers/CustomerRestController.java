package cursoSpringBoot.controllers;
import cursoSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class CustomerRestController {


    private List<Customer> customers = new ArrayList<>(Arrays.asList(
        new Customer(1,"Rodrigo garcia", "rodrigo.garcia@gmail.com", "123456789"),
        new Customer(2,"Maribel garcia", "rodrigo2.garcia@gmail.com", "12345678"),
        new Customer(3,"Sheila Maria Hidalgo", "rodrigo3.garcia@gmail.com", "1234567")
    ));

    @GetMapping("/clientes")
    public List<Customer> getCustomers()
    {
        return customers;
    }



    @GetMapping("/clientes/{username}")
    public Customer getCliente(@PathVariable String username)
    {
        for(Customer c: customers )
        {
            if(c.getUsername().equalsIgnoreCase(username))
            {
                return c;
            }
        }
        return null;
    }


    @PostMapping("/clientes")
    public Customer postCliente(@RequestBody Customer customer) {
        //TODO: process POST request
        customers.add(customer);
        return customer;
    }


    @PutMapping("/clientes")
    public Customer putCliente(@RequestBody Customer customer)
    {
        for(Customer c: customers )
        {
            if(c.getId() == customer.getId())
            {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                return c;
            }
        }
        return null;
    }



    @DeleteMapping("/clientes/{username}")
    public void deleteCliente(@PathVariable String username) {
        customers.removeIf(customer ->
        customer.getUsername().equalsIgnoreCase(username));
    }

    @DeleteMapping("/clientes/byid/{id}")
    public Customer deleteClienteById(@PathVariable int id) {
        for(Customer c: customers )
        {
            if(c.getId() == id)
            {
                customers.remove(c);
                return c;
            }
        }
        return null;
    }

    

}

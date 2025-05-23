package cursoSpringBoot.controllers;
import cursoSpringBoot.domain.Customer; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.net.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class CustomerRestController {


    @GetMapping("/hello")
    public ResponseEntity<String> getResponseEntity() {
        return ResponseEntity.ok("Hello World");
        //return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    private List<Customer> customers = new ArrayList<>(Arrays.asList(
        new Customer(1,"Rodrigo garcia", "rodrigo.garcia@gmail.com", "123456789"),
        new Customer(2,"Maribel garcia", "rodrigo2.garcia@gmail.com", "12345678"),
        new Customer(3,"Sheila Maria Hidalgo", "rodrigo3.garcia@gmail.com", "1234567")
    ));
    
    @GetMapping("/")
    
    public ResponseEntity<List<Customer>> getCustomers()
    {
        return ResponseEntity.ok(customers);
    }



    @GetMapping("/{username}")
    public ResponseEntity<?> getCliente(@PathVariable String username)
    {
        for(Customer c: customers )
        {
            if(c.getUsername().equalsIgnoreCase(username))
            {
                return ResponseEntity.ok(c);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado : " + username);

    }


    @PostMapping("/")
    public ResponseEntity<?> postCliente(@RequestBody Customer customer) {
        customers.add(customer);
      
        // URI location = URI.create("/clientes/" + customer.getId());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() // url actual 
                .path("/{username}") // ruta a la que se va a redirigir
                .buildAndExpand(customer.getUsername()) // id del cliente // el valor proporcionado por el cliente 
                .toUri(); // convierte a URI


                return ResponseEntity.created(location).body(customer);
        // return ResponseEntity.created(location).build();
  
        //   return ResponseEntity.status(HttpStatus.CREATED).body("Cliente creado : " + customer.getUsername());
  
    }


    @PutMapping("/")
    public ResponseEntity<?> putCliente(@RequestBody Customer customer)
    {
        for(Customer c: customers )
        {
            if(c.getId() == customer.getId())
            {
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                // return ResponseEntity.ok(c);
                // return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente actualizado : " + c.getUsername());
                return ResponseEntity.noContent().build();
                


            }
        }

        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado : " + customer.getId());
        return ResponseEntity.notFound().build();

    }



    @DeleteMapping("/{username}")
    public void deleteCliente(@PathVariable String username) {
        customers.removeIf(customer ->
        customer.getUsername().equalsIgnoreCase(username));
    }

    @DeleteMapping("/byid/{id}")
    public ResponseEntity<?> deleteClienteById(@PathVariable int id) {
        for(Customer c: customers )
        {
            if(c.getId() == id)
            {
                customers.remove(c);

                return ResponseEntity.noContent().build();
                // return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente eliminado : " + c.getUsername()); 


            }
        }
       //  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado : " + id);
        return ResponseEntity.notFound().build();

    }

}

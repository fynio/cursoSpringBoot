package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;  
@RestController
@RequestMapping("/saludo")
public class SaludoController {
    
    @GetMapping("/{name}")
    public String saludo(@PathVariable String name){

        return "Hola " +  name;
        }
}

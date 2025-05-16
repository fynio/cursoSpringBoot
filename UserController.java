package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/usuario")
    public Usuario getUsuario(){

        return new Usuario("Rodrigo Garcia Trejo", 36, "rodrigo.garcia@hidalgo.gob.mx");
        
    }
    
}

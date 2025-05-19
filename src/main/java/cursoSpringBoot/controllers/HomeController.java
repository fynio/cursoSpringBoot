package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;  

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }

    // obteniendo parametros de la url
    @GetMapping("/hello2")
    public String hello2(String name) {
        return "Hello " + name + "!";
    }


    @GetMapping({"/hello3","/hw"})
    public String hello3(String name) {
        return "Hello " + name + "!";
    }



}
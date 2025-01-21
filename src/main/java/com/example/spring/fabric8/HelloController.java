package com.example.spring.fabric8;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(path = "/", produces = "text/html")
    public String index() {
        return "<h1>Greetings from Spring Boot (Powered by Fabric8)!!</h1>";
    }

}

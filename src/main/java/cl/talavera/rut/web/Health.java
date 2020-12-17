package cl.talavera.rutservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class Health {
    @GetMapping(path = "/health")
    public String index() {
        return "OK";
    }
}

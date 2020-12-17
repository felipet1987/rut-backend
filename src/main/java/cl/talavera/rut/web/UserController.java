package cl.talavera.rut.web;

import cl.talavera.rut.core.model.RutRequest;
import cl.talavera.rut.core.port.GetUserInteractorPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;


@RestController
public class UserController {
    private final GetUserInteractorPort interactor;

    public UserController(GetUserInteractorPort interactor) {
        this.interactor = interactor;
    }

    @PostMapping("/user/find_by_rut")
    public ResponseEntity<?> index( @RequestBody RutRequest rut) {
        try {
            return ResponseEntity.ok(interactor.get(rut));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("rut no existe");
        }
    }
}

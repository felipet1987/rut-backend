package cl.talavera.rut.core.port;


import cl.talavera.rut.core.model.RutRequest;
import cl.talavera.rut.core.model.UserResponse;

public interface GetUserInteractorPort {
    UserResponse get(RutRequest rut);
}

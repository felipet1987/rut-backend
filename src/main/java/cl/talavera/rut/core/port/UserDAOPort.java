package cl.talavera.rut.core.port;


import cl.talavera.rut.core.model.UserResponse;

public interface UserDAOPort {
    UserResponse findByRut(String rut);
}

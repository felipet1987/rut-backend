package cl.talavera.rut.persistence;

import cl.talavera.rut.core.model.UserResponse;
import cl.talavera.rut.core.port.UserDAOPort;
import cl.talavera.rut.persistence.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class UserDAO implements UserDAOPort {
    private final UserRepository repository;

    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd-MM-yyyy");

    public UserDAO(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserResponse findByRut(String rut) {
        return from(repository.findById(rut));
    }

    private UserResponse from(Optional<UserEntity> entity) {
        UserEntity u = entity.get();
        return UserResponse.builder()
                .nombre(u.getNombre())
                .apellido(u.getApellido())
                .fechaNac(format(u.getFechaNac()))
                .build();
    }

    private String format(Date fechaNac) {
        return FORMAT.format(fechaNac);
    }
}

package cl.talavera.rut;

import cl.talavera.rut.core.model.UserResponse;
import cl.talavera.rut.core.port.UserDAOPort;
import cl.talavera.rut.persistence.UserDAO;
import cl.talavera.rut.persistence.UserRepository;
import cl.talavera.rut.persistence.entity.UserEntity;
import org.junit.jupiter.api.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class UserDAOTest {

    public static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd-MM-yyyy");



    @Test
    void should_find_by_rut() throws ParseException {
        UserRepository repository = mock(UserRepository.class);
        UserDAOPort dao =  new UserDAO(repository);

        when(repository.findById("12345")).thenReturn(entity());


        assertThat(dao.findByRut("12345"),is(expected()));
        verify(repository,times(1)).findById("12345");



    }

    private UserResponse expected() {
        return UserResponse.builder()
                .nombre("timmy")
                .apellido("turner")
                .fechaNac("01-01-2020")
                .build();
    }

    private Optional<UserEntity> entity() throws ParseException {
        UserEntity e = new UserEntity();
        e.setRut("12345");
        e.setNombre("timmy");
        e.setApellido("turner");
        e.setFechaNac(FORMAT.parse("01-01-2020"));
        Optional<UserEntity> optional = Optional.of(e);
        return optional;
    }
}

package cl.talavera.rut;


import cl.talavera.rut.core.model.RutRequest;
import cl.talavera.rut.core.model.UserResponse;

import cl.talavera.rut.core.port.GetUserInteractorPort;
import cl.talavera.rut.web.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class UserControllerTest {
    @Test
    void should_return_user_response() {
        GetUserInteractorPort service = mock(GetUserInteractorPort.class);
        UserController controller = new UserController(service);

        RutRequest rut = RutRequest.builder().rut("123456").build();

        UserResponse user = UserResponse.builder()
                .apellido("turner")
                .fechaNac("01/01/2000")
                .nombre("timmy")
                .build();

        when(service.get(rut)).thenReturn(user);
        ResponseEntity<?> response = controller.index(rut);

        verify(service,times(1)).get(rut);
        assertThat(response.getBody(),is(user));
    }

    @Test
    void should_return_not_found_response() {
        GetUserInteractorPort service = mock(GetUserInteractorPort.class);
        UserController controller = new UserController(service);

        RutRequest rut = RutRequest.builder().build();
        when(service.get(rut)).thenThrow(new NoSuchElementException());

        ResponseEntity<?> response = controller.index(rut);


        assertThat(response.getBody(),is("rut no existe"));
    }
}

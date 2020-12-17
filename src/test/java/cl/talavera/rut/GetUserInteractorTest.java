package cl.talavera.rut;

import cl.talavera.rut.core.interactor.GetUserInteractor;
import cl.talavera.rut.core.model.RutRequest;
import cl.talavera.rut.core.model.UserResponse;
import cl.talavera.rut.core.port.GetUserInteractorPort;
import cl.talavera.rut.core.port.UserDAOPort;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;

public class GetUserInteractorTest {

    @Test
    void should_return_user() {
        UserDAOPort dao = mock(UserDAOPort.class);
        GetUserInteractorPort interactor = new GetUserInteractor(dao);

        RutRequest rut = RutRequest.builder().rut("1234").build();
        UserResponse user = UserResponse.builder().nombre("timmy").build();
        when(dao.findByRut("1234")).thenReturn(user);

        UserResponse result = interactor.get(rut);

        verify(dao,times(1)).findByRut("1234");
        assertThat(result,is(user));
    }
}

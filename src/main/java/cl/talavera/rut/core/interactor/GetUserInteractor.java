package cl.talavera.rut.core.interactor;


import cl.talavera.rut.core.model.RutRequest;
import cl.talavera.rut.core.model.UserResponse;
import cl.talavera.rut.core.port.GetUserInteractorPort;
import cl.talavera.rut.core.port.UserDAOPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class GetUserInteractor implements GetUserInteractorPort {
    private final UserDAOPort dao;

    Logger logger = LoggerFactory.getLogger(GetUserInteractor.class);
    public GetUserInteractor(UserDAOPort dao) {
        this.dao = dao;
    }

    @Override
    public UserResponse get(RutRequest rut) {
        logger.info(" getting user with ---> " + rut.getRut());
        return dao.findByRut(rut.getRut());
    }
}

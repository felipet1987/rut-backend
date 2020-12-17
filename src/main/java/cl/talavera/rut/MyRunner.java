import cl.talavera.rut.persistence.UserRepository;
import cl.talavera.rut.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
class MyRunner implements CommandLineRunner {

    @Autowired
    UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("running...  ");


        UserEntity entity = new UserEntity();
        entity.setRut("123456");
        entity.setNombre("timmy");
        entity.setFechaNac(Date.from(Instant.now()));

        repository.save(UserEntity.builder()
                .rut("123456")
                .nombre("timmy")
                .apellido("turner")
                .fechaNac(Date.from(Instant.now()))
                .build());
    }
}

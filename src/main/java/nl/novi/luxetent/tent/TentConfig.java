package nl.novi.luxetent.tent;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TentConfig {

    @Bean
    CommandLineRunner commandLineRunner(TentRepository repository) {
        return args -> {
            Tent MooieTent = new Tent(
                    1L,
                    "Mooie Tent",
                    "Welkom in mooie tent",
                    99.99f,
                    9
            );

            Tent CooleTent = new Tent(
                    "Coole Tent",
                    "zo een leuke tent",
                    50.99f,
                    4
            );

            repository.saveAll(
                    List.of(MooieTent, CooleTent)
            );
        };
    }
}

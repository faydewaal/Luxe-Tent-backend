package nl.novi.luxetent.appUser;

import nl.novi.luxetent.models.AppUser;
import nl.novi.luxetent.repositories.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppUserConfig {

    @Bean
    CommandLineRunner commandLineRunner
      (AppUserRepository appUserRepository) {
        return args -> {
            AppUser Fay = new AppUser(
                    1L,
                    "Fay de Waal",
                    "fay_de_waal@hotmail.com",
                    "0612345678",
                    "testpasword"
            );

            appUserRepository.saveAll(
                    List.of(Fay)
            );
      };
   }
}

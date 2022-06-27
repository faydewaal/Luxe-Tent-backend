package nl.novi.luxetent.services;

import nl.novi.luxetent.Exceptions.RecordNotFoundException;
import nl.novi.luxetent.repositories.AppUserRepository;
import nl.novi.luxetent.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository){
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }

    public AppUser getAppUser(Long id) {

        Optional<AppUser> appUser = appUserRepository.findById(id);

        if(appUser.isPresent()) {

            return appUser.get();

        } else {

            throw new RecordNotFoundException("Deze gebruiker bestaat niet");

        }

    }

    public AppUser saveAppUser(AppUser appUser) {

        return appUserRepository.save(appUser);
    }

    public void deleteAppUser(Long id) {
        appUserRepository.deleteById(id);
    }

}

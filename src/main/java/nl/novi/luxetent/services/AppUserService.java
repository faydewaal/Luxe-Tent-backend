package nl.novi.luxetent.services;

import nl.novi.luxetent.repositories.AppUserRepository;
import nl.novi.luxetent.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void addAppUser(AppUser appUser) {
        System.out.println(appUser);
    }
}

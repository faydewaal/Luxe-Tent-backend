package nl.novi.luxetent.Controllers;
import nl.novi.luxetent.models.AppUser;
import nl.novi.luxetent.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @CrossOrigin("*")
    public class AppUserController {

        private final AppUserService appUserService;

        @Autowired
        public AppUserController(AppUserService appUserService) {
            this.appUserService = appUserService;
        }


        @GetMapping("/app-users")
        public List<AppUser> getAppUsers() {
            return appUserService.getAppUsers();
        }

        @GetMapping("/app-users/{id}")
        public AppUser getAppUser(@PathVariable("id") Long id) {
            return appUserService.getAppUser(id);
        }

        @PostMapping("/app-users")
        public AppUser saveAppUser(@RequestBody AppUser appUser) {
            return appUserService.saveAppUser(appUser);
        }

        @DeleteMapping("/app-users/{id}")
        public void deleteAppUser(@PathVariable("id") Long id) {
            appUserService.deleteAppUser(id);
        }


    }




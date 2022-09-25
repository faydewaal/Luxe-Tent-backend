package nl.novi.luxetent.controllers;

import nl.novi.luxetent.Exceptions.BadRequestException;
import nl.novi.luxetent.Exceptions.UsernameNotFoundException;
import nl.novi.luxetent.dto.UserDto;
import nl.novi.luxetent.models.FileUploadResponse;
import nl.novi.luxetent.models.Tent;
import nl.novi.luxetent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;
    private final PhotoController photoController;
    private final TentController tentController;


    @Autowired
    public UserController(UserService userService, PhotoController photoController, TentController tentController) {
        this.userService = userService;
        this.photoController = photoController;
        this.tentController = tentController;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> userDtos = userService.getUsers();
        return ResponseEntity.ok().body(userDtos);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable("username") String username) {
        try {
            UserDto userDto = userService.getUser(username);
            return ResponseEntity.ok().body(userDto);
        } catch (UsernameNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createUser(@RequestBody UserDto dto) {
        String newUsername = userService.createUser(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                .buildAndExpand(newUsername).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("username") String username, @RequestBody UserDto dto) {
        userService.updateUser(username, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{username}/photo")
    public void assignPhotoToUser(@PathVariable("username") String username, @RequestBody MultipartFile file){
        FileUploadResponse photo = photoController.singleFileUpload(file);

        userService.assignPhotoToUser(username, photo.getFileName());
    }

    @PostMapping("/{username}/tent")
    public void assignTentToUser(@PathVariable("username") String username, @RequestParam("tent") @RequestBody Long id){
        Tent tipi = tentController.getTentById(id);

        userService.assignTentToUser(username, tipi.getId());
    }


    @GetMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userService.getAuthorities(username));
    }

    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) {
        try {
            String authorityName = (String) fields.get("authority");
            userService.addAuthority(username, authorityName);
            return ResponseEntity.noContent().build();
        }
        catch (Exception ex) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {
        userService.removeAuthority(username, authority);
        return ResponseEntity.noContent().build();
    }

}



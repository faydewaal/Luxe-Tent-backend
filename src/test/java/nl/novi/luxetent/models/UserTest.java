package nl.novi.luxetent.models;

import nl.novi.luxetent.dto.UserDto;
import nl.novi.luxetent.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserTest {
    private User user;

    @Autowired
    UserService userService;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void setAuthorities() {
        user.setUsername("test");
        Authority authority = new Authority("test", "ROLE_ADMIN");
        user.addAuthority(authority);

        Authority expected = new Authority("test", "ROLE_ADMIN");

        Authority actual = user.getAuthorities().iterator().next();
        assertEquals(expected.getAuthority(), actual.getAuthority());
        assertEquals(expected.getUsername(), actual.getUsername());
    }

    @Test
    void createUser() {
        UserDto userDto = new UserDto();
        userDto.setUsername("TestUser");
        userDto.setPassword("kiwi");
        userDto.setEnabled(true);
        userDto.setApikey("asdgfdh");
        userDto.setEmail("test@testen.nl");


        String username = userService.createUser(userDto);

        assertEquals("TestUser", username);
    }
}
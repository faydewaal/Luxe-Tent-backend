package nl.novi.luxetent.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public List<User> getUsers() {
        return List.of(
                new User(
                        1l,
                        "Fay de Waal",
                        "Faydewaal@gmail.com",
                        "064887151",
                        "laksdfjasjfoei"
                )
        );
    }
}

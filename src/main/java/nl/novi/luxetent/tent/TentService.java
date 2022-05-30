package nl.novi.luxetent.tent;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TentService {
    public List<Tent> getTents() {
        return List.of(
                new Tent(
                     1l,
                     "mooie tent",
                     "Kom logeren in de mooie tent",
                     9.9f,
                     5
                )
        );
    }
}

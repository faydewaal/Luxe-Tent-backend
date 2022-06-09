package nl.novi.luxetent.tent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TentService {

    private final TentRepository tentRepository;

    @Autowired
    public TentService(TentRepository tentRepository) {
        this.tentRepository = tentRepository;
    }


    public List<Tent> getTents() {
        return tentRepository.findAll();
    }

    public void addNewTent(Tent tent) {
        System.out.println(tent);
    }
}

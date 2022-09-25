package nl.novi.luxetent.services;

import nl.novi.luxetent.models.TentOptions;
import nl.novi.luxetent.repositories.TentOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TentOptionService {


    private final TentOptionRepository tentOptionRepository;

    @Autowired
    public TentOptionService(TentOptionRepository tentOptionRepository) {
        this.tentOptionRepository = tentOptionRepository;
    }

    public void addTentOption(TentOptions tentOptions) {
        tentOptionRepository.save(tentOptions);
    }
}

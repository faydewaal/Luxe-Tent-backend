package nl.novi.luxetent.services;

import nl.novi.luxetent.dto.TentOptionDto;
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

    public TentOptions createTentOption(TentOptionDto tentOptionDto){
        TentOptions newTentOption = tentOptionRepository.save(toTentOption(tentOptionDto));
        System.out.println("test");
        return newTentOption;
    }
    
    public TentOptions toTentOption(TentOptionDto tentOptionDto) {
        TentOptions tentOptions = new TentOptions();

        tentOptions.setId(tentOptionDto.getId());
        tentOptions.setOptionName(tentOptionDto.getOptionName());
        tentOptions.setPrice(tentOptionDto.getPrice());

        return tentOptions;
    }
    
}

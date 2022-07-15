package nl.novi.luxetent.services;

import nl.novi.luxetent.Exceptions.RecordNotFoundException;
import nl.novi.luxetent.dto.TentOptionDto;
import nl.novi.luxetent.models.TentOption;
import nl.novi.luxetent.repositories.TentOptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TentOptionService {

    @Autowired
    private TentOptionRepository tentOptionRepository;

    public List<TentOptionDto> getAllTentOptions() {
        List<TentOption> tentOption = tentOptionRepository.findAll();
        List<TentOptionDto> dtos = new ArrayList<>();
        for (TentOption to : tentOption) {
            dtos.add(transferToDto(to));
        }
        return dtos;
    }

    public TentOptionDto getTentOption(long id) {
        Optional<TentOption> tentOption = tentOptionRepository.findById(id);
        if(tentOption.isPresent()) {
            TentOptionDto to = transferToDto(tentOption.get());
            return to;
        } else {
            throw new RecordNotFoundException("geen tent opties gevonden");
        }
    }

    public TentOptionDto addTentOption(TentOptionDto tentOptionDto) {
        tentOptionRepository.save(transferToTentOption(tentOptionDto));
        return tentOptionDto;
    }

    public void deleteTentOption(Long id) {
        tentOptionRepository.deleteById(id);
    }

    public void updateTentOption(Long id, TentOptionDto tentOptionDto) {
        if(!tentOptionRepository.existsById(id)) {
            throw new RecordNotFoundException("geen boeking gevonden");
        }
        TentOption storedTentOption = tentOptionRepository.findById(id).orElse(null);
        storedTentOption.setId(tentOptionDto.getId());
        storedTentOption.setOptionName(tentOptionDto.getOptionName());
        storedTentOption.setPrice(tentOptionDto.getPrice());
        tentOptionRepository.save(storedTentOption);
    }

    public TentOption transferToTentOption(TentOptionDto dto){
        TentOption tentOption = new TentOption();

        tentOption.setId(dto.getId());
        tentOption.setOptionName(dto.getOptionName());
        tentOption.setPrice(dto.getPrice());

        return tentOption;
    }

    public static TentOptionDto transferToDto(TentOption tentOption){
        var dto = new TentOptionDto();

        dto.setId(tentOption.getId());
        dto.setOptionName(tentOption.getOptionName());
        dto.setPrice(tentOption.getPrice());

        return dto;
    }
}

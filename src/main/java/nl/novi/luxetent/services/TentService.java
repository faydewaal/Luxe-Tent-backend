package nl.novi.luxetent.services;
import nl.novi.luxetent.Exceptions.RecordNotFoundException;
import nl.novi.luxetent.dtos.TentInputDto;
import nl.novi.luxetent.models.Tent;
import nl.novi.luxetent.dtos.TentDto;
import nl.novi.luxetent.repositories.TentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class TentService {

    private final TentRepository tentRepository;


    public TentService(TentRepository tentRepository) {
        this.tentRepository = tentRepository;
    }


    public List<TentDto> getAllTents() {
        List<Tent> tentList = tentRepository.findAll();
        List<TentDto> tentDtoList = new ArrayList<>();

        for(Tent tent : tentList) {
            TentDto dto = transferToDto(tent);
            tentDtoList.add(dto);
        }
        return tentDtoList;
    }

    public List<TentDto> getAllTentsByName(String name) {
        List<Tent> tentList = tentRepository.findAllTentsByNameEqualsIgnoreCase(name);
        List<TentDto> tentDtoList = new ArrayList<>();

        for(Tent tent : tentList) {
            TentDto dto = transferToDto(tent);
            tentDtoList.add(dto);
        }
        return tentDtoList;
    }

    public TentDto getTentById(Long id) {

        if (tentRepository.findById(id).isPresent()){
            Tent tent = tentRepository.findById(id).get();
            return transferToDto(tent);
        } else {
            throw new RecordNotFoundException("geen tent gevonden");
        }
    }

    public TentDto addTent(TentInputDto dto) {

        Tent tent = transferToTent(dto);
        tentRepository.save(tent);

        return transferToDto(tent);
    }

    public void deleteTent(@RequestBody Long id) {

        tentRepository.deleteById(id);

    }

    public TentDto updateTent(Long id, TentInputDto inputDto) {

        if (tentRepository.findById(id).isPresent()){

            Tent tent = tentRepository.findById(id).get();

            Tent tent1 = transferToTent(inputDto);
            tent1.setId(tent.getId());

            tentRepository.save(tent1);

            return transferToDto(tent1);

        } else {

            throw new  RecordNotFoundException("geen tent gevonden");

        }
    }

    public Tent transferToTent(TentInputDto dto){
        var tent = new Tent();

        tent.setName(dto.getName());
        tent.setDescription(dto.getDescription());
        tent.setPricePerNight(dto.getPricePerNight());
        tent.setMaxNumberOfPersons(dto.getMaxNumberOfPersons());

        return tent;
    }

    public TentDto transferToDto(Tent tent) {
        TentDto dto = new TentDto();

        dto.setId(tent.getId());
        dto.setName(tent.getName());
        dto.setDescription(tent.getDescription());
        dto.setPricePerNight(tent.getPricePerNight());
        dto.setMaxNumberOfPersons(tent.getMaxNumberOfPersons());

        return dto;
    }


}

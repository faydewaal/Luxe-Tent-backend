package nl.novi.luxetent.services;
import nl.novi.luxetent.Exceptions.RecordNotFoundException;
import nl.novi.luxetent.dto.TentDto;
import nl.novi.luxetent.dto.TentInputDto;
import nl.novi.luxetent.models.Booking;
import nl.novi.luxetent.models.FileUploadResponse;
import nl.novi.luxetent.models.Tent;
import nl.novi.luxetent.repositories.BookingRepository;
import nl.novi.luxetent.repositories.FileUploadRepository;
import nl.novi.luxetent.repositories.TentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TentService {

    private final TentRepository tentRepository;
    private final FileUploadRepository uploadRepository;
    private final BookingRepository bookingRepository;

    public TentService(TentRepository tentRepository, FileUploadRepository uploadRepository, BookingRepository bookingRepository) {
        this.tentRepository = tentRepository;
        this.uploadRepository = uploadRepository;
        this.bookingRepository = bookingRepository;
    }

    public List<TentDto> getAllTents() {
        List<Tent> tentList = tentRepository.findAll();
        return transferTentListToDtoList(tentList);
    }

    public List<TentDto> getAllTentByTitle(String title) {
        List<Tent> tentList = tentRepository.findAllTentsByTitleEqualsIgnoreCase(title);
        return transferTentListToDtoList(tentList);
    }

    public List<TentDto> transferTentListToDtoList(List<Tent> tents){
        List<TentDto> tentDtoList = new ArrayList<>();

        for(Tent tent : tents) {
            TentDto dto = transferToDto(tent);

            tentDtoList.add(dto);
        }
        return tentDtoList;
    }

    public TentDto getTentById(Long id) {

        if (tentRepository.findById(id).isPresent()){
            Tent tent = tentRepository.findById(id).get();
            TentDto dto =transferToDto(tent);

            return transferToDto(tent);
        }
            throw new RecordNotFoundException("geen tent gevonden");
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

            Tent tentje = tentRepository.findById(id).get();

            Tent tent1 = transferToTent(inputDto);
            tent1.setId(tentje.getId());

            tentRepository.save(tent1);

            return transferToDto(tent1);

        } else {

            throw new  RecordNotFoundException("geen tent gevonden");

        }

    }

    public Tent transferToTent(TentInputDto dto){
        var tent = new Tent();

        tent.setTitle(dto.getTitle());
        tent.setDescription(dto.getDescription());
        tent.setPricePerNight(dto.getPricePerNight());
        tent.setMaxNumberOfPersons(dto.getMaxNumberOfPersons());
        tent.setStreet(dto.getStreet());
        tent.setHouseNumber(dto.getHouseNumber());
        tent.setCity(dto.getCity());
        tent.setProvince(dto.getProvince());

        return tent;
    }

    public TentDto transferToDto(Tent tent){
        TentDto dto = new TentDto();

        dto.setId(tent.getId());
        dto.setTitle(tent.getTitle());
        dto.setDescription(tent.getDescription());
        dto.setPricePerNight(tent.getPricePerNight());
        dto.setMaxNumberOfPersons(tent.getMaxNumberOfPersons());
        dto.setStreet(tent.getStreet());
        dto.setHouseNumber(tent.getHouseNumber());
        dto.setCity(tent.getCity());
        dto.setProvince(tent.getProvince());

        return dto;
    }


    public void assignPhotoToTent(String fileName, Long tentId) {
        Optional<Tent> optionalTent = tentRepository.findById(tentId);
        Optional<FileUploadResponse> fileUploadResponse = uploadRepository.findByFileName(fileName);

        if (optionalTent.isPresent() && fileUploadResponse.isPresent()) {
            FileUploadResponse photo = fileUploadResponse.get();
            Tent tent = optionalTent.get();

            tent.setFile(photo);
            tentRepository.save(tent);
        }
    }

    public void assignBookingToTent(Long id, Long bookingId) {
        var optionalTent = tentRepository.findById(id);
        var optionalBooking = bookingRepository.findById(bookingId);

        if(optionalTent.isPresent() && optionalBooking.isPresent()) {
            var tent = optionalTent.get();
            var booking = optionalBooking.get();

            tent.setBookings((List<Booking>) booking);
            tentRepository.save(tent);
        } else {
            throw new RecordNotFoundException();
        }
    }
}






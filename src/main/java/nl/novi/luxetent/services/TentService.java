package nl.novi.luxetent.services;
import nl.novi.luxetent.Exceptions.RecordNotFoundException;
import nl.novi.luxetent.dto.TentDto;
import nl.novi.luxetent.models.Booking;
import nl.novi.luxetent.models.FileUploadResponse;
import nl.novi.luxetent.models.Tent;
import nl.novi.luxetent.models.TentOptions;
import nl.novi.luxetent.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TentService {
    private final TentRepository tentRepository;
    private final FileUploadRepository uploadRepository;
    private final TentOptionRepository tentOptionRepository;
    private final BookingRepository bookingRepository;

    public TentService(TentRepository tentRepository, FileUploadRepository uploadRepository, TentOptionRepository tentOptionRepository, BookingRepository bookingRepository) {
        this.tentRepository = tentRepository;
        this.uploadRepository = uploadRepository;
        this.tentOptionRepository = tentOptionRepository;
        this.bookingRepository = bookingRepository;
    }

    public List<Tent> getAllTents() {
        List<Tent> tents = tentRepository.findAll();
        return tents;
    }

    public Tent getSingleTent(Long id) {
        Tent tent = tentRepository.findById(id).get();
        return tent;
    }

    public Tent createTent(TentDto tentDto){
        Tent newTent = tentRepository.save(toTent(tentDto));
        return newTent;
    }

    public void deleteTent(Long id) {
        tentRepository.deleteById(id);
    }

    public static TentDto fromTent(Tent tent) {
        var dto = new TentDto();

        dto.id = tent.getId();
        dto.title = tent.getTitle();
        dto.description = tent.getDescription();
        dto.pricePerNight = tent.getPricePerNight();
        dto.maxNumberOfPersons = tent.getMaxNumberOfPersons();
        dto.street = tent.getStreet();
        dto.houseNumber = tent.getHouseNumber();
        dto.city = tent.getCity();
        dto.province = tent.getProvince();

        return dto;
    }

    public Tent toTent(TentDto tentDto) {
        var tent = new Tent();

        tent.setId(tentDto.getId());
        tent.setTitle(tentDto.getTitle());
        tent.setDescription(tentDto.getDescription());
        tent.setPricePerNight(tentDto.getPricePerNight());
        tent.setMaxNumberOfPersons(tentDto.getMaxNumberOfPersons());
        tent.setStreet(tentDto.getStreet());
        tent.setHouseNumber(tentDto.getHouseNumber());
        tent.setCity(tentDto.getCity());
        tent.setProvince(tentDto.getProvince());

        return tent;
    }


    public void assignPhotoToTent(String fileName, Long id) {
        Optional<Tent> optionalTent = tentRepository.findById(id);
        Optional<FileUploadResponse> fileUploadResponse = uploadRepository.findByFileName(fileName);

        if (optionalTent.isPresent() && fileUploadResponse.isPresent()) {
            FileUploadResponse photo = fileUploadResponse.get();
            Tent tent = optionalTent.get();
            tent.setFile(photo);
            tentRepository.save(tent);
        }
    }

    public void assignOptionsToTent(Long id, Long optionId) {
        var optionalTent = tentRepository.findById(id);
        var tentOptions = tentOptionRepository.findById(optionId);

        if (optionalTent.isPresent() && tentOptions.isPresent()) {
            var tent = optionalTent.get();
            var tentOptie = tentOptions.get();

            tent.setTentOption(tentOptie);
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






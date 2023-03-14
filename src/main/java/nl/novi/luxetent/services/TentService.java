package nl.novi.luxetent.services;

import nl.novi.luxetent.Exceptions.RecordNotFoundException;
import nl.novi.luxetent.dto.TentDto;
import nl.novi.luxetent.dto.UserDto;
import nl.novi.luxetent.models.Booking;
import nl.novi.luxetent.models.FileUploadResponse;
import nl.novi.luxetent.models.Tent;
import nl.novi.luxetent.models.TentOptions;
import nl.novi.luxetent.models.User;
import nl.novi.luxetent.repositories.*;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<TentDto> getAllTents() {
        List<TentDto> collection = new ArrayList<>();
        List<Tent> list = tentRepository.findAll();
        for(Tent tent : list) {
        	collection.add(fromTent(tent));
        }
        return collection;
    }
    
    public TentDto getSingleTent(Long id) {
        TentDto dto = new TentDto();
        Optional<Tent> tent = tentRepository.findById(id);
        if (tent.isPresent()){
            dto = fromTent(tent.get());
        }else {
            throw new RecordNotFoundException("De tent die u zoekt is niet beschikbaar");
        }
        return dto;
    }

    public Tent createTent(TentDto tentDto){
        Tent newTent = tentRepository.save(toTent(tentDto));
        return newTent;
    }

    public void deleteTent(Long id) {
        tentRepository.deleteById(id);
    }

    public static TentDto fromTent(Tent tent) {
        TentDto dto = new TentDto();

        dto.id = tent.getId();
        dto.title = tent.getTitle();
        dto.description = tent.getDescription();
        dto.pricePerNight = tent.getPricePerNight();
        dto.maxNumberOfPersons = tent.getMaxNumberOfPersons();
        dto.street = tent.getStreet();
        dto.houseNumber = tent.getHouseNumber();
        dto.city = tent.getCity();
        dto.province = tent.getProvince();
        dto.file = tent.getFile();

        return dto;
    }

    public Tent toTent(TentDto tentDto) {
        Tent tent = new Tent();

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
        Optional<Tent> optionalTent = tentRepository.findById(id);
        Optional<TentOptions> tentOptions = tentOptionRepository.findById(optionId);

        if (optionalTent.isPresent() && tentOptions.isPresent()) {
            Tent tent = optionalTent.get();
            TentOptions tentOptie = tentOptions.get();

            tent.getTentOptions().add(tentOptie);
            tentRepository.save(tent);
        }
    }


    public void assignBookingToTent(Long id, Long bookingId) {
        Optional<Tent> optionalTent = tentRepository.findById(id);
        Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);

        if(optionalTent.isPresent() && optionalBooking.isPresent()) {
            Tent tent = optionalTent.get();
            Booking booking = optionalBooking.get();

            tent.getBookings().add(booking);
            tentRepository.save(tent);
        } else {
            throw new RecordNotFoundException();
        }
    }



}






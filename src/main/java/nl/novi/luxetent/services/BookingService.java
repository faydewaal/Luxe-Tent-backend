package nl.novi.luxetent.services;

import nl.novi.luxetent.Exceptions.RecordNotFoundException;
import nl.novi.luxetent.dto.BookingDto;
import nl.novi.luxetent.models.Booking;
import nl.novi.luxetent.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<BookingDto> getAllBookings() {
        List<Booking> booking = bookingRepository.findAll();
        List<BookingDto> dtos = new ArrayList<>();
        for (Booking b : booking) {
            dtos.add(transferToDto(b));
        }
        return dtos;
    }

    public BookingDto getBooking(long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if(booking.isPresent()) {
            BookingDto b = transferToDto(booking.get());
            return b;
        } else {
            throw new RecordNotFoundException("geen boeking gevonden");
        }
    }

    public BookingDto addBooking(BookingDto bookingDto) {
        bookingRepository.save(transferToBooking(bookingDto));
        return bookingDto;
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public void updateBooking(Long id, BookingDto bookingDto) {
        if(!bookingRepository.existsById(id)) {
            throw new RecordNotFoundException("geen boeking gevonden");
        }
        Booking storedBooking = bookingRepository.findById(id).orElse(null);
        storedBooking.setId(bookingDto.getId());
        storedBooking.setComment(bookingDto.getComment());
        storedBooking.setDateFrom(bookingDto.getDateFrom());
        storedBooking.setDateTo(bookingDto.getDateTo());
        bookingRepository.save(storedBooking);
    }

    public Booking transferToBooking(BookingDto dto){
        Booking booking = new Booking();

        booking.setId(dto.getId());
        booking.setComment(dto.getComment());
        booking.setDateFrom(dto.getDateFrom());
        booking.setDateTo(dto.getDateTo());

        return booking;
    }

    public static BookingDto transferToDto(Booking booking){
        var dto = new BookingDto();

        dto.setId(booking.getId());
        dto.setComment(booking.getComment());
        dto.setDateFrom(booking.getDateFrom());
        dto.setDateTo(booking.getDateTo());

        return dto;
    }
}

package nl.novi.luxetent.controllers;

import nl.novi.luxetent.dto.BookingDto;
import nl.novi.luxetent.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings")
    public List<BookingDto> getAllBookings() {

        List<BookingDto> dtos = bookingService.getAllBookings();

        return dtos;
    }

    @GetMapping("/booking/{id}")
    public BookingDto getBooking(@PathVariable("id") Long id) {

        BookingDto bookingDto = bookingService.getBooking(id);

        return bookingDto;
    }

    @PostMapping("/bookings")
    public BookingDto addBooking(@RequestBody BookingDto dto) {
        BookingDto bookingDto = bookingService.addBooking(dto);
        return bookingDto;
    }

    @DeleteMapping("/booking/{id}")
    public void deleteBooking(@PathVariable("id") Long id) {
        bookingService.deleteBooking(id);
    }

    @PutMapping("/booking/{id}")
    public BookingDto updateBooking(@PathVariable("id") Long id, @RequestBody BookingDto bookingDto) {
        bookingService.updateBooking(id, bookingDto);
        return bookingDto;
    }

}

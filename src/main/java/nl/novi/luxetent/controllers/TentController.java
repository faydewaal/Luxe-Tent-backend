package nl.novi.luxetent.controllers;

import nl.novi.luxetent.Exceptions.UsernameNotFoundException;
import nl.novi.luxetent.dto.TentDto;
import nl.novi.luxetent.models.FileUploadResponse;
import nl.novi.luxetent.models.Tent;
import nl.novi.luxetent.services.TentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/tents")
public class TentController {

    private final TentService tentService;
    private final PhotoController controller;


    @Autowired
    public TentController(TentService tentService, PhotoController controller) {
        this.tentService = tentService;
        this.controller = controller;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TentDto>> getAllTents() {
        List<TentDto> tentDtos = tentService.getAllTents();
        return ResponseEntity.ok().body(tentDtos);
    }
   

    @GetMapping("/{id}")
    public ResponseEntity<TentDto> getTent(@PathVariable("id") Long id) {
        try {
            TentDto tentDto = tentService.getSingleTent(id);
            return ResponseEntity.ok().body(tentDto);
        } catch (UsernameNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Tent addTent(@RequestBody TentDto dto) {
        Tent newTent = tentService.createTent(dto);
        return newTent;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTent(@PathVariable("id") Long id) {
        tentService.deleteTent(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}/{bookingId}")
    public void assignBookingToTent(@PathVariable("id") Long id, @PathVariable("bookingId") Long bookingId) {
        tentService.assignBookingToTent(id, bookingId);
    }

    @PutMapping("/{id}")
    public void assignPhotoToTent(@PathVariable("id") Long id, @RequestBody MultipartFile file) {
        FileUploadResponse photo = controller.singleFileUpload(file);
        tentService.assignPhotoToTent(photo.getFileName(), id);
    }

    @PutMapping("/{id}/{tentOptionsId}")
    public void assignOptionsToTent(@PathVariable("id") Long id, @PathVariable("tentOptionsId") Long optionsId) {
        tentService.assignOptionsToTent(id, optionsId);
    }

}


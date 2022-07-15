package nl.novi.luxetent.controllers;


import nl.novi.luxetent.dto.TentDto;
import nl.novi.luxetent.dto.TentInputDto;
import nl.novi.luxetent.models.FileUploadResponse;
import nl.novi.luxetent.services.TentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<TentDto>> getAllTents(@RequestParam(value = "title", required = false) Optional<String> title) {

        List<TentDto> dtos;

        if (title.isEmpty()){

            dtos = tentService.getAllTents();

        } else {

            dtos = tentService.getAllTentByTitle(title.get());

        }

        return ResponseEntity.ok().body(dtos);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TentDto> getTent(@PathVariable("id")Long id) {

        TentDto tent = tentService.getTentById(id);

        return ResponseEntity.ok().body(tent);
    }

    @PostMapping
    public ResponseEntity<Object> addTent(@RequestBody TentInputDto tentInputDto) {

        TentDto dto = tentService.addTent(tentInputDto);

        return ResponseEntity.created(null).body(dto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTent(@PathVariable Long id) {

        tentService.deleteTent(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTent(@PathVariable Long id, @RequestBody TentInputDto newTent) {

        TentDto dto = tentService.updateTent(id, newTent);

        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{id}/{bookingId}")
    public void assignBookingToTent(@PathVariable("id") Long id, @PathVariable("bookingId") Long bookingId) {
        tentService.assignBookingToTent(id, bookingId);
    }

    @PostMapping("/{id}/photo")
    public void assignPhotoToTent(@PathVariable("id") Long tentId, @RequestBody MultipartFile file) {
        FileUploadResponse photo = controller.singleFileUpload(file);

        tentService.assignPhotoToTent(photo.getFileName(), tentId);
    }

}


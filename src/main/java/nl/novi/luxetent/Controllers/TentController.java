package nl.novi.luxetent.Controllers;

import nl.novi.luxetent.models.FileUploadResponse;
import nl.novi.luxetent.models.Tent;
import nl.novi.luxetent.services.TentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
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

    @GetMapping
    @Transactional
    public List<Tent> getAllTents() {

        List<Tent> tents;
        tents = tentService.getAllTents();
        return tents;
    }

    @GetMapping("/{id}")
    @Transactional
    public Tent getTent(@PathVariable("id") Long tentId){
        return tentService.getTent(tentId);
    }

    @PostMapping
    public Tent saveTent(@RequestBody Tent tent){
        return tentService.saveTent(tent);
    }


    @DeleteMapping("{id}")
    public void deleteTent(@PathVariable("id") Long tentId) {
        tentService.deleteTent(tentId);
    }


    @PostMapping("/{id}/photo")
    public void assignPhotoToTent(@PathVariable("id") Long tentId, @RequestBody MultipartFile file) {
        FileUploadResponse photo = controller.singleFileUpload(file);

        tentService.assignPhotoToTent(photo.getFileName(), tentId);
    }

}


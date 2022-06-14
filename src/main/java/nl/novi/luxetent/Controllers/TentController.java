package nl.novi.luxetent.Controllers;
import nl.novi.luxetent.dtos.TentDto;
import nl.novi.luxetent.dtos.TentInputDto;
import nl.novi.luxetent.services.TentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
public class TentController {

    private final TentService tentService;

    @Autowired
    public TentController(TentService tentService) {
        this.tentService = tentService;
    }

    @GetMapping("/tents")
    public ResponseEntity<List<TentDto>> getAllTents(@RequestParam(value = "name", required = false) Optional<String> name) {
        List<TentDto> dtos;

        if (name.isEmpty()) {
            dtos = tentService.getAllTents();
        } else {
            dtos = tentService.getAllTentsByName(name.get());
        }
        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping("/tents/{id}")
    public ResponseEntity<TentDto> getTent(@PathVariable("id")Long id) {
       TentDto tent = tentService.getTentById(id);

        return ResponseEntity.ok().body(tent);
    }

    @PostMapping("/tents")
    public ResponseEntity<Object> addTent(@RequestBody TentInputDto tentInputDto) {
        TentDto dto = tentService.addTent(tentInputDto);

        return ResponseEntity.created(null).body(dto);
    }

    @DeleteMapping("/tents/{id}")
    public ResponseEntity<Object> deleteTent(@PathVariable Long id) {
        tentService.deleteTent(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/tents/{id}")
    public ResponseEntity<Object> updateTent(@PathVariable Long id, @RequestBody TentInputDto newTent) {
        TentDto dto = tentService.updateTent(id, newTent);

        return ResponseEntity.ok().body(dto);
    }


}


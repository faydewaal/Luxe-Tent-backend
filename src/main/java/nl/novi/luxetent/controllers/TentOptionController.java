package nl.novi.luxetent.controllers;

import nl.novi.luxetent.dto.TentOptionDto;
import nl.novi.luxetent.services.TentOptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TentOptionController {
    private final TentOptionService tentOptionService;

    public TentOptionController(TentOptionService tentOptionService) {
        this.tentOptionService = tentOptionService;
    }

    @GetMapping("/tent-options")
    public List<TentOptionDto> getAllTentOptions() {

        List<TentOptionDto> dtos = tentOptionService.getAllTentOptions();

        return dtos;
    }

    @GetMapping("/tent-option/{id}")
    public TentOptionDto getTentOption(@PathVariable("id") Long id) {

        TentOptionDto tentOptionDto = tentOptionService.getTentOption(id);

        return tentOptionDto;
    }

    @PostMapping("/tent-options")
    public TentOptionDto addTentOption(@RequestBody TentOptionDto dto) {
        TentOptionDto tentOptionDto = tentOptionService.addTentOption(dto);
        return tentOptionDto;
    }

    @DeleteMapping("/tent-option/{id}")
    public void deleteTentOption(@PathVariable("id") Long id) {
        tentOptionService.deleteTentOption(id);
    }

    @PutMapping("/tent-option/{id}")
    public TentOptionDto updateTentOption(@PathVariable("id") Long id, @RequestBody TentOptionDto tentOptionDto) {
        tentOptionService.updateTentOption(id, tentOptionDto);
        return tentOptionDto;
    }
}

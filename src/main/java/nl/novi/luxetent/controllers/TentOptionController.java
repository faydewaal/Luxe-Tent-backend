package nl.novi.luxetent.controllers;

import nl.novi.luxetent.models.TentOptions;
import nl.novi.luxetent.services.TentOptionService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TentOptionController {

    private final TentOptionService tentOptionService;

    public TentOptionController(TentOptionService tentOptionService) {
        this.tentOptionService = tentOptionService;
    }

    @PostMapping
    public void createTentOption(@RequestBody TentOptions tentOptions) {
        tentOptionService.addTentOption(tentOptions);
    }

}

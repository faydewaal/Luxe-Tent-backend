package nl.novi.luxetent.controllers;

import nl.novi.luxetent.dto.TentOptionDto;
import nl.novi.luxetent.models.TentOptions;
import nl.novi.luxetent.services.TentOptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/options")
public class TentOptionController {

    private final TentOptionService tentOptionService;

   @Autowired
    public TentOptionController(TentOptionService tentOptionService) {
		this.tentOptionService = tentOptionService;
	}


	@PostMapping
    public TentOptions addTentOption(@RequestBody TentOptionDto dto) {
        TentOptions newTentOption = tentOptionService.createTentOption(dto);
        return newTentOption;
    }

}

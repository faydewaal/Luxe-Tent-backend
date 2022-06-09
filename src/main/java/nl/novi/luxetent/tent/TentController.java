package nl.novi.luxetent.tent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tent")
@CrossOrigin("*")
public class TentController {

    private final TentService tentService;

    @Autowired
    public TentController(TentService tentService) {
        this.tentService = tentService;
    }

    @GetMapping
    public List<Tent> getTents() {
        return tentService.getTents();
    }

    @PostMapping
    public void registerNewTent(@RequestBody Tent tent) {
        tentService.addNewTent(tent);
    }

    }


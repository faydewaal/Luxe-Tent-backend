package nl.novi.luxetent.tent;

import nl.novi.luxetent.LuxeTentApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tent")
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
}

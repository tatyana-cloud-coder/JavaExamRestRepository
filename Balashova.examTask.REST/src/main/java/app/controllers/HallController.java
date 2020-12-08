package app.controllers;
import app.Entities.Hall;
import app.services.Impl.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HallController {
    private final HallService hallService;
    @Autowired
    public HallController(HallService hallService) {
        this.hallService = hallService;
    }
    //вот эта хрень
    @RequestMapping(value = "Hall/getHall/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Hall getHall(@PathVariable int id) {
        return hallService.getNeedHall(id);
    }
    //
    @RequestMapping(value = "Hall/getHalls", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Hall> getAllHalls() {
        return hallService.getAllHalls();
    }
    @RequestMapping(value = "Hall/addHall", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addHall(@RequestParam String name) { hallService.addHall(name); }
    @RequestMapping(value = "Hall/removeHall", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeHall(@RequestParam int idHall) {
        hallService.deleteHallById(idHall);
    }
    @RequestMapping(value = "Hall/updateNameHall", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateHall(@RequestParam int idHall, @RequestParam String newNameHall) {
        hallService.updateNameHall(idHall, newNameHall);
    }
}


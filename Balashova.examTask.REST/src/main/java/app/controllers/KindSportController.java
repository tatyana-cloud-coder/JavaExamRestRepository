package app.controllers;
import app.Entities.KindSport;
import app.services.Impl.KindSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class KindSportController {
    private final KindSportService kindSportService;
    @Autowired
    public KindSportController(KindSportService kindSportService) {
        this.kindSportService = kindSportService;
    }
    @RequestMapping(value = "KindSport/getKind/{idKind}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public KindSport getKind(@PathVariable int idKind) {
        return kindSportService.getNeedKind(idKind);
    }
    @RequestMapping(value = "KindSport/getAllKinds", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<KindSport> getAllKinds() {
        return kindSportService.getAllKinds();
    }
    @RequestMapping(value ="KindSport/addKind", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addKind(@RequestParam String name) {
        kindSportService.addKind(new KindSport(name));
    }
    @RequestMapping(value = "KindSport/removeKind", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeKind(@RequestParam int id) {
        kindSportService.deleteKindById(id);
    }
    @RequestMapping(value="KindSport/updateNameKind", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateNameKind(@RequestParam int id, @RequestParam String newNameKind) {
        kindSportService.updateNameKind(id, newNameKind);
    }
}

package app.controllersMoreBeautiful;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GymController {
    @GetMapping("/gym")
    public String GetGym () {
        return "gym";
    }
}

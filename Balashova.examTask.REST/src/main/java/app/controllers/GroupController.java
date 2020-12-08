package app.controllers;

import app.Entities.SportGroup;
import app.services.Impl.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GroupController {
    private final GroupService groupService;
    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }
    @RequestMapping(value="Group/addGroup", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addGroup(@RequestParam String nameGroup, @RequestParam int workingDay) {
        groupService.addGroup(new SportGroup(nameGroup, workingDay));
    }
    @RequestMapping(value="Group/getGroup/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public SportGroup getNeedGroup(@PathVariable int id) {
        return groupService.getNeedGroup(id);
    }
}

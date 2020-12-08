package app.controllers;

import app.Entities.Client;
import app.Entities.SportGroup;
import app.services.Impl.ClientService;
import app.services.Impl.GroupService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClientController {
    private final ClientService clientService;
    private final GroupService groupService;
    @Autowired
    public ClientController(ClientService clientService, GroupService groupService) {
        this.clientService = clientService;
        this.groupService = groupService;
    }
    @RequestMapping(value= "Client/getAllClients", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Client> getAllClients() {
        return clientService.getAllClients();
    }
    @RequestMapping(value="Client/getClient/{id}",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public Client getClient(@PathVariable int id) {
        return clientService.getNeedClient(id);
    }
    @RequestMapping(value = "Client/addClient", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addClient(@RequestParam String firstName,  @RequestParam String lastName,
                          @RequestParam(required = false) String telephoneNumber, @RequestParam(required = false) int idGroup) {
        SportGroup group = groupService.getNeedGroup(idGroup);
        group.setNumber(group.getNumber() + 1);
        clientService.addClient(new Client(firstName, lastName, telephoneNumber, group));
    }
    @RequestMapping(value="Client/removeClient", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeClientById(@RequestParam int id) {
        Client client = clientService.getNeedClient(id);
        client.group.setNumber(client.group.getNumber()-1);

        clientService.deleteClientById(id);
    }
    @RequestMapping(value="Client/updateFirstNameClient", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateFirstNameClient(@RequestParam int id, @RequestParam String firstName) {
        clientService.updateFirstNameClient(id, firstName);
    }
    @RequestMapping(value = "Client/searchClients/{number}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Client> getResultsSearch(@PathVariable int number) {
        return clientService.searchClientsByGroup(number);
    }
}

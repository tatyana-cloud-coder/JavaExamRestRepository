package app.services.Impl;

import app.Entities.Client;
import app.repos.ClientRepository;
import app.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @Transactional
    public void addClient(Client client) {
        clientRepository.save(client);
    }
    @Override
    public Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getNeedClient(int id) {
        return clientRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void updateFirstNameClient(int id, String newFirstName) {
        Client client = clientRepository.findById(id).get();
        client.firstName = newFirstName;
        clientRepository.save(client);
    }

    @Override
    @Transactional
    public void deleteClientById(int id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Iterable<Client> searchClientsByGroup(int number) {
        return clientRepository.findAllByNumber(number);
    }
}

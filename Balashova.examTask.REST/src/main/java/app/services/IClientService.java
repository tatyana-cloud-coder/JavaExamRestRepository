package app.services;

import app.Entities.Client;

public interface IClientService {
    void addClient(Client client);
    Iterable<Client> getAllClients();
    Client getNeedClient(int id);
    void updateFirstNameClient(int id, String newFirstName);
    void deleteClientById(int id);
    Iterable<Client> searchClientsByGroup(int number);
}

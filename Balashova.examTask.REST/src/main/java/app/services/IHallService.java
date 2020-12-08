package app.services;
import app.Entities.Hall;

public interface IHallService {
    void addHall(String name);
    Iterable<Hall> getAllHalls();
    Hall getNeedHall(int id);
    void updateNameHall(int id, String newNameHall);
    void deleteHallById(int id);
}

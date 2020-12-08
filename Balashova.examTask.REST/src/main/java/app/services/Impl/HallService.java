package app.services.Impl;
import app.Entities.Hall;
import app.repos.HallRepository;
import app.services.IHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HallService implements IHallService {
    @Autowired
    private HallRepository hallRepository;
    @Override
    @Transactional
    public void addHall(String name) {
        Hall hall = new Hall(name);
        hallRepository.save(hall);
    }
    @Override
    public Iterable<Hall> getAllHalls() {
        return hallRepository.findAll();
    }

    @Override
    public Hall getNeedHall(int id) {
        return hallRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void updateNameHall(int id, String newNameHall) {
        Hall hall = hallRepository.findById(id).get();
        hall.nameOfHall = newNameHall;
        hallRepository.save(hall);
    }
    @Override
    @Transactional
    public void deleteHallById(int id) {
        hallRepository.deleteById(id);
    }
}


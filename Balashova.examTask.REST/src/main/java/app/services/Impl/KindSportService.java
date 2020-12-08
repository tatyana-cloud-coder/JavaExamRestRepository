package app.services.Impl;
import app.Entities.KindSport;
import app.repos.KindSportRepository;
import app.services.IKindSportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KindSportService implements IKindSportService {
    @Autowired
    private KindSportRepository kindSportRepository;

    @Override
    @Transactional
    public void addKind(KindSport kindSport) {
        kindSportRepository.save(kindSport);
    }

    @Override
    public Iterable<KindSport> getAllKinds() {
        return kindSportRepository.findAll();
    }

    @Override
    public KindSport getNeedKind(int id) {
        return kindSportRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void updateNameKind(int id, String newNameKind) {
        KindSport kindSport = kindSportRepository.findById(id).get();
        kindSport.nameKind = newNameKind;
        kindSportRepository.save(kindSport);
    }
    @Override
    @Transactional
    public void deleteKindById(int idKind) {
        kindSportRepository.deleteById(idKind);
    }
}


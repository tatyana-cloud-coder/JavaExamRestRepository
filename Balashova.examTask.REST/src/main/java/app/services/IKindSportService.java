package app.services;

import app.Entities.KindSport;

public interface IKindSportService {
    public void addKind(KindSport kindSport);
    public Iterable<KindSport> getAllKinds();
    public KindSport getNeedKind(int id);
    public void updateNameKind(int id, String newNameKind);
    public void deleteKindById(int id);
}

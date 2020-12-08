package app.services;

import app.Entities.SportGroup;

public interface IGroupService {
    SportGroup getNeedGroup(int id);
    void addGroup (SportGroup group);
    Iterable<SportGroup> getAllGroups();
    void updateNameGroup(int id, String newNameGroup);
}

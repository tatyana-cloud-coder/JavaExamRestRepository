package app.services.Impl;

import app.Entities.SportGroup;
import app.repos.GroupRepository;
import app.services.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class GroupService implements IGroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public SportGroup getNeedGroup(int id) {
        if (!groupRepository.findById(id).isEmpty()) {
            return groupRepository.findById(id).get();
        }
        return null;
    }

    @Override
    @Transactional
    public void addGroup(SportGroup group) {
        groupRepository.save(group);
    }

    @Override
    public Iterable<SportGroup> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    @Transactional
    public void updateNameGroup(int id, String newNameGroup) {
        SportGroup group = groupRepository.findById(id).get();
        group.setNameGroup(newNameGroup);
        groupRepository.save(group);

    }
}

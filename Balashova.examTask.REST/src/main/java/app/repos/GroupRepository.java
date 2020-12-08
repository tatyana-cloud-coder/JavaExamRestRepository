package app.repos;

import app.Entities.SportGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<SportGroup, Integer> {
}

package app.repos;

import app.Entities.KindSport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KindSportRepository extends JpaRepository <KindSport, Integer> {

}

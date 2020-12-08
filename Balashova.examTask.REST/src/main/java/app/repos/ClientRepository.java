package app.repos;

import app.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository <Client, Integer> {
    @Query("select cl from Client cl inner join SportGroup gr on cl.group.idGroup = gr.idGroup where gr.number <=:number")
    List<Client> findAllByNumber(@Param("number") Integer number);
}

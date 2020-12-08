package app.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "KindSport")
public class KindSport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idKind;
    @Column(name = "nameKind", length = 10)
    public  String nameKind;
    @ManyToMany
    @JoinTable(name = "CoachBySport", joinColumns = @JoinColumn(name = "idKind"),
            inverseJoinColumns =@JoinColumn(name = "idCoach"))
    @JsonBackReference
    public Set <Coach> coaches;
    public KindSport() {}

    public KindSport(String nameKind) {
        this.nameKind = nameKind;
    }
}

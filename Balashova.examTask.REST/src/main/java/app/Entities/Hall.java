package app.Entities;
import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "Hall")
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  int idHall;
    @Column(name = "nameOfHall", length = 10)
    public String nameOfHall;
    @ManyToMany
    @JoinTable(name = "HallByGroup", joinColumns = @JoinColumn(name = "idHall"),
            inverseJoinColumns =@JoinColumn(name = "idGroup") )
    public Set <SportGroup> groups;

    public Hall () {}
    public Hall(String nameOfHall) {
        this.nameOfHall = nameOfHall;
    }
}
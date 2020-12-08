package app.Entities;
import javax.persistence.*;
@SuppressWarnings("PMD")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table (name = "Client")
public class Client  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int idClient;
    @Column(name = "firstName", length = 20)
    public String firstName;
    @Column(name = "lastName", length = 20)
    public String lastName;
    @Column(name = "telephoneNumber", length = 11)
    public String telephoneNumber;
    @ManyToOne(targetEntity = SportGroup.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "idGroup")
    public  SportGroup group;

    public Client() {}

    public Client(String firstName, String lastName, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
    }
    public Client(String firstName, String lastName, String telephoneNumber, SportGroup group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.group = group;
    }
}
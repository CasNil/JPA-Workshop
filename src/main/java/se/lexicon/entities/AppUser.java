package se.lexicon.entities;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString (exclude = "regDate")
@Getter

@Entity
public class AppUser {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    @Setter private String username;

    @Column(nullable = false)
    @Setter private String password;

    @Column
    private LocalDate regDate;

    @Setter
    @OneToOne
    @JoinColumn(name = "user_details_id")
    private Details userDetails;

    public AppUser(String username, String password, Details userDetails) {
        this.username = username;
        this.password = password;
        this.userDetails = userDetails;
    }
}

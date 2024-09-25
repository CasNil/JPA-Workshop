package se.lexicon.entities;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


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
    private int id;

    @Column(unique = true, nullable = false)
    @Setter private String username;

    @Column(nullable = false)
    @Setter private String password;

    @Column
    private LocalDate regDate;

    @OneToOne
    @JoinColumn(name = "user_details_id")
    private Details userDetails;

    @OneToMany(mappedBy = "borrower")
    private Set<BookLoan> borrowers = new HashSet<>();

    public AppUser(String username, String password, Details userDetails) {
        this.username = username;
        this.password = password;
        this.regDate = LocalDate.now();
    }
}

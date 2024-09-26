package se.lexicon.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "regDate")
@Getter

@Entity
public class AppUser {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    @Setter
    private String username;

    @Column(nullable = false)
    @Setter
    private String password;

    @Column
    private LocalDate regDate;

    @OneToOne
    @JoinColumn(name = "user_details_id")
    private Details userDetails;

    @OneToMany(mappedBy = "borrower")
    private Set<BookLoan> borrowers = new HashSet<>();

    @OneToMany(mappedBy = "borrower")
    private List<BookLoan> bookLoans = new ArrayList<>();

    public void addBookLoan(BookLoan bookLoan) {
        bookLoans.add(bookLoan);
        bookLoan.setBorrower(this);
    }

    public void removeBookLoan(BookLoan bookLoan) {
        bookLoans.remove(bookLoan);
        bookLoan.setBorrower(null);
    }

    public AppUser(String username, String password, Details userDetails) {
        this.username = username;
        this.password = password;
        this.regDate = LocalDate.now();
    }
}

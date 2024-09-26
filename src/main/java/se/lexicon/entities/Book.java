package se.lexicon.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @Column(unique = true, nullable = false)
    @Setter
    private String isbn;

    @Column(nullable = false)
    @Setter
    private String title;

    @Column(nullable = false)
    @Setter
    private int maxLoanDays;

    private boolean available = true;

    @OneToMany(mappedBy = "book")
    @Setter
    private Set<BookLoan> bookLoans = new HashSet<>();

    @ManyToMany(mappedBy = "writtenBooks")
    private List<Author> authors;

    public void lendBook() {
        this.available = false;
    }

    public void returnBook() {
        this.available = true;
    }
}

package se.lexicon.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    private String isbn;

    @Column(nullable = false)
    @Setter
    private String title;

    @Column(nullable = false)
    @Setter
    private int maxLoanDays;

    @OneToMany(mappedBy = "book")
    @Setter
    private Set<BookLoan> bookLoans = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;
}

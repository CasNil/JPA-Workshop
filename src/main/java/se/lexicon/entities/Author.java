package se.lexicon.entities;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @Column(nullable = false)
    @Setter
    private String firstName;

    @Column(nullable = false)
    @Setter
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> writtenBooks;

}

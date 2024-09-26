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

    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Set<Book> writtenBooks;

    public void addBook(Book book) {
        writtenBooks.add(book);
        book.getAuthors().add(this);
    }

    public void removeBook(Book book) {
        writtenBooks.remove(book);
        book.getAuthors().remove(this);
    }
}

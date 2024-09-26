package se.lexicon.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

@Entity
public class BookLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private int id;

    @Column
    @Setter
    private LocalDate loanDate;

    @Column
    @Setter
    private LocalDate dueDate;

    @Column
    private boolean returned;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    @Setter
    private AppUser borrower;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @Setter
    private Book book;


    public BookLoan(LocalDate loanDate, AppUser borrower, Book book) {
        this.loanDate = LocalDate.now();
        this.borrower = borrower;
        this.book = book;
    }
}

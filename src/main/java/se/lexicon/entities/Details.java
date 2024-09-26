package se.lexicon.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter

@Entity
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Column(unique = true, nullable = false)
    private String email;

    @Setter
    @Column(nullable = false)
    private String name;

    @Setter
    @Column(nullable = false)
    private LocalDate birtDate;


    public Details(String email, LocalDate birtDate, String name) {
        this.email = email;
        this.birtDate = birtDate;
        this.name = name;
    }
}

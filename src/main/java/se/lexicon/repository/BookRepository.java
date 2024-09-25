package se.lexicon.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Book findByIsbnIgnoreCase(String isbn);

    Optional<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByMaxLoanDaysLessThan(int daysLimit);
}

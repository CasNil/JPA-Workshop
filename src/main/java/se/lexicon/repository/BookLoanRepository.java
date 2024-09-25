package se.lexicon.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.entities.BookLoan;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {
    Optional<BookLoan> findByBorrower_Id(Integer borrowerId);

    List<BookLoan> findByBook_Id(Integer bookId);

    List<BookLoan> findByReturnedFalse();

    List<BookLoan> findByDueDateAfterAndReturnedFalse(LocalDate dueDate);

    List<BookLoan> findByLoanDateBetween(LocalDate startDate, LocalDate endDate);
}

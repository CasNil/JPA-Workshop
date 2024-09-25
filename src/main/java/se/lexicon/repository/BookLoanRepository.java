package se.lexicon.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.entities.BookLoan;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {
    Optional<BookLoan> findByBorrower_Id(Integer borrowerId);

    List<BookLoan> findByBook_Id(Integer bookId);

    List<BookLoan> findByReturnedFalse();

    @Query("SELECT bl FROM BookLoan bl WHERE bl.dueDate < :currentDate AND bl.returned = false")
    List<BookLoan> findOverdueLoans(@Param("currentDate")LocalDate currentDate);

    List<BookLoan> findByLoanDateBetween(LocalDate startDate, LocalDate endDate);

    @Modifying
    @Query("UPDATE BookLoan bl SET bl.returned = true WHERE bl.id = :bookLoanId")
    void markAsReturned(@Param("bookLoanId") Integer bookLoanId);

}

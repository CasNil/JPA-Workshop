package se.lexicon.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.entities.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
    List<Author> findByFirstName(String firstname);

    List<Author> findByLastName(String lastname);

    List<Author> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String keyword1, String keyword2);

    List<Author> findByWrittenBooks_id(int bookId);

    @Modifying
    @Transactional
    @Query("UPDATE Author a SET a.firstName = :firstName, a.lastName = :lastName WHERE a.id = :authorId")
    void updateAuthorNameById(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("authorId") int authorId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Author a WHERE a.id = :authorId")
    void deleteAuthorById(@Param("authorId") int authorId);
}

package se.lexicon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.entities.Details;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetailsRepository extends CrudRepository<Details, Integer> {
    Optional<Details> findByEmail(String email);

    Optional<List<Details>> findByNameContaining(String name);

    Optional<List<Details>> findByNameIgnoreCase(String name);
}

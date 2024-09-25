package se.lexicon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.entities.AppUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    Optional<AppUser> findByUsername(String username);

    Optional<List<AppUser>> findByRegDateBetween(LocalDate startDate, LocalDate endDate);

    Optional<AppUser> findByUserDetailsId(int userDetailsId);

    Optional<AppUser> findByUserDetailsEmailIgnoreCase(String email);
}

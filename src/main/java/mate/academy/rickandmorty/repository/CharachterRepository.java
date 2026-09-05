package mate.academy.rickandmorty.repository;

import mate.academy.rickandmorty.model.CharachterInternal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharachterRepository extends JpaRepository<CharachterInternal, Long> {
}

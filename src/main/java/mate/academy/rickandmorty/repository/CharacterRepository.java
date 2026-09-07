package mate.academy.rickandmorty.repository;

import mate.academy.rickandmorty.model.CharacterInternal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<CharacterInternal, Long> {
}

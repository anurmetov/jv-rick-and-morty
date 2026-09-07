package mate.academy.rickandmorty.service;

import java.util.List;
import java.util.Random;
import lombok.AllArgsConstructor;
import mate.academy.rickandmorty.dto.external.CharacterDto;
import mate.academy.rickandmorty.dto.internal.CharacterInternalDto;
import mate.academy.rickandmorty.mapper.CharacterMapper;
import mate.academy.rickandmorty.model.CharacterInternal;
import mate.academy.rickandmorty.repository.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CharacterInternalService {
    private static final Random RANDOM = new Random();

    private final CharacterClient characterClient;
    private final CharacterMapper characterMapper;
    private final CharacterRepository characterRepository;

    public CharacterInternalDto getInternalCharacter() {
        Long randomIdOfCharacter = RANDOM.nextLong(1, characterRepository.count() + 1);
        CharacterDto characterDto = characterMapper.toDto(characterRepository
                .findById(randomIdOfCharacter).orElseThrow());
        return characterMapper.toCharacterInternalDto(characterDto);
    }

    public List<CharacterInternalDto> findAllByName(String name) {
        List<CharacterInternal> byName = characterRepository
                .findAllByNameContainingIgnoreCase(name);
        return byName
                .stream()
                .map(characterMapper::toCharacterInternalDto)
                .toList();
    }
}

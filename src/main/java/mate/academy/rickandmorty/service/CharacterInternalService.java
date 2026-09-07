package mate.academy.rickandmorty.service;

import lombok.AllArgsConstructor;
import mate.academy.rickandmorty.dto.external.CharacterDto;
import mate.academy.rickandmorty.dto.internal.CharacterInternalDto;
import mate.academy.rickandmorty.mapper.CharacterMapper;
import mate.academy.rickandmorty.repository.CharacterRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CharacterInternalService {
    private final CharacterClient characterClient;
    private final CharacterMapper characterMapper;
    private final CharacterRepository characterRepository;

    public CharacterInternalDto getInternalCharacter() {
        CharacterDto characterDto = characterClient.getRandomCharacter();
        return characterMapper.toCharacterInternalDto(characterDto);
    }
}

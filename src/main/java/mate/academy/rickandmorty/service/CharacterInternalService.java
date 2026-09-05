package mate.academy.rickandmorty.service;

import lombok.AllArgsConstructor;
import mate.academy.rickandmorty.dto.external.CharachterDto;
import mate.academy.rickandmorty.dto.internal.CharachterInternalDto;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CharacterInternalService {
    private final CharacterClient characterClient;

    public CharachterInternalDto getInternalCharachter() {
        CharachterDto charachterDto = characterClient.getRandomCharacter();
        // return charachterMapper.charachterDtoToCharachterInternalDto(charachterDto);

        return new CharachterInternalDto(2, String.valueOf(
                charachterDto.id()),
                charachterDto.name(),
                charachterDto.status(),
                charachterDto.gender());
    }
}

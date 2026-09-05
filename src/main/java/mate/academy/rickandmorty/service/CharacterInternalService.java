package mate.academy.rickandmorty.service;

import lombok.AllArgsConstructor;
import mate.academy.rickandmorty.dto.external.CharachterDto;
import mate.academy.rickandmorty.dto.internal.CharachterInternalDto;
import mate.academy.rickandmorty.mapper.CharachterMapper;
import mate.academy.rickandmorty.model.CharachterInternal;
import mate.academy.rickandmorty.repository.CharachterRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CharacterInternalService {
    private final CharacterClient characterClient;
    private final CharachterMapper charachterMapper;
    private final CharachterRepository charachterRepository;

    public CharachterInternalDto getInternalCharachter() {
        CharachterDto charachterDto = characterClient.getRandomCharacter();
        CharachterInternal save = charachterRepository.save(charachterMapper.toEntity(charachterDto));
        return charachterMapper.toCharachterInternalDto(save);
    }
}

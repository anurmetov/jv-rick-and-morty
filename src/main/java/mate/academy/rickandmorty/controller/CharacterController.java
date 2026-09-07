package mate.academy.rickandmorty.controller;

import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.PageDto;
import mate.academy.rickandmorty.dto.internal.CharachterInternalDto;
import mate.academy.rickandmorty.service.CharacterClient;
import mate.academy.rickandmorty.service.CharacterInternalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterInternalService characterInternalService;
    private final CharacterClient characterClient;

    @GetMapping("/random")
    public CharachterInternalDto getRandomCharacter() {
        return characterInternalService.getInternalCharachter();
    }

    @GetMapping("/load")
    public void loadAllCharachters() {
        characterClient.loadAllCharachters();
    }
}

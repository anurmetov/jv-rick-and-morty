package mate.academy.rickandmorty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.CharacterInternalDto;
import mate.academy.rickandmorty.service.CharacterClient;
import mate.academy.rickandmorty.service.CharacterInternalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Rick and Morty Custom API Implementation")
public class CharacterController {

    private final CharacterInternalService characterInternalService;
    private final CharacterClient characterClient;

    @GetMapping("/random")
    @Operation(summary = "Get random Character from API",
            description = "The request randomly generates a"
            + " wiki about one character in the universe the animated series Rick & Morty")
    public CharacterInternalDto getRandomCharacter() {
        return characterInternalService.getInternalCharacter();
    }
}

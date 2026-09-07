package mate.academy.rickandmorty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.CharacterInternalDto;
import mate.academy.rickandmorty.service.CharacterInternalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Rick and Morty Custom API Implementation")
public class CharacterController {

    private final CharacterInternalService characterInternalService;

    @GetMapping("/random")
    @Operation(summary = "Get random Character from API",
            description = "The request randomly generates a"
            + " wiki about one character in the universe the animated series Rick & Morty")
    public CharacterInternalDto getRandomCharacter() {
        return characterInternalService.getInternalCharacter();
    }

    @GetMapping("/search")
    @Operation(summary = "Get characters from API by name",
            description = "The request finds a"
                    + " List of wiki about founded characters in the "
                    + "universe the animated series Rick & Morty")
    public List<CharacterInternalDto> findByName(@RequestParam String name) {
        return characterInternalService.findAllByName(name);
    }
}

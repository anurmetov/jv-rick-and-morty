package mate.academy.rickandmorty.controller;

import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.internal.CharachterInternalDto;
import mate.academy.rickandmorty.service.CharacterInternalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterInternalService characterInternalService;

    @GetMapping("/random")
    public CharachterInternalDto getRandomCharacter() {
        return characterInternalService.getInternalCharachter();
    }
}

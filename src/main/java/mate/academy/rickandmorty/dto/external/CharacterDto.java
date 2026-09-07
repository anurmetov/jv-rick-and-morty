package mate.academy.rickandmorty.dto.external;

import java.util.List;

public record CharacterDto(
        int id,
        String name,
        String status,
        String species,
        String type,
        String gender,
        CharacterOrigin origin,
        CharacterLocation location,
        String image,
        List<String> episode,
        String url,
        String created
) {
}

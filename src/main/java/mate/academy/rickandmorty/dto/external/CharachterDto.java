package mate.academy.rickandmorty.dto.external;

import java.util.List;

public record CharachterDto(
        int id,
        String name,
        String status,
        String species,
        String type,
        String gender,
        CharachterOrigin origin,
        CharachterLocation location,
        String image,
        List<String> episode,
        String url,
        String created
) {


}

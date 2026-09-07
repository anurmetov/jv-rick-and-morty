package mate.academy.rickandmorty.dto.external;

import java.util.List;

public record PageDto(
        CharachterInfo info,
        List<CharachterDto> results
) {
}

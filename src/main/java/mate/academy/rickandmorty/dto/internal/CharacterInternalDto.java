package mate.academy.rickandmorty.dto.internal;

public record CharacterInternalDto(int id,
                                   String externalId,
                                   String name,
                                   String status,
                                   String gender) {
}

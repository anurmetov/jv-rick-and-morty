package mate.academy.rickandmorty.mapper;

import mate.academy.rickandmorty.dto.external.CharachterDto;
import mate.academy.rickandmorty.dto.internal.CharachterInternalDto;
import mate.academy.rickandmorty.model.CharachterInternal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CharachterMapper {

    @Mapping(source = "id", target = "externalId")
    @Mapping(target = "id", ignore = true)
    CharachterInternal toEntity(CharachterDto charachterDto);


    CharachterInternalDto toCharachterInternalDto(CharachterInternal charachterInternal);



}

package de.unibayreuth.se.teaching.list.api.mapper;

import de.unibayreuth.se.teaching.list.api.dto.ListElementDto;
import de.unibayreuth.se.teaching.list.business.ports.Value;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ListElementDtoMapper {
    /**
     * Mapper function to convert a Value to a ListElementDto.
     * @param source the Value object (from the business layer) to map to a ListElementDto
     * @return the mapped ListElementDto
     */
    @Mapping(target = "value", source = "doubleValue")
    @Mapping(target = "metadata", expression = "java(new String())")
    ListElementDto toDto(Value source);

    /**
     * Mapper function to convert a ListElementDto to a Value.
     * @param source the ListElementDto object to map to a Value object (for the business layer)
     * @return the mapped Value object
     */
    @Mapping(target = "doubleValue", source = "value")
    @Mapping(target = "longValue", ignore = true)
    Value toEntity(ListElementDto source);
}


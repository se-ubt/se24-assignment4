package de.unibayreuth.se.teaching.list.api.controller;

import de.unibayreuth.se.teaching.list.api.dto.ListElementDto;
import de.unibayreuth.se.teaching.list.business.ports.ListService;
import de.unibayreuth.se.teaching.list.business.ports.Value;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ListController {
    private final ListService listService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<ListElementDto>> getList() {
        return ResponseEntity.ok(listService.get().stream()
                // this::toDto is short for "apply that method to all elements in the stream"
                // in this case: map(element -> toDto(element)
                .map(this::toDto)
                .toList()
        );
    }

    @PostMapping(value = "/list")
    public ResponseEntity<List<ListElementDto>> appendList(@RequestBody List<ListElementDto> elements) {
        listService.append(elements.stream()
                .map(this::toValue)
                .toList()
        );
        // ResponseEntity.ok(...) is a shortcut for "create a response entity with status 200 (OK) and the provided body
        return ResponseEntity.ok(listService.get().stream()
                .map(this::toDto)
                .toList());
    }

    /**
     * Mapper function to convert a Value to a ListElementDto.
     * @param value the Value object (from the business layer) to map to a ListElementDto
     * @return the mapped ListElementDto
     */
    private ListElementDto toDto(Value value) {
        return new ListElementDto(value.getDoubleValue(), "");
    }

    /**
     * Mapper function to convert a ListElementDto to a Value.
     * @param dto the ListElementDto object to map to a Value object (for the business layer)
     * @return the mapped Value object
     */
    private Value toValue(ListElementDto dto) {
        return new Value(dto.value());
    }
}

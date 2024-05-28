package de.unibayreuth.se.teaching.list.api.controller;

import de.unibayreuth.se.teaching.list.api.dto.ListElementDto;
import de.unibayreuth.se.teaching.list.api.mapper.ListElementDtoMapper;
import de.unibayreuth.se.teaching.list.business.ports.ListService;
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
    private final ListElementDtoMapper listElementDtoMapper;

    @GetMapping(value = "/list")
    public ResponseEntity<List<ListElementDto>> getList() {
        return ResponseEntity.ok(listService.get().stream()
                // listElementDtoMapper::toDto is short for "apply that method to all elements in the stream"
                // in this case: map(element -> toDto(element)
                .map(listElementDtoMapper::toDto)
                .toList()
        );
    }

    @PostMapping(value = "/list")
    public ResponseEntity<List<ListElementDto>> appendList(@RequestBody List<ListElementDto> elements) {
        listService.append(elements.stream()
                .map(listElementDtoMapper::toEntity)
                .toList()
        );
        // ResponseEntity.ok(...) is a shortcut for "create a response entity with status 200 (OK) and the provided body
        return ResponseEntity.ok(listService.get().stream()
                .map(listElementDtoMapper::toDto)
                .toList());
    }
}

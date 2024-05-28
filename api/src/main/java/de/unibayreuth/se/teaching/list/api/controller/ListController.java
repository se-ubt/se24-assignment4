package de.unibayreuth.se.teaching.list.api.controller;

import de.unibayreuth.se.teaching.list.api.dto.ListElementDto;
import de.unibayreuth.se.teaching.list.api.mapper.ListElementDtoMapper;
import de.unibayreuth.se.teaching.list.business.ports.ListService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "ListAPI",
                version = "0.0.1"
        )
)
@Controller
@RequiredArgsConstructor
public class ListController {
    private final ListService listService;
    private final ListElementDtoMapper listElementDtoMapper;

    @Operation(
            summary = "Get all list elements.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(mediaType = "application/json"),
                            description = "All list elements as a JSON array."
                    )
            }
    )
    @GetMapping(value = "/list")
    public ResponseEntity<List<ListElementDto>> getList() {
        return ResponseEntity.ok(listService.get().stream()
                // listElementDtoMapper::toDto is short for "apply that method to all elements in the stream"
                // in this case: map(element -> toDto(element)
                .map(listElementDtoMapper::toDto)
                .toList()
        );
    }

    @Operation(
            summary = "Appends elements to the list.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(mediaType = "application/json"),
                            description = "The list including the appended list elements as a JSON array."
                    )
            }
    )
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

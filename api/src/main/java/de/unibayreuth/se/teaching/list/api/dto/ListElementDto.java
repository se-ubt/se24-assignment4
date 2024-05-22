package de.unibayreuth.se.teaching.list.api.dto;

/**
 * Data transfer object for list elements, to be used in the list controller API endpoints.
 *
 * @param value     The value of the list element.
 * @param metadata  Metadata of the list element (to showcase the DTO might look different from the internal data model).
 */
public record ListElementDto(double value, String metadata) {

}

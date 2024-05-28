package de.unibayreuth.se.teaching.list.data.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Database entity for a list element.
 */
@Entity
@Getter
@Setter
@Table(name = "list")
public class ListEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    private Double value;
}

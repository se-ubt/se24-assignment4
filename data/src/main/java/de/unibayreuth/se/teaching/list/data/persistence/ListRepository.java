package de.unibayreuth.se.teaching.list.data.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository for persisting list entities.
 */
public interface ListRepository extends JpaRepository<ListEntity, UUID> {

}

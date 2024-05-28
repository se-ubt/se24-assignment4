package de.unibayreuth.se.teaching.list.data.impl;

import de.unibayreuth.se.teaching.list.business.ports.ListDataService;
import de.unibayreuth.se.teaching.list.data.persistence.ListEntity;
import de.unibayreuth.se.teaching.list.data.persistence.ListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Database-based implementation of the data service that the business layer provides as a port.
 */
@Service
@RequiredArgsConstructor
@Qualifier("dbDataService")
@Profile("db") // prevent this service from being loaded as long as we have not discussed Docker in the lecture
class ListDataServiceDbImpl implements ListDataService {
    private final ListRepository repository;

    @Override
    public java.util.List<Double> get() {
        return repository.findAll().stream()
                .map(ListEntity::getValue)
                .toList();
    }

    @Override
    public void append(Double value) {
        ListEntity entity = new ListEntity();
        entity.setValue(value);
        repository.saveAndFlush(entity);
    }
}

package de.unibayreuth.se.teaching.list.data.impl;

import de.unibayreuth.se.teaching.list.business.ports.ListDataService;
import de.unibayreuth.se.teaching.list.data.persistence.DoublyLinkedList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Doubly-linked-list-based implementation of the data service that the business layer provides as a port.
 */
@Service
@RequiredArgsConstructor
@Qualifier("doublyLinkedListDataService")
@Primary
class ListDataServiceDoublyLinkedImpl implements ListDataService {
    private final DoublyLinkedList list;

    @Override
    public List<Double> get() {
        return Arrays.stream(list.asArray()).boxed().toList();
    }

    @Override
    public void append(Double value) {
        list.append(value);
    }
}

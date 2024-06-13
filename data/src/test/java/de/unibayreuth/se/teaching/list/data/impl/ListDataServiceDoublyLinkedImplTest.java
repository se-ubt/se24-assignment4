package de.unibayreuth.se.teaching.list.data.impl;

import de.unibayreuth.se.teaching.list.data.persistence.DoublyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ListDataServiceDoublyLinkedImplTest {
    @Mock
    DoublyLinkedList mockedList;

    private ListDataServiceDoublyLinkedImpl sut;

    @BeforeEach
    void setUp() {
        sut = new ListDataServiceDoublyLinkedImpl(mockedList);
    }

    @Test
    void testGet() {
        when(mockedList.asArray()).thenReturn(new double[]{});
        sut.get();
        verify(mockedList).asArray();
    }

    @Test
    void testAppend() {
        double value = 0.2;
        sut.append(value);
        verify(mockedList).append(value);
    }
}

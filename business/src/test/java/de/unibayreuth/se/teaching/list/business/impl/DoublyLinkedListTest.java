package de.unibayreuth.se.teaching.list.business.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the doubly linked list.
 */
class DoublyLinkedListTest {
    private DoublyLinkedList list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList();
    }

    @Test
    void testAppendElement() {
        // given: the list is empty...
        Assertions.assertEquals(0, list.getLength());
        var element = new DoublyLinkedList.Element(0.9);
        // when: appending an element
        list.append(element);
        // then: the list has one element...
        Assertions.assertEquals(1, list.getLength());
        // ...and the new element is the start and end of the list
        Assertions.assertEquals(element, list.getStart());
        Assertions.assertEquals(element, list.getEnd());
        // ...and the start and end pointers do not have predecessors or successors
        Assertions.assertNull(list.getStart().getPrev());
        Assertions.assertNull(list.getStart().getNext());
        Assertions.assertNull(list.getEnd().getPrev());
        Assertions.assertNull(list.getEnd().getNext());
    }

    @Test
    void testInsertNewMinimum() {
        // given: the list as four sorted elements
        Assertions.assertTrue(list.isEmpty());
        list.append(new double[]{0.2, 0.4, 0.5, 0.8});
        // when: inserting a new element with a value smaller than the minimum of the list
        list.insert(new DoublyLinkedList.Element(0.1));
        // then: the new element is the start of the list
        Assertions.assertArrayEquals(new double[]{0.1, 0.2, 0.4, 0.5, 0.8}, list.asArray());
    }

    @Test
    void testInsertNewMaximum() {
        // given: the list as four sorted elements
        Assertions.assertTrue(list.isEmpty());
        list.append(new double[]{0.2, 0.4, 0.5, 0.8});
        // when: inserting a new element with a value greater than the maximum of the list
        list.insert(new DoublyLinkedList.Element(0.9));
        // then: the new element is the end of the list
        Assertions.assertArrayEquals(new double[]{0.2, 0.4, 0.5, 0.8, 0.9}, list.asArray());
    }

    @Test
    void testInsertNeitherMinimumNorMaximum() {
        // given: the list as four sorted elements
        Assertions.assertTrue(list.isEmpty());
        list.append(new double[]{0.2, 0.4, 0.5, 0.8});
        // when: inserting a new element with a value between the minimum and the maximum of the list
        list.insert(new DoublyLinkedList.Element(0.6));
        // then: the new element is placed in the right position
        Assertions.assertArrayEquals(new double[]{0.2, 0.4, 0.5, 0.6, 0.8}, list.asArray());
    }

    @Test
    void testAppendElementFromOtherList() {
        // give: an empty list and another list with three elements
        Assertions.assertTrue(list.isEmpty());
        DoublyLinkedList otherList = new DoublyLinkedList();
        otherList.append(new double[]{0.9, 0.5, 0.4});
        // when: appending the first element from the other list
        // then: expect an exception to be raised
        var firstElement = otherList.getStart();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.append(firstElement));
        // when: appending the second element from the other list
        // then: expect an exception to be raised
        var secondElement = otherList.getStart().getNext();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.append(secondElement));
        // when: appending the third element from the other list
        // then: expect an exception to be raised
        var lastElement = otherList.getEnd();
        Assertions.assertThrows(IllegalArgumentException.class, () -> list.append(lastElement));
    }

    @Test
    void testAppendOneElementByValue() {
        // given: the list is empty
        Assertions.assertEquals(0, list.getLength());
        // when: appending a new element
        list.append(0.9);
        // then: the list has one element...
        Assertions.assertEquals(1, list.getLength());
        // ...and the new element is the start and end of the list
        Assertions.assertEquals(0.9, list.getStart().getValue());
        Assertions.assertEquals(0.9, list.getEnd().getValue());
        // ...and the start and end pointers do not have predecessors or successors
        Assertions.assertNull(list.getStart().getPrev());
        Assertions.assertNull(list.getStart().getNext());
        Assertions.assertNull(list.getEnd().getPrev());
        Assertions.assertNull(list.getEnd().getNext());
    }

    @Test
    void testAppendTwoElementsByValue() {
        // given: the list is empty
        Assertions.assertEquals(0, list.getLength());
        // when: appending two new elements
        list.append(0.9);
        list.append(0.5);
        // then: the list has two elements...
        Assertions.assertEquals(2, list.getLength());
        // ...and the first element is the start and the second element is the end of the list
        Assertions.assertEquals(0.9, list.getStart().getValue());
        Assertions.assertEquals(0.5, list.getEnd().getValue());
        // ...and they are correctly linked
        Assertions.assertEquals(0.5, list.getStart().getNext().getValue());
        Assertions.assertEquals(0.9, list.getEnd().getPrev().getValue());
        // ...and the start and end pointers are correctly set
        testBeginEndPointers(list);
    }

    @Test
    void testAppendThreeElementsByValue() {
        // given: the list is empty
        Assertions.assertEquals(0, list.getLength());
        // when: appending three new elements
        list.append(0.9);
        list.append(0.5);
        list.append(0.4);
        // then: the list has three elements...
        Assertions.assertEquals(3, list.getLength());
        // ...and the first element is the start and the third element is the end of the list
        Assertions.assertEquals(0.9, list.getStart().getValue());
        Assertions.assertEquals(0.4, list.getEnd().getValue());
        // ...and all elements are correctly linked
        Assertions.assertEquals(0.5, list.getStart().getNext().getValue());
        Assertions.assertEquals(0.5, list.getEnd().getPrev().getValue());
        // ...and the start and end pointers are correctly set
        testBeginEndPointers(list);
    }

    @Test
    void testEmptyListToArray() {
        // given: the list is empty
        Assertions.assertEquals(0, list.getLength());
        // then: the array representation of the list is equal to an empty array
        Assertions.assertArrayEquals(new double[]{}, list.asArray());
        list.append(0.9);
        list.append(0.5);
        list.append(0.4);
        Assertions.assertArrayEquals(new double[]{0.9, 0.5, 0.4}, list.asArray());
    }

    @Test
    void testListToArray() {
        // given: the list is empty
        Assertions.assertEquals(0, list.getLength());
        // when: appending three elements
        list.append(0.9);
        list.append(0.5);
        list.append(0.4);
        // then: the array representation of the list is equal to the array with the elements in the same order
        Assertions.assertArrayEquals(new double[]{0.9, 0.5, 0.4}, list.asArray());
    }

    @Test
    void testAppendArray() {
        // given: the list is empty
        Assertions.assertEquals(0, list.getLength());
        // when: appending an array with three elements
        double[] data = new double[]{0.9, 0.5, 0.4};
        list.append(data);
        // then: the array representation of the list is equal to the appended array
        Assertions.assertArrayEquals(data, list.asArray());
    }

    @Test
    void testIsEmptyOnEmptyList() {
        // given: the list is empty
        Assertions.assertTrue(list.isEmpty());
        // then: the array representation of the list is equal to an empty array
        Assertions.assertEquals(0, list.asArray().length);
    }

    @Test
    void testIsEmptyOnNonEmptyList() {
        // given: the list has three elements
        Assertions.assertTrue(list.isEmpty());
        list.append(0.9);
        list.append(0.5);
        list.append(0.4);
        // then: the list is not empty
        Assertions.assertFalse(list.isEmpty());
        // when: clearing the list
        list.clear();
        // then: the list is empty again
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    void testAppendOtherList() {
        // give: an empty list and another list with three elements
        Assertions.assertTrue(list.isEmpty());
        var data = new double[]{0.9, 0.5, 0.4};
        DoublyLinkedList otherList = new DoublyLinkedList();
        otherList.append(data);
        // when: appending the other list
        list.append(otherList);
        // then: expect the list to contain the elements of the other list in the same order
        Assertions.assertArrayEquals(data, list.asArray());
    }

    @Test
    void testToStringEmptyList() {
        // given: the list is empty
        Assertions.assertTrue(list.isEmpty());
        // then: the string representation of the list is "Empty."
        Assertions.assertEquals("Empty.", list.toString());
    }

    @Test
    void testToStringNonEmptyList() {
        // given: the list has three elements
        Assertions.assertTrue(list.isEmpty());
        list.append(0.9);
        list.append(0.5);
        list.append(0.4);
        // then: the string representation of the list is "0.9<->0.5<->0.4"
        Assertions.assertEquals("0.9<->0.5<->0.4", list.toString());
    }

    /**
     * Helper method to test begin and end pointers of a doubly linked list
     * @param list List to test
     */
    private static void testBeginEndPointers(DoublyLinkedList list) {
        Assertions.assertNull(list.getStart().getPrev());
        Assertions.assertSame(list.getStart().getNext().getPrev(), list.getStart());
        Assertions.assertNull(list.getEnd().getNext());
        Assertions.assertSame(list.getEnd().getPrev().getNext(), list.getEnd());
    }
}

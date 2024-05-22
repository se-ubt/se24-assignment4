package de.unibayreuth.se.teaching.list.business.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Our doubly linked list implementation from previous assignments.
 */
@Getter
@Setter
@Slf4j
@Component
public class DoublyLinkedList {
    private Element start;
    private Element end;
    private int length;

    private static final Logger logger = LoggerFactory.getLogger(DoublyLinkedList.class);

    /**
     * Add an element at the end of the list
     * @param e New list element
     * @param elementValidation If true, the method checks whether the element is already part of a list
     */
    public void append(Element e, boolean elementValidation) {
        if (elementValidation && (e.getPrev() != null || e.getNext() != null)) {
            throw new IllegalArgumentException("Element is already part of a list.");
        }

        if (start == null) {
            start = e;
            end = e;
            e.setPrev(null);
            e.setNext(null);
        } else {
            Element tmp = end;
            end = e;
            tmp.setNext(e);
            e.setPrev(tmp);
            e.setNext(null);
        }
        length++;
    }

    /**
     * Add an element at the end of the list with element validation enabled
     * @param e New list element
     */
    public void append(Element e) {
        append(e, true);
    }

    /**
     * Create a new element with the provided value and append it to the list
     * @param value Value of the new list element
     */
    public void append(double value) {
        append(new Element(value));
    }

    /**
     * Append all elements in the provided list to this list
     * @param list The list of which the elements should be appended
     */
    public void append(DoublyLinkedList list) {
        Element e = list.getStart();
        while (e != null) {
            Element next = e.getNext(); // append sets e.next to null
            append(e, false);
            e = next;
        }
    }

    /**
     * Create one element per value in the array and append the new elements to this list
     * @param values Array with values to append
     */
    public void append(double[] values) {
        for (double value : values) {
            append(value);
        }
    }

    /**
     * Create a new array with the elements in this list (in the same order)
     * @return Array with list elements (same order)
     */
    public double[] asArray() {
        double[] array = new double[length];
        Element element = start;
        int arrayPos = 0;
        while (element != null) {
            array[arrayPos] = element.value;
            arrayPos++;
            element = element.next;
        }
        return array;
    }

    /**
     * Print the list to the standard output
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "Empty.";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Element pos = start;
        stringBuilder.append(start.getValue());
        pos = pos.next;
        while (pos != null) {
            stringBuilder.append("<->").append(pos.getValue());
            pos = pos.next;
        }
        return stringBuilder.toString();
    }

    /**
     * Remove all list elements
     */
    public void clear() {
        start = null;
        end = null;
        length = 0;
    }

    /**
     * Checks whether list does not contain any elements
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return start == null && end == null && length == 0;
    }

    /**
     * Insert an element at the correct position in a sorted list
     * @param e Element to insert into the sorted list
     */
    public void insert(Element e) {
        if (isEmpty()) { // If the list is empty, just append the new element
            append(e);
        } else { // Otherwise the element needs to be sorted in...
            Element pos = start;
            Element pred = null;
            // Find position pos, before which the element is supposed to be located
            while (pos != null && pos.getValue() < e.getValue()) {
                pred = pos;
                pos = pos.getNext();
            }
            if (pos == null) { // There is no larger element => append new element to the list
                append(e);
            } else { // Add the new element before element at pos
                e.setNext(pos);
                pos.setPrev(e);
                if (pred != null) { // If pos is not first element in list...
                    e.setPrev(pred);
                    pred.setNext(e);
                } else { // If pos is the first element in the list...
                    start = e;
                }
                length++;
            }
        }
    }

    /**
     * Insert a new element with the given value into the correct position in a sorted list
     * @param value Value of the new element to insert into the sorted list
     */
    public void insert(double value) {
        insert(new Element(value));
    }

    /**
     * Inner class for doubly linked list elements
     */
    @Setter
    @Getter
    @RequiredArgsConstructor
    public static class Element {
        private final double value;
        private Element next;
        private Element prev;
    }

}

package de.unibayreuth.se.teaching.list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class for demo purposes.
 */
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        // Create list and add some values...
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(new double[]{0.5, 4.2, 3.3, 0.9});

        logger.info("The list contains the following elements:");
        String listAsString = list.toString();
        logger.info(listAsString);
    }
}

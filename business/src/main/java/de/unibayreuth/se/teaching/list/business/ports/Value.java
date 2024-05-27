package de.unibayreuth.se.teaching.list.business.ports;

import lombok.Data;

/**
 * Class which stores the value of a list element.
 */
@Data
public class Value {
    private final Double doubleValue;
    private Long longValue; // example for a derived value that the business layer might provide
}

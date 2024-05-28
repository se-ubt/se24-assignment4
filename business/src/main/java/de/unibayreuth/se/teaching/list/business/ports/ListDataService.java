package de.unibayreuth.se.teaching.list.business.ports;

import java.util.List;

/**
 * Interface for the implementation of the data layer that the business layer provides as a port.
 */
public interface ListDataService {
    List<Double> get();
    void append(Double value);
}

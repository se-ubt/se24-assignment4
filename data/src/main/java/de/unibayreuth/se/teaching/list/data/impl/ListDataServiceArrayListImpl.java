package de.unibayreuth.se.teaching.list.data.impl;

import de.unibayreuth.se.teaching.list.business.ports.ListDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("arrayListDataService")
public class ListDataServiceArrayListImpl implements ListDataService {
    private final ArrayList<Double> list = new ArrayList<>();

    @Override
    public List<Double> get() {
        return list;
    }

    @Override
    public void append(Double value) {
        list.add(value);
    }
}

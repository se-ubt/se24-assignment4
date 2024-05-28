package de.unibayreuth.se.teaching.list.business.impl;

import de.unibayreuth.se.teaching.list.business.ports.ListDataService;
import de.unibayreuth.se.teaching.list.business.ports.ListService;
import de.unibayreuth.se.teaching.list.business.ports.Value;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListServiceImpl implements ListService {
    private final ListDataService listDataService;

    @Override
    public List<Value> get() {
        return listDataService.get().stream()
                .map(Value::new) // same shortcut as used in the controller, here: call constructor with value as argument
                .toList();
    }

    @Override
    public void append(List<Value> valuesToAppend) {
        valuesToAppend.forEach(
                value -> listDataService.append(value.getDoubleValue())
        );
    }
}

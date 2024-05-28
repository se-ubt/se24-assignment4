package de.unibayreuth.se.teaching.list;

import de.unibayreuth.se.teaching.list.business.ports.ListService;
import de.unibayreuth.se.teaching.list.business.ports.Value;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Load initial data into the list via the list service from the business layer.
 */
@Component
@RequiredArgsConstructor
@Slf4j
class LoadInitialData implements InitializingBean {
    private final ListService listDataService;

    @Override
    public void afterPropertiesSet() {
        log.info("Loading initial data...");
        listDataService.append(Stream.of(0.1, 0.2, 0.3)
                .map(Value::new)
                .toList()
        );
    }
}
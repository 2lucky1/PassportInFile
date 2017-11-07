package com.muntian.passportinfile.services.accessors;

import java.util.Collection;
import java.util.Collections;

public interface AbstractAccessor <T> {
    default void save(T entity) {
        save(Collections.singletonList(entity));
    }
    void save(Collection<T> entities);
    Collection<T> readAll();

    void startReading();

    /**
     * Читаем один следующий объект из файла
     *
     * @return считанный объект или null если все считано
     */
    T read();

    void stopReading();
}
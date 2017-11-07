package com.muntian.passportinfile.services.accessors.impl;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collection;

public abstract class AbstractTextFileAccessor<T> {

    private String _fileName;

    public AbstractTextFileAccessor(String fileName) {
        _fileName = fileName;
    }

    public void save(Collection<T> entities) {
        try (PrintStream writer = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(_fileName)
                )
        )) {

            for (T entity: entities) {
                saveEntity(writer, entity);
                writer.println("--------------------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected abstract void saveEntity(PrintStream writer, T entity);


}

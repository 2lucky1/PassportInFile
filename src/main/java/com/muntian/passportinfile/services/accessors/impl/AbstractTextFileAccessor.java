package com.muntian.passportinfile.services.accessors.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

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

    //My code
    public Collection<T> readAll() {
        Collection<T> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(_fileName))) {
            while (scanner.hasNextLine()) {
                readEntity(result, scanner);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    //My code
    protected abstract void readEntity(Collection<T> result, Scanner scanner);


}

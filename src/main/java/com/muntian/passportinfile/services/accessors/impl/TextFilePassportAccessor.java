package com.muntian.passportinfile.services.accessors.impl;

import com.muntian.passportinfile.entities.Passport;
import com.muntian.passportinfile.services.accessors.PassportAccessor;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Scanner;

public class TextFilePassportAccessor
        extends AbstractTextFileAccessor<Passport>
        implements PassportAccessor {

    private String _fileName;

    public TextFilePassportAccessor(String fileName) {
        super(fileName);
        _fileName = fileName;
    }

    protected void saveEntity(PrintStream writer, Passport passport) {
        writer.println(passport.getNumber());
        writer.println(passport.getName());
        writer.println(passport.getLastName());
    }

    //I`v moved this code in method
    protected void readEntity(Collection<Passport> result, Scanner scanner) {
        String number = scanner.nextLine();
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        scanner.nextLine();
        Passport readPassport = new Passport(firstName, lastName, number);
        result.add(readPassport);
    }

    @Override
    public void startReading() {

    }

    @Override
    public Passport read() {
        return null;
    }

    @Override
    public void stopReading() {

    }
}
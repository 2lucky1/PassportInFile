package com.muntian.passportinfile.services.accessors.impl;

import com.muntian.passportinfile.entities.Visa;
import com.muntian.passportinfile.services.accessors.VisaAccessor;

import java.io.PrintStream;
import java.util.*;

public class TextFileVisaAccessor
        extends AbstractTextFileAccessor<Visa>
        implements VisaAccessor {


    public TextFileVisaAccessor(String fileName) {
        super(fileName);
    }

    @Override
    protected void saveEntity(PrintStream writer, Visa visa) {
        writer.println(visa.getPassportNumber());
        writer.println(visa.getCountry());
        writer.println(visa.getFrom().getTime().getTime());
        writer.println(visa.getTo().getTime().getTime());
    }

    //My code
    @Override
    protected void readEntity(Collection<Visa> result, Scanner scanner) {
        String number = scanner.nextLine();
        String country = scanner.nextLine();
        Calendar from = new GregorianCalendar();
        from.setTimeInMillis(Long.parseLong(scanner.nextLine()));
        Calendar to = new GregorianCalendar();
        to.setTimeInMillis(Long.parseLong(scanner.nextLine()));
        Visa readVisa = new Visa(number,country,from,to);
        result.add(readVisa);
    }

    @Override
    public void startReading() {

    }

    @Override
    public Visa read() {
        return null;
    }

    @Override
    public void stopReading() {

    }
}

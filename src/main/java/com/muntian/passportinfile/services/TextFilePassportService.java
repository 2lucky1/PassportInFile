package com.muntian.passportinfile.services;

import com.muntian.passportinfile.entities.Passport;
import com.muntian.passportinfile.entities.Visa;
import com.muntian.passportinfile.services.accessors.PassportAccessor;
import com.muntian.passportinfile.services.accessors.VisaAccessor;
import com.muntian.passportinfile.services.accessors.impl.TextFilePassportAccessor;
import com.muntian.passportinfile.services.accessors.impl.TextFileVisaAccessor;

import java.util.*;

//This class is my code
public class TextFilePassportService implements PassportService {
    private PassportAccessor passportAccessor;
    private VisaAccessor visaAccessor;
    private Collection<Passport> passports;
    private Collection<Visa> visas;
    private Map<String, Visa> visaMap;

    public TextFilePassportService(String passportFileName, String visaFileName) {
        this.passportAccessor = new TextFilePassportAccessor(passportFileName);

        this.visaAccessor = new TextFileVisaAccessor(visaFileName);
        this.passports = passportAccessor.readAll();
        this.visas = visaAccessor.readAll();
        this.visaMap = new HashMap<>();
    }

    @Override
    public Collection<Passport> readAll() {
        for (Visa visa : visas) {
            visaMap.put(visa.getPassportNumber(), visa);
        }
        for (Passport passport : passports) {
            passport.addVisa(visaMap.get(passport.getNumber()));
        }
        return passports;
    }

    @Override
    public void save(Collection<Passport> passports) {
        for (Passport passport : passports) {
            visaAccessor.save(passport.getVisas());
        }
        passportAccessor.save(passports);
    }
}

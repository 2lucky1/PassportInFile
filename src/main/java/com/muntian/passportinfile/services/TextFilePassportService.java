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

    @Override
    public Collection<Passport> readAll(String passportFileName, String visaFileName) {
        PassportAccessor passportAccessor = new TextFilePassportAccessor(passportFileName);
        VisaAccessor visaAccessor = new TextFileVisaAccessor(visaFileName);
        Collection<Passport> passports = passportAccessor.readAll();
        Collection<Visa> visas = visaAccessor.readAll();
        Map<String,Visa> visaMap = new HashMap<>();
        for (Visa visa : visas) {
            visaMap.put(visa.getPassportNumber(),visa);
        }
        for (Passport passport : passports) {
            passport.addVisa(visaMap.get(passport.getNumber()));
        }
        return passports;
    }

    @Override
    public void save(Collection<Passport> passports, String passportsFileName, String visasFileName) {
        VisaAccessor visaAccessor = new TextFileVisaAccessor(visasFileName);
        for (Passport passport : passports) {
            visaAccessor.save(passport.getVisas());
        }

        PassportAccessor passportAccessor = new TextFilePassportAccessor(passportsFileName);
        passportAccessor.save(passports);

    }
}

package com.muntian.passportinfile.services;

import com.muntian.passportinfile.entities.Passport;
import com.muntian.passportinfile.entities.Visa;
import com.muntian.passportinfile.services.accessors.PassportAccessor;
import com.muntian.passportinfile.services.accessors.VisaAccessor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//This class is my code
public class TextFilePassportService implements PassportService {
    private PassportAccessor passportAccessor;
    private VisaAccessor visaAccessor;

    public TextFilePassportService(PassportAccessor passportAccessor, VisaAccessor visaAccessor,
                                   String passportFileName, String visaFileName) {
        this.passportAccessor = passportAccessor;
        this.visaAccessor = visaAccessor;
    }

    @Override
    public Collection<Passport> readAll() {
        Map<String, Visa> visaMap = new HashMap<>();
        Collection<Visa> visas = visaAccessor.readAll();
        Collection<Passport> passports = passportAccessor.readAll();

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

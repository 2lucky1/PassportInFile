package com.muntian.passportinfile.services;

import com.muntian.passportinfile.entities.Passport;

import java.util.Collection;

public interface PassportService {
    Collection<Passport> readAll(String passportFileName, String visaFileName);
    void save(Collection<Passport> passports,String passportsFileName,String visasFileName);

}

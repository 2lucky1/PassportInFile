package com.muntian.passportinfile.services;

import com.muntian.passportinfile.entities.Passport;

import java.util.Collection;

public interface PassportService {
    Collection<Passport> readAll();
    void save(Collection<Passport> passports);

}

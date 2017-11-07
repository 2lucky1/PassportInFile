package com.muntian.passportinfile.services;

import com.muntian.passportinfile.entities.Passport;

import java.util.Collection;

public interface PassportService {
    Collection<Passport> readAll();
    Collection<Passport> save(Collection<Passport> passports);

}

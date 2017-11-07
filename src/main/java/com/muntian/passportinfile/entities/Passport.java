package com.muntian.passportinfile.entities;

import java.util.Collection;
import java.util.Collections;

public class Passport {
    private String _name;
    private String _lastName;
    private String _number;
    private Collection<Visa> _visas;

    public Passport(String name, String lastName, String number) {
        _name = name;
        _lastName = lastName;
        _number = number;
    }

    public String getName() {
        return _name;
    }

    public String getLastName() {
        return _lastName;
    }

    public String getNumber() {
        return _number;
    }

    public void addVisa(Visa visa) {
        _visas.add(visa);
    }

    public Collection<Visa> getVisas() {
        return Collections.unmodifiableCollection(_visas);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passport passport = (Passport) o;

        if (getName() != null ? !getName().equals(passport.getName()) : passport.getName() != null) return false;
        if (getLastName() != null ? !getLastName().equals(passport.getLastName()) : passport.getLastName() != null)
            return false;
        if (getNumber() != null ? !getNumber().equals(passport.getNumber()) : passport.getNumber() != null)
            return false;
        return getVisas() != null ? getVisas().equals(passport.getVisas()) : passport.getVisas() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "_name='" + _name + '\'' +
                ", _lastName='" + _lastName + '\'' +
                ", _number='" + _number + '\'' +
                ", _visas=" + _visas +
                '}';
    }
}


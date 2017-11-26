package com.muntian.passportinfile.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Visa {
    private String _passportNumber;
    private String _country;
    private Calendar _from;
    private Calendar _to;

    public Visa(String passportNumber, String country, Calendar from, Calendar to) {
        _passportNumber = passportNumber;
        _country = country;
        _from = from;
        _to = to;
    }

    public String getCountry() {
        return _country;
    }

    public Calendar getFrom() {
        return _from;
    }

    public Calendar getTo() {
        return _to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visa visa = (Visa) o;

        if (getCountry() != null ? !getCountry().equals(visa.getCountry()) : visa.getCountry() != null) return false;
        if (getFrom() != null ? !getFrom().equals(visa.getFrom()) : visa.getFrom() != null) return false;
        return getTo() != null ? getTo().equals(visa.getTo()) : visa.getTo() == null;
    }

    @Override
    public int hashCode() {
        int result = getCountry() != null ? getCountry().hashCode() : 0;
        result = 31 * result + (getFrom() != null ? getFrom().hashCode() : 0);
        result = 31 * result + (getTo() != null ? getTo().hashCode() : 0);
        return result;
    }

    public String getPassportNumber() {
        return _passportNumber;
    }

    //My code
    @Override
    public String toString() {
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        return "Visa{" +
                "_passportNumber = " + _passportNumber +
                ", _country = '" + _country + '\'' +
                ", _from = " + formatForDateNow.format(_from.getTime()) +
                ", _to = " + formatForDateNow.format(_to.getTime()) +
                '}';
    }
}

package com.muntian.passportinfile;

import com.muntian.passportinfile.entities.Passport;
import com.muntian.passportinfile.entities.Visa;
import com.muntian.passportinfile.services.PassportService;
import com.muntian.passportinfile.services.TextFilePassportService;
import com.muntian.passportinfile.services.accessors.PassportAccessor;
import com.muntian.passportinfile.services.accessors.VisaAccessor;
import com.muntian.passportinfile.services.accessors.impl.TextFilePassportAccessor;
import com.muntian.passportinfile.services.accessors.impl.TextFileVisaAccessor;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        testWritePassports();
//        testWriteVisas();
//        testReadPassports();
        testTextFilePassportService();
    }

    //My code
    private static void testTextFilePassportService() {
        //Variables with names of files
        String passportsFileName = "passport2.psp";
        String visasFileName = "visa2.psp";

        //Creation of PassportService
        PassportService passportService = new TextFilePassportService(passportsFileName,visasFileName);

        //Creation of the collection of passports with visas
        Collection<Passport> passports = createPassportsWithVisas();

        System.out.println("Writing of passports");
        System.out.println(passports);

        //Saving of the information of the passports to files
        passportService.save(passports);
        System.out.println();

        System.out.println("Reading of passports");
        //Reading of the information of the passports to files
        passportService.readAll();
        System.out.println(passports);
    }

    //My code
    private static Collection<Passport> createPassportsWithVisas() {
        Collection<Passport> passports = Arrays.asList(createPassportsArray());
        Visa[] visas = createVisasArray();

        /*
          This loop compares passport number of each passport with passport number which
          has been written in each visa. If they match, the visa is recorded in the passport.
         */
        for (Passport passport : passports) {
            for (Visa visa : visas) {
                if (passport.getNumber().equals(visa.getPassportNumber())) {
                    passport.addVisa(visa);
                }
            }
        }
        return passports;
    }

    //I`ve changed this code
    protected static void testReadPassports() {
        PassportAccessor passportAccessor = new TextFilePassportAccessor("passports.psp");
        Collection<Passport> passports = passportAccessor.readAll();
        System.out.println(passports);
    }

    //I`ve changed this code
    private static void testWriteVisas() {
        VisaAccessor visaAccessor = new TextFileVisaAccessor("visas.psp");
        Visa[] visas = createVisasArray();
        visaAccessor.save(Arrays.asList(visas));
    }

    /**
     * Create three visas: two with passportNumber = AA213654 and one with passportNumber = AE154789
     *
     * @return Array of Visas
     */
    private static Visa[] createVisasArray() {
        return new Visa[]{
                new Visa("AA213654",
                        "Honduras",
                        new GregorianCalendar(2017, 11, 3),
                        new GregorianCalendar(2017, 12, 3)),

                new Visa("AA213654",
                        "Zimbabwe",
                        new GregorianCalendar(2017, 11, 3),
                        new GregorianCalendar(2019, 1, 1)),

                new Visa("AE154789",
                        "Zimbabwe",
                        new GregorianCalendar(2017, 11, 3),
                        new GregorianCalendar(2019, 1, 1)),

        };
    }

    //I`ve changed this code
    private static void testWritePassports() {
        PassportAccessor passportAccessor = new TextFilePassportAccessor("passports.psp");
        Passport[] passports = createPassportsArray();
        passportAccessor.save(Arrays.asList(passports));
    }

    //I`ve moved this code in method

    /**
     * Create fore examples of Passport
     *
     * @return Array of Passports
     */
    private static Passport[] createPassportsArray() {
        return new Passport[]{
                new Passport("Vasya", "Pupov", "AA213654"),
                new Passport("Petya", "Pupov", "AE154789"),
                new Passport("Grisha", "Pupov", "CA778877"),
                new Passport("Lisa", "Pupova", "KK998877")
        };
    }
}

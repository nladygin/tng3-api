package tng3.guestapi.entity;

import tng3.base.Entity;
import java.util.Objects;


public class Profile implements Entity {

    public int id;
    public String lastName;
    public String firstName;
    public String secondName;
    public String gender;
    public String birthDate;
    public String country;
    public String zipCode;
    public String streetAddress;
    public String city;
    public String phone;
    public String cellPhone;
    public String email;
    public String notes;
    public String company;
    public String jobTitle;
    public String lang;
    public String passport;
    public String validTill;
    public String cardType;
    public String cardStatus;
    public String magstripe;
    public String udfs1;
    public String udfs2;
    public String udfs3;
    public String udfs4;
    public String udfs5;
    public String udfs6;
    public String udfs7;
    public String udfs8;
    public String udfs9;
    public String udfs10;
    public String udfs11;
    public String udfs12;
    public String udfs13;
    public String udfs14;
    public String udfs15;
    public String udfs16;
    public String udfs17;
    public String udfs18;
    public String udfs19;
    public String udfs20;
    public String udfs21;
    public String udfs22;
    public String udfs23;
    public String udfs24;
    public String udfs25;
    public String udfs26;
    public PrivacyOptions privacyOptions;
    public String picture;
    public String password;





    public Profile(
            int id,
            String lastName,
            String firstName,
            String secondName,
            String gender,
            String birthDate,
            String country,
            String zipCode,
            String streetAddress,
            String city,
            String phone,
            String cellPhone,
            String email,
            String notes,
            String company,
            String jobTitle,
            String lang,
            String passport,
            String validTill,
            String cardType,
            String cardStatus,
            String magstripe,
            String udfs1,
            PrivacyOptions privacyOptions,
            String picture,
            String password) {
        this.id             = id;
        this.lastName       = lastName;
        this.firstName      = firstName;
        this.secondName     = secondName;
        this.gender         = gender;
        this.birthDate      = birthDate;
        this.country        = country;
        this.zipCode        = zipCode;
        this.streetAddress  = streetAddress;
        this.city           = city;
        this.phone          = phone;
        this.cellPhone      = cellPhone;
        this.email          = email;
        this.notes          = notes;
        this.company        = company;
        this.jobTitle       = jobTitle;
        this.lang           = lang;
        this.passport       = passport;
        this.validTill      = validTill;
        this.cardType       = cardType;
        this.cardStatus     = cardStatus;
        this.magstripe      = magstripe;
        this.udfs1          = udfs1;
        this.privacyOptions = privacyOptions;
        this.picture        = picture;
        this.password       = password;

/*
        this.id             = id;
        this.lastName       = (lastName == null) ? "API " + utils.generateString() : lastName;
        this.firstName      = (firstName == null) ? "auto" : firstName;
        this.secondName     = (secondName == null) ? "tester" : secondName;
        this.gender         = (gender == null) ?  "M" : gender;
        this.birthDate      = (birthDate == null) ? utils.generateDate("YYYY-MM-dd", -365*20) : birthDate;
        this.country        = (country == null) ? "RU" : country;
        this.zipCode        = (zipCode == null) ? "620000" : zipCode;
        this.streetAddress  = (streetAddress == null) ? "Lenin str" : streetAddress;
        this.city           = (city == null) ? "Ekb" : city;
        this.phone          = (phone == null) ? "1" + String.valueOf(utils.generateDigits(10)) : phone;
        this.cellPhone      = (cellPhone == null) ? "1" + String.valueOf(utils.generateDigits(10)) : cellPhone;
        this.email          = (email == null) ? utils.generateString() + "@autotest.test" : email;
        this.notes          = (notes == null) ? "profile notes " + utils.generateString() : notes;
        this.company        = (company == null) ? "HRS" : company;
        this.jobTitle       = (jobTitle == null) ? "auto tester" : jobTitle;
        this.lang           = (lang == null) ? "RU" : lang;
        this.passport       = (passport == null) ? utils.generateString(10) : passport;
        this.validTill      = (validTill == null) ? utils.generateDate("YYYY-MM-dd", 365) : validTill;
        this.cardType       = (cardType == null) ? "default" : cardType;
        this.cardStatus     = (cardStatus == null) ? "Active" : cardStatus;
        this.magstripe      = (magstripe == null) ? utils.generateString(10) : magstripe;
        this.udfs1          = (udfs1 == null) ? "udfs 1 value" : udfs1;
        this.privacyOptions = new PrivacyOptions();
        this.picture        = (picture == null) ? null : picture;
        this.password       = (password == null) ? "123" : password;
 */
    }


    public Profile(Profile profile){
        this(
                profile.id,
                profile.lastName,
                profile.firstName,
                profile.secondName,
                profile.gender,
                profile.birthDate,
                profile.country,
                profile.zipCode,
                profile.streetAddress,
                profile.city,
                profile.phone,
                profile.cellPhone,
                profile.email,
                profile.notes,
                profile.company,
                profile.jobTitle,
                profile.lang,
                profile.passport,
                profile.validTill,
                profile.cardType,
                profile.cardStatus,
                profile.magstripe,
                profile.udfs1,
                profile.privacyOptions,
                profile.picture,
                profile.password
        );
    }



    public Profile(){
        this(0,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return //id == profile.id &&
                Objects.equals(lastName, profile.lastName) &&
                Objects.equals(firstName, profile.firstName) &&
                Objects.equals(secondName, profile.secondName) &&
                Objects.equals(gender, profile.gender) &&
                Objects.equals(birthDate, profile.birthDate) &&
                Objects.equals(country, profile.country) &&
                Objects.equals(zipCode, profile.zipCode) &&
                Objects.equals(streetAddress, profile.streetAddress) &&
                Objects.equals(city, profile.city) &&
                Objects.equals(phone, profile.phone) &&
                Objects.equals(cellPhone, profile.cellPhone) &&
                Objects.equals(email, profile.email) &&
                Objects.equals(notes, profile.notes) &&
                Objects.equals(company, profile.company) &&
                Objects.equals(jobTitle, profile.jobTitle) &&
                Objects.equals(lang, profile.lang) &&
                Objects.equals(passport, profile.passport) &&
//                Objects.equals(validTill, profile.validTill) &&
                Objects.equals(cardType, profile.cardType) &&
                Objects.equals(cardStatus, profile.cardStatus) &&
//                Objects.equals(magstripe, profile.magstripe) &&
                Objects.equals(udfs1, profile.udfs1) &&
                Objects.equals(privacyOptions, profile.privacyOptions) &&
                Objects.equals(picture, profile.picture);
//                Objects.equals(password, profile.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, secondName, gender, birthDate, country, zipCode, streetAddress, city, phone, cellPhone, email, notes, company, jobTitle, lang, passport, cardType, cardStatus, udfs1, privacyOptions, picture);
    }


}

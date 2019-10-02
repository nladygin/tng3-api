package tng3.api.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tng3.api.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
    public HashMap<String, Boolean> privacyOptions;
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
                   String picture,
                   String password) {
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
        this.phone          = (phone == null) ? String.valueOf(utils.generateDigits(11)) : phone;
        this.cellPhone      = (cellPhone == null) ? String.valueOf(utils.generateDigits(11)) : cellPhone;
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
    }


    public Profile(LinkedHashMap<String, Object> o){
        this(
                (int) o.get("id"),
                (String) o.get("lastName"),
                (String) o.get("firstName"),
                (String) o.get("secondName"),
                (String) o.get("gender"),
                (String) o.get("birthDate"),
                (String) o.get("country"),
                (String) o.get("zipCode"),
                (String) o.get("streetAddress"),
                (String) o.get("city"),
                (String) o.get("phone"),
                (String) o.get("cellPhone"),
                (String) o.get("email"),
                (String) o.get("notes"),
                (String) o.get("company"),
                (String) o.get("jobTitle"),
                (String) o.get("lang"),
                (String) o.get("passport"),
                (String) o.get("validTill"),
                (String) o.get("cardType"),
                (String) o.get("cardStatus"),
                (String) o.get("magstripe"),
                (String) o.get("udfs1"),
                (String) o.get("picture"),
                "123"
        );
    }



    public Profile(){
        this(0,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null);
    }



    @Override
    public String asJsonString() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String json = null;
        try {
            json = mapper.writeValueAsString(this);
        } catch (IOException e) {
            log.error(e.getStackTrace());
        }
        return json;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(lastName, profile.lastName) &&
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
                Objects.equals(passport, profile.passport) &&
//                Objects.equals(validTill, profile.validTill) &&
                Objects.equals(cardType, profile.cardType) &&
                Objects.equals(cardStatus, profile.cardStatus) &&
//                Objects.equals(magstripe, profile.magstripe) &&
                Objects.equals(udfs1, profile.udfs1) &&
                Objects.equals(privacyOptions, profile.privacyOptions) &&
                Objects.equals(picture, profile.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, secondName, gender, birthDate, country, zipCode, streetAddress, city, phone, cellPhone, email, notes, company, jobTitle, passport, validTill, cardType, cardStatus, magstripe, udfs1, privacyOptions, picture, password);
    }





    class PrivacyOptions extends HashMap<String, Boolean> {

        public PrivacyOptions(){
            this.put("allowEmail", true);
            this.put("allowSMS", false);
            this.put("allowPush", true);
        }
    }


    private Utils utils = new Utils();
    private final Logger log = LogManager.getLogger();
}

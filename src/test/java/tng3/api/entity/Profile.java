package tng3.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;


@Configuration
@PropertySource({"data.properties"})
public class Profile implements Entity {

    @JsonIgnore
    @Value("${profile}")
    private String data;

    private final Logger log = LogManager.getLogger();


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
    public String passport;
    public String validTill;
    public String cardType;
    public String cardStatus;
    public String magstripe;
    public String udfs1;
    public HashMap<String, Boolean> privacyOptions;
    public String picture;
    public String password;





    @PostConstruct
    public void init() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            this.lastName           = mapper.readValue(data, Profile.class).lastName;
            this.firstName          = mapper.readValue(data, Profile.class).firstName;
            this.secondName         = mapper.readValue(data, Profile.class).secondName;
            this.secondName         = mapper.readValue(data, Profile.class).gender;
            this.birthDate          = mapper.readValue(data, Profile.class).birthDate;
            this.country            = mapper.readValue(data, Profile.class).country;
            this.zipCode            = mapper.readValue(data, Profile.class).zipCode;
            this.streetAddress      = mapper.readValue(data, Profile.class).streetAddress;
            this.city               = mapper.readValue(data, Profile.class).city;
            this.phone              = mapper.readValue(data, Profile.class).phone;
            this.cellPhone          = mapper.readValue(data, Profile.class).cellPhone;
            this.email              = mapper.readValue(data, Profile.class).email;
            this.notes              = mapper.readValue(data, Profile.class).notes;
            this.company            = mapper.readValue(data, Profile.class).company;
            this.jobTitle           = mapper.readValue(data, Profile.class).jobTitle;
            this.passport           = mapper.readValue(data, Profile.class).passport;
            this.validTill          = mapper.readValue(data, Profile.class).validTill;
            this.cardType           = mapper.readValue(data, Profile.class).cardType;
            this.cardStatus         = mapper.readValue(data, Profile.class).cardStatus;
            this.magstripe          = mapper.readValue(data, Profile.class).magstripe;
            this.udfs1              = mapper.readValue(data, Profile.class).udfs1;
            this.privacyOptions     = mapper.readValue(data, Profile.class).privacyOptions;
            this.password           = mapper.readValue(data, Profile.class).password;
        } catch (IOException e) {
            log.error(e.getStackTrace().toString());
        }
    }


    @Override
    public String asJsonString() {
        return data;
    }




/*
    @Value("${profile.lastName}")           private String lastName;
    @Value("${profile.firstName}")          private String firstName;
    @Value("${profile.secondName}")         private String secondName;
    @Value("${profile.gender}")             private String gender;
    @Value("${profile.birthDate}")          private String birthDate;
    @Value("${profile.country}")            private String country;
    @Value("${profile.zipCode}")            private String zipCode;
    @Value("${profile.streetAddress}")      private String streetAddress;
    @Value("${profile.city}")               private String city;
    @Value("${profile.phone}")              private String phone;
    @Value("${profile.cellPhone}")          private String cellPhone;
    @Value("${profile.email}")              private String email;
    @Value("${profile.notes}")              private String notes;
    @Value("${profile.company}")            private String company;
    @Value("${profile.jobTitle}")           private String jobTitle;
    @Value("${profile.passport}")           private String passport;
    @Value("${profile.validTill}")          private String validTill;
    @Value("${profile.cardType}")           private String cardType;
    @Value("${profile.cardStatus}")         private String cardStatus;
    @Value("${profile.magstripe}")          private String magstripe;
    @Value("${profile.udfs1}")              private String udfs1;
    @Value("#{${profile.privacyOptions}}")  private HashMap<String, Boolean> privacyOptions;
    @Value("${profile.password}")           private String password;





    public String asJsonString() {
        String privacyOpt;
        try {
            privacyOpt = new ObjectMapper().writeValueAsString(privacyOptions);
        } catch (JsonProcessingException e) {
            privacyOpt = "";
        }
            return
                    "{" +
                            "\"lastName\":\"" + lastName + salt + "\"," +
                            "\"firstName\":\"" + firstName + "\"," +
                            "\"secondName\":\"" + secondName + "\"," +
                            "\"gender\":\"" + gender + "\"," +
                            "\"birthDate\":\"" + birthDate + "\"," +
                            "\"country\":\"" + country + "\"," +
                            "\"zipCode\":\"" + zipCode + "\"," +
                            "\"streetAddress\":\"" + streetAddress + "\"," +
                            "\"city\":\"" + city + "\"," +
                            "\"phone\":\"" + phone + salt + "\"," +
                            "\"cellPhone\":\"" + cellPhone + salt + "\"," +
                            "\"email\":\"" + email + "\"," +
                            "\"notes\":\"" + notes + "\"," +
                            "\"company\":\"" + company + "\"," +
                            "\"jobTitle\":\"" + jobTitle + "\"," +
                            "\"passport\":\"" + passport + "\"," +
                            "\"validTill\":\"" + validTill + "\"," +
                            "\"cardType\":\"" + cardType + "\"," +
                            "\"cardStatus\":\"" + cardStatus + "\"," +
                            "\"magstripe\":\"" + magstripe + salt + "\"," +
                            "\"udfs1\":\"" + udfs1 + "\"," +
                            "\"privacyOptions\":" + privacyOpt +
                    "}";
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Profile(){}

 */
}

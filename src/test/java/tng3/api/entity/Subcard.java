package tng3.api.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tng3.api.Utils;

import java.io.IOException;
import java.util.Objects;

public class Subcard implements Entity {

    public int id;
    public String name;
    public String cardType;
    public String magstripe;
    public String birthDate;
    public String validTill;



    public Subcard(
                    int id,
                    String name,
                    String cardType,
                    String magstripe,
                    String birthDate,
                    String validTill
                   ) {
        this.id         = id;
        this.name       = (name == null) ? "subcard " + utils.generateDigits() : name;
        this.cardType   = (cardType == null) ? "default" : cardType;
        this.magstripe  = (magstripe == null) ? "autoMS" + utils.generateDigits(6) : magstripe;
        this.birthDate  = (birthDate == null) ? utils.generateDate("YYYY-MM-dd", -365*20)  : birthDate;
        this.validTill  = (validTill == null) ? utils.generateDate("YYYY-MM-dd", 365)  : validTill;
    }

    public Subcard(){
        this(0,null,null,null,null,null);
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
        Subcard subcard = (Subcard) o;
        return
                Objects.equals(name, subcard.name) &&
                Objects.equals(cardType, subcard.cardType) &&
                Objects.equals(magstripe, subcard.magstripe) &&
                Objects.equals(birthDate, subcard.birthDate) &&
                Objects.equals(validTill, subcard.validTill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cardType, magstripe, birthDate, validTill);
    }



    private Utils utils = new Utils();
    private final Logger log = LogManager.getLogger();
}
